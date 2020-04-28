package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.WdCardLevel;
import cn.wandingkeji.common.http.GetTokenUtil;
import cn.wandingkeji.coupon.mapper.WdFrequencyCardMapper;
import cn.wandingkeji.member.api.WdMemberApi;
import cn.wandingkeji.merchant.api.MerchantApi;
import cn.wandingkeji.merchant.entity.Merchants;
import cn.wandingkeji.service.card.IMemCardService;
import cn.wandingkeji.service.card.IWdCardLevelService;
import cn.wandingkeji.token.entity.AccessTokenRes;
import com.alibaba.fastjson.JSONObject;
import com.member.weixin.api.mp.util.WeiXinConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service("memberUtilService")
public  class MemberUtilServiceImpl implements IMemCardService {
	
	private static final Logger log = LoggerFactory.getLogger(MemberUtilServiceImpl.class);
	
	static CookieStore cookieStore = null;
	
	@Autowired
	private WdFrequencyCardMapper wdFrequencyCardMapper;

	@Autowired
	private IWdCardLevelService wdCardLevelService;

	@Autowired
	private MerchantApi merchantApi;
	@Autowired
	private WdMemberApi memberApi;

	@Override
	public Map<String, Object>  judgeUpgradeMemCard(int mid, int member_id, BigDecimal amount) {
		Map<String, Object> memCumTransAmt = new HashMap<String, Object>();
		Map<String, Object> consumerMap = wdFrequencyCardMapper.getConsumerByOpenid(member_id, mid);

		log.info("------------会员信息  consumerMap : {}", consumerMap.toString());
        int memberId = consumerMap.get("id") != null ? (int)consumerMap.get("id") : null;
        String card_id = consumerMap.get("card_id") != null ? (String)consumerMap.get("card_id") : null;
        String card_barcode = consumerMap.get("card_barcode") != null ? (String)consumerMap.get("card_barcode") : null;
        String name = consumerMap.get("name") != null ? (String)consumerMap.get("name") : null;
        String level = consumerMap.get("level") != null ? (String)consumerMap.get("level") : null;
        log.info("------------会员更新z : {}, {} ,{}, {}, {}, {}", mid, memberId, card_id, card_barcode, name, amount);
        wdFrequencyCardMapper.updateMemBalance(mid, memberId, card_id, card_barcode, name, amount);
        String currentSort = wdFrequencyCardMapper.getCardLevel(mid, card_id, level);
        memCumTransAmt = wdFrequencyCardMapper.getCumTransAmt(memberId, card_id, card_barcode, name, mid);
        if (memCumTransAmt != null) {
        	memCumTransAmt.put("currentSort", currentSort);
        	memCumTransAmt.put("card_barcode", card_barcode);
		}
        return memCumTransAmt;
	}

	@Override
	public void updateMemLevelByAmtBalance(BigDecimal cum_trans_amt,int memberId,int mid, String currentSort, String card_barcode) {
    	try {
    		Merchants merchant = merchantApi.selectById(mid);
    		log.info("------------商铺信息z : {}", merchant.toString());
    		String isUpLevel = merchant.getReserve1();//升等级
    		log.info("------------商铺可支持升级z : {}", isUpLevel);
    		if("Y".equals(isUpLevel)) {
    			//根据当前账户的剩余积分匹配升等级规则，如果用户当前等级高于匹配等级，不降级。
    			Map<String,Object> whereCondition = new HashMap<>();
    			whereCondition.put("mid", mid);
    			whereCondition.put("cum_trans_amt", cum_trans_amt);
    			WdCardLevel cardLevel = wdCardLevelService.selectLevelByCumAmt(whereCondition);
    			log.info("------------会员匹配会员等级z : {}", cardLevel.toString());
    			String sort = cardLevel.getSort();
    			log.info("------------会员消费应该等级z {}, 会员当前会员等级 z {}", sort, currentSort);
    			if (Integer.valueOf(sort) > Integer.valueOf(currentSort)) {
    				String currentLevel = String.valueOf(cardLevel.getId());
    				String currLevelName = cardLevel.getLevel_name();
    				wdFrequencyCardMapper.updateMemberInfo(memberId, mid, currentLevel, currLevelName);
    				//会员升级，会员卡背景图换高等级会员图片
    				if (card_barcode != null && cardLevel.getCard_id() != null && cardLevel.getBackground_pic_url() != null) {
    					updataMemberCardInfo(card_barcode, mid, currentLevel, cardLevel.getCard_id(), cardLevel.getBackground_pic_url());
					}
    				else
    				{
    					log.info("会员信息card_barcode ： {} ,会员信息card_id ： {} ,会员信息pic_url ： {}", card_barcode, cardLevel.getCard_id(), cardLevel.getBackground_pic_url());
    				}
    			}
    			else
    			{
    				log.info("------------当前会员不需要升级 ");
    			}
    		}else {
    			//TODO 不需要升等级
    			log.info("商铺不支持会员升级！");
    		}
    		
    	}catch(Exception e) {   
    		log.error(ExceptionUtils.getStackTrace(e));
    	}
    }

