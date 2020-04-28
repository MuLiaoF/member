package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.common.enums.ErrorCode;
import cn.wandingkeji.common.utils.WriteOff;
import cn.wandingkeji.common.utils.WriteOffBean;
import cn.wandingkeji.service.coupon.IReceiveCouponService;
import cn.wandingkeji.service.coupon.IWriteOffCouponService;
import com.member.weixin.api.mp.protocol.manageCard.in.QueryCodeReq;
import com.member.weixin.api.mp.protocol.manageCard.out.QueryCodeRes;
import com.member.weixin.api.mp.protocol.verification.offline.ConsumeCodeReq;
import com.member.weixin.api.mp.protocol.verification.offline.ConsumeCodeRes;
import com.member.weixin.api.mp.service.ConsumeCodeService;
import com.member.weixin.api.mp.service.QueryCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 核销卡券业务处理
 * @author jing_huan
 *
 */
@Slf4j
@Service("writeOffCouponService")
public class WriteOffCouponServiceImpl implements IWriteOffCouponService {

	@Autowired
	private IReceiveCouponService receiveCouponService;

	//@Autowired
	//private GetTokenUtilService getTokenUtilService;
	
	/**
	 *平台核销步骤
	 *<br> 1.对平台业务逻辑判断(根据code cardid 查询自有平台的券是否可核销)
	 *<br>	1.1 可核销,调用获取token接口
	 *<br>  1.2不可核销, 直接返回
	 *<br> 2.调用微信查询核销劵接口
	 *<br> 3.根据步骤2 对业务数据进行处理
	 *<br> 	3.1 微信核销成功, 调用更新领劵记录状态的原子方法
	 *<br>  3.2微信核销失败,返回核销失败
	 * @param code
	 * @param cardId
	 * @param mid
	 * @return
	 */
	/*@Override
	public Map<String,Object> checkCoupon(String code,String cardId,int mid,String tokenUrl){
		log.info("核销入参 ***code="+code+"  cardId="+cardId +"  mid="+mid +"  tokenUrl="+tokenUrl);
		Map<String,Object> returnMap = new HashMap<>();
		try {
			//1.TODO对平台业务逻辑判断  code cardId status
			Map<String, Object> couponMap = new HashMap<>();
			couponMap.put("code", code);
			couponMap.put("card_id", cardId);
			couponMap.put("status", WriteOff.STA1.getSta());
			WdReceiveCoupon wrcoupon = receiveCouponService.selectByCodeCardId(couponMap);
			if (wrcoupon != null) {
				if (WriteOff.STA2.getSta().equals(wrcoupon.getStatus())) {
					returnMap.put("subCode", "100000");
					returnMap.put("subMsg", "不可核销");
					return returnMap;
				}
			}
			//1.2TODO 获取token
			String token = "";
			AccessTokenRes accessTokenRes = getTokenUtilService.getToken(mid, tokenUrl,
					AccessTokenType.TYPE_42.getType());
			token = accessTokenRes.getAccessToken();
			//2.调用微信查询核销劵接口
			WriteOffBean writeOffCoupon = WriteOffCoupon(code, cardId, token);
			//3.根据第二部结果对业务数据进行处理
			//3.1  调用更新领劵记录状态的原子方法
			int errcode = writeOffCoupon.getErrcode();
			if (Errcode.SUCCESS.getSta() == errcode && wrcoupon != null) {
				WdReceiveCoupon wrc = new WdReceiveCoupon();
				wrc.setId(wrcoupon.getId());
				wrc.setStatus(WriteOff.COU2.getSta());
				receiveCouponService.updateById(wrc);
			} else {
				if (Errcode.SUCCESS.getSta() == errcode && wrcoupon == null) {
					//TODO 可核销状态,但领券记录表中没有记录

				} else {
					returnMap.put("subCode", "100000");
					returnMap.put("subMsg", "调用微信核销接口失败");
					return returnMap;
				}
			}
		} catch (Exception e) {
			log.info("***核销异常***");
			log.error(ExceptionUtils.getStackTrace(e));
		}
		return returnMap;
	}*/
	
	/**
	 * 微信核销卡券步骤<br>
	 * 1.在调用核销code接口之前调用查询code接口，并在核销之前对非法状态的code(如转赠中、已删除、已核销等)做出处理)<br>
	 * 2.根据查询结果调用核销接口<br>
	 * 	2.1 <br>
	 *  2.2 <br>
	 */
	@Override
	public WriteOffBean WriteOffCoupon(String code,String cardId,String token) {
		WriteOffBean returnBean = new WriteOffBean();
		try {
			//1.调用查询code接口
			QueryCodeReq queryCodeReq =new QueryCodeReq();
			if(StringUtils.isNotBlank(cardId)) {
				queryCodeReq.setCard_id(cardId);
			}
			queryCodeReq.setCode(code);
			queryCodeReq.setCheck_consume(false);
			QueryCodeService queryCodeService = new QueryCodeService(token);
			QueryCodeRes request = queryCodeService.request(queryCodeReq);
			//2.根据查询结果调用核销接口
			String queryErrCode = request.getErrcode();
			if(WriteOff.ERRCODE.getSta().equals(queryErrCode)&&request.isCan_consume()) {
				//可核销
				ConsumeCodeReq consumeCodeReq = new ConsumeCodeReq();
				consumeCodeReq.setCode(code);
				if(StringUtils.isNotBlank(cardId)) {
					consumeCodeReq.setCard_id(cardId);
				}
				ConsumeCodeService consumeCodeService = new ConsumeCodeService(token);
				ConsumeCodeRes consumeCodeRes =	consumeCodeService.request(consumeCodeReq);
				String errcode = consumeCodeRes.getErrcode();
				if(WriteOff.ERRCODE.getSta().equals(errcode)) {
					returnBean.setErrcode(ErrorCode.SUCCESS.getErrorCode());
					returnBean.setErrmsg(consumeCodeRes.getErrmsg());
				}else {
					returnBean.setErrcode(ErrorCode.DEFAULT_ERROR.getErrorCode());
					returnBean.setErrmsg(consumeCodeRes.getErrmsg());
				}
			}else {
				returnBean.setErrcode(ErrorCode.DEFAULT_ERROR.getErrorCode());
				returnBean.setErrmsg("不可核销");
			}
		}catch(Exception e) {
			
		}
		return returnBean;
	}

}
