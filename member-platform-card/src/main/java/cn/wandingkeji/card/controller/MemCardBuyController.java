package cn.wandingkeji.card.controller;

import cn.wandingkeji.card.entity.WdCardGoods;
import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.card.entity.WdReceiveCard;
import cn.wandingkeji.comm.enums.OuterStrType;
import cn.wandingkeji.comm.enums.PlatformEnum;
import cn.wandingkeji.comm.enums.ProductTypeEnum;
import cn.wandingkeji.common.http.PageRequestHelper;
import cn.wandingkeji.common.system.config.controller.AbstractRestController;
import cn.wandingkeji.common.system.config.data.RestApiResult;
import cn.wandingkeji.common.utils.StringCommonUtils;
import cn.wandingkeji.employee.api.EmployeeApi;
import cn.wandingkeji.employee.entity.Employee;
import cn.wandingkeji.service.card.IGrantCardCouponService;
import cn.wandingkeji.service.card.IReceiveCardService;
import cn.wandingkeji.service.card.IWdCardGoodsService;
import cn.wandingkeji.service.card.IWdMemCardService;
import cn.wandingkeji.session.api.WxSessionApi;
import cn.wandingkeji.session.entity.WxSession;
import cn.wandingkeji.system.api.PlatformBaseApi;
import cn.wandingkeji.system.entity.PlatformBaseData;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mini/card")
@Slf4j
public class MemCardBuyController extends AbstractRestController {

    @Autowired
    private EmployeeApi employeeApi;

    @Autowired
    private WxSessionApi wxSessionApi;

    @Autowired
    private IWdCardGoodsService wdCardGoodsService;

    @Autowired
    private IReceiveCardService receiveCardService;

    @Autowired
    private IWdMemCardService wdMemCardService;

	@Autowired
	private PlatformBaseApi platformBaseApi;

	@Autowired
	private IGrantCardCouponService grantCardCouponService;


	/*
	 * 会员卡商品查询
	 */
	@GetMapping(value = "/queryMemCardList")
	public @ResponseBody RestApiResult<Map<String, Object>> queryMemCardList(HttpServletRequest request) {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		try {
			Map<String, Object> requestMap = PageRequestHelper.prasePageRequestContent(request);
			log.debug("------------>"+requestMap);
			//是否购买Y/N
//			String isBuy = (String) requestMap.get("isBuy");
			int mid = 0;
			if(StringCommonUtils.getType(requestMap.get("mid")).equals("String")){
				mid = Integer.valueOf((String) requestMap.get("mid"));
			}else{
				mid = (int) requestMap.get("mid");
			}
			Map<String, Object> whereCondition = new HashMap<String, Object>();
			Integer sid = (Integer) requestMap.get("sid");
			String terminId = "";
			if(sid ==null){
				terminId = (String) requestMap.get("terminId");
				Employee employee = employeeApi.getEmployee(terminId);
				sid = employee.getSid();
				mid = employee.getMid();
				whereCondition.put("terminId",terminId);
			}
			whereCondition.put("sid", sid);
			whereCondition.put("mid", mid);
//			whereCondition.put("isBuy", isBuy);
			whereCondition.put("status", "Y");
			//会员卡商品列表比较少，暂时不分页。
			log.debug("aaaaa--->"+whereCondition);
			// aaaaa--->{outStr=POS, mid=6, terminId=13097, sid=23, status=Y}
			List<WdCardGoods> cardList = wdCardGoodsService.getWdCardGoodsByPager(whereCondition, 0, 20);
			List<WdCardGoods> card = new ArrayList<>();
			List<WdCardGoods> cardPos = new ArrayList<>();
			List<WdCardGoods> cardPss = new ArrayList<>();
			if(terminId != null){
				for (WdCardGoods  wdg:cardList) {
					if("0".equals(wdg.getOutStr())){
						cardPss.add(wdg);
					}else if(wdg.getOutStr().equals(terminId)) {
						//指定的
						card.add(wdg);
						cardPos.addAll(card);
					}else if(!wdg.getOutStr().equals(terminId)){
						//不是指定
					}
				}
				cardPos.addAll(cardPss);
				returnMap.put("productList", cardPos);
			}else{
				returnMap.put("productList", cardPos);
			}
			log.debug("aaaaa-->"+returnMap);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return failure("查询失败");
		}
		return success("查询成功", returnMap);
	}
	/*
	 *  免费初始化领卡参数
	 */
	@RequestMapping(value = "/receiveCardConfig")
	public @ResponseBody RestApiResult<Map<String, Object>> receiveCardConfig(HttpServletRequest request) {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		try {
			Map<String, Object> requestMap = PageRequestHelper.prasePageRequestContent(request);
			String sessionId = request.getHeader("sessionId");
			Map<String, Object> condition = new HashMap<>();
			condition.put("session", sessionId);
			WxSession wxSession = wxSessionApi.findBySession(condition);
			String cardId = (String) requestMap.get("cardId");
			Integer id = (Integer) requestMap.get("cardGoodsId");
			WdCardGoods wdCardGoods = wdCardGoodsService.selectByPrimaryKey(id);
			Integer sid = wdCardGoods.getSid();
//			int mid = (int) requestMap.get("mid");
			String unionId = wxSession.getReserve1();
			//通过unionId和cardid查询领卡记录
			Map<String,Object> receiveCondition = new HashMap<>();
			receiveCondition.put("unionId", unionId);
			receiveCondition.put("cardId", cardId);
			WdReceiveCard receiveCard = receiveCardService.selectByCondition(receiveCondition);
			if(receiveCard!=null) {
				returnMap.put("isMem", true);
				returnMap.put("cardId", cardId);
				returnMap.put("code", receiveCard.getUser_card_code());
				return success("已经领取过会员", returnMap);
			}
			WdMemCard wdMemCard = wdMemCardService.selectByWxCardId(cardId);
			int quantity = wdMemCard.getQuantity();
			if(quantity==0) {
				return failure("会员卡库存不足，请联系商家");
			}
			PlatformBaseData findByDataKey = platformBaseApi.findByDataKey(PlatformEnum.TOKENURL.getKey());
			String getTokenUrl = findByDataKey.getDataValue();

			String cardType = ProductTypeEnum.FC.getProCode();
//			String outerStr = OuterStrType.MFLK.getType();

			Map<String, Object> param=new HashMap<String, Object>();
			param.put("cardType", cardType);
			Map<String,Object> outerStrMap = new HashMap<>();
			outerStrMap.put(OuterStrType.MFLK.getType(), sid);
			String outerStr = JSON.toJSONString(outerStrMap);

			returnMap = grantCardCouponService.receiveCardAfterPayment(cardId, outerStr, getTokenUrl, param);
			returnMap.put("isMem", false);
			return success("初始化领卡参数成功", returnMap);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return failure("初始化领卡参数异常");
		}
	}
	
}