	@Override
	public void updataMemberCardInfo(String card_barcode, int mid, String currentLevel, String card_id, String background_pic_url)
	{
		Map<String, Object> tokenMap = wdFrequencyCardMapper.queryPushTokenId(mid, "4");
		log.debug("发送tokenMap是 ： {}", tokenMap.toString());
		String token_id = tokenMap.get("token_id") != null ? String.valueOf(tokenMap.get("token_id")) : null;
		if (!StringUtils.isNotEmpty(token_id)) {
			log.debug("获取token失败！");
			return;
		}
		//从数据库获取tokenURL
		Map<String, Object> platformBaseData = wdFrequencyCardMapper.findByDataKey("TOKENURL");
		if (platformBaseData == null && !StringUtils.isNotEmpty((String)platformBaseData.get("data_value"))) {
			log.debug("发送从数据库获取的token URL Map 是null 或dataValue 是空： {}", tokenMap.toString());
			log.debug("获取token失败！");
			return;
		}
		log.debug("发送从数据库获取的token URL Map ： {}", tokenMap.toString());
		//获取tokenUrl
		String getTokenUrl = String.format((String)platformBaseData.get("data_value"), new Object[] { Integer.valueOf(token_id)});
		log.debug("发送getTokenUrl： {}", getTokenUrl);
		AccessTokenRes accessTokenRes = GetTokenUtil.request(getTokenUrl, AccessTokenRes.class);
		
		Map<String, String> requestWXMap = new HashMap<String, String>();
		requestWXMap.put("code", card_barcode);
		requestWXMap.put("card_id", card_id);
		requestWXMap.put("background_pic_url", background_pic_url);
		log.info("----requestWXMap is : {} ", requestWXMap.toString());
		
		String jsonString = JSONObject.toJSONString(requestWXMap);
		log.debug("会员升级，会员卡背景图更新 ：" + jsonString);
		
		//向微信发起推送模板请求
		String doPost = doPost(WeiXinConstant.WX_UPDATE_USER + accessTokenRes.getAccessToken(), JSONObject.parseObject(jsonString), null);
		log.debug("会员升级，会员卡背景图更新 , post结果 ： " + doPost);
		JSONObject message = JSONObject.parseObject(doPost);
		if(message.getString("errmsg").equals("ok")) {
			log.debug("发送成功");
		} else {
			String errmsg = message.getString("errmsg");
			log.info(errmsg);
			return;
		}
	}
	
	private String doPost(String url,JSONObject json,Map<String, String> headers) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            httpPost = new HttpPost(url);
            StringEntity s = null;
            if(null != json) {
                s = new StringEntity(json.toString(), "UTF-8");
            } else {
               s = new StringEntity("");
            }

            s.setContentEncoding("UTF-8");
            s.setContentType("application/x-www-form-urlencoded");//发送json数据需要设置contentType
            httpPost.setEntity(s);

            if(headers != null && headers.size() != 0) {
                packageHeader(headers, httpPost);
            }

            CloseableHttpResponse execute = httpClient.execute(httpPost);

            result = EntityUtils.toString(execute.getEntity());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
	
	private void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
		// 封装请求头
		if (params != null) {
			Set<Map.Entry<String, String>> entrySet = params.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				// 设置到请求头到HttpRequestBase对象中
				System.out.println(entry.getKey() + ": " + entry.getValue());
				httpMethod.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}
	
}
