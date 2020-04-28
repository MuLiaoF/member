package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.card.mapper.WdMemCardMapper;
import cn.wandingkeji.member.api.WdMemBalanceApi;
import cn.wandingkeji.member.api.WdMemberApi;
import cn.wandingkeji.service.card.IWdMemCardService;
import com.member.weixin.api.mp.business.ActivationBusiness;
import com.member.weixin.api.mp.business.GetUserInfoBusiness;
import com.member.weixin.api.mp.protocol.activation.ActivationMemCardReq;
import com.member.weixin.api.mp.protocol.activation.ActivationMemCardRes;
import com.member.weixin.api.mp.protocol.activation.GetUserInfoReq;
import com.member.weixin.api.mp.protocol.activation.GetUserInfoRes;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会员卡基础实现
 * 
 * @author jing_huan
 * @date 2019年5月17日
 *
 */
@Service("wdMemCardService")
public class WdMemCardServiceImpl implements IWdMemCardService {
	private static final Logger log = LoggerFactory.getLogger(WdMemCardServiceImpl.class);

	@Autowired
	private WdMemberApi wdMemberService;

	@Autowired
	private WdMemBalanceApi wdMemBalanceService;

	@Autowired
	private WdMemCardMapper wdMemCardMapper;
	
	/*
	TODO
	@Override
	public Map<String, Object> WdActivationMember(Map<String, Object> requestMap, Map<String, Object> oldUserInfo) {
		log.info("激活会员卡业务入参(WdActivationMember):===="+requestMap);
		Map<String, Object> returnMap = new HashMap<>();
		String cardId = (String) requestMap.get("CardId");//
		String code = (String) requestMap.get("UserCardCode");
		String openId = (String) requestMap.get("FromUserName");
		//TODO  获取token
		String token=null;
		String memNum=null;
		if(oldUserInfo!=null){
			memNum=(String) oldUserInfo.get("memNum");
		}
		log.info("绑定老会员的会员卡号"+memNum);
		//查询数据库中的会员信息
		WdMemCard memCard=selectByWxCardId(cardId);
		WdMember member = wdMemberService.queryWdMember(cardId, code, openId);
		// 调用拉取会员信息接口
		GetUserInfoRes getUserInfoRes = getUserInfo(cardId, code ,token);
		
		//为空 添加会员信息
		if(member==null){
			//1.调用激活接口,激活会员卡
			ActivationMemCardRes activationMemCardRes = activationCard(cardId, code,memNum,token);
			if (activationMemCardRes.getErrcode().equals("0") && activationMemCardRes.getErrmsg().equals("ok")) {
				if (getUserInfoRes.getErrcode().equals("0") && getUserInfoRes.getErrmsg().equals("ok")) {
					member = wdMemberService.insertMember(oldUserInfo, cardId, code, memCard, getUserInfoRes);
				}
			}
		}else {
			//不为空 更新会员信息 (此情有会员卡,删除卡之后重新找回)
			//调用激活接口,激活会员卡
			if("0".equals(member.getLoc_status())){
				 activationCard(cardId, code,memNum,token);
			}
			// 更新会员表，根据hasActive的值插入到账户表
			member = wdMemberService.updateMenber(oldUserInfo, cardId, code, memCard, member, getUserInfoRes);
		
		}
		//创建会员账户
		
		//wdMemAccountService.insertWdMemAccount(member, getUserInfoRes, memCard, cardId, code);
		wdMemBalanceService.insertWdMemBalance(member, getUserInfoRes, memCard, cardId, code);
		log.info("激活会员卡业务出参(WdActivationMember):===="+returnMap);
		
		return returnMap;
	}*/
	/**
	 * 拉取会员信息接口
	 * @param cardId
	 * @param code
	 * @param token
	 * @return
	 */
	@Override
	public GetUserInfoRes getUserInfo(String cardId, String code, String token){
		GetUserInfoReq getUserInfoReq=new GetUserInfoReq();
		getUserInfoReq.setCard_id(cardId);
		getUserInfoReq.setCode(code);
		GetUserInfoBusiness GetUserInfoBusiness=new GetUserInfoBusiness(token);
		GetUserInfoRes getUserInfoRes = GetUserInfoBusiness.run(getUserInfoReq);
		return getUserInfoRes;
	}
	
	@Override
	public WdMemCard selectById(int id) {
		
		return wdMemCardMapper.selectById(id);
	}

	@Override
	public int updateById(WdMemCard wdMemCard) {
		
		return wdMemCardMapper.updateById(wdMemCard);
	}

	@Override
	public int deleteById(int id) {
		
		return wdMemCardMapper.deleteById(id);
	}

	@Override
	public int insert(WdMemCard wdMemCard) {
		
		return wdMemCardMapper.insert(wdMemCard);
	}

	@Override
	public WdMemCard selectByWxCardId(String wxCardId) {
		
		return wdMemCardMapper.selectByWxCardId(wxCardId);
	}

	/**
	 * 获取token 调用激活接口..........
	 * 调用 激活会员卡接口
	 * @param cardId
	 * @param code
	 * @param memNum
	 * @return
	 */
	@Override
	public ActivationMemCardRes activationCard(String cardId, String code, String memNum, String token){
		ActivationMemCardReq activationMemCardReq=new ActivationMemCardReq();
		WdMemCard memCard=wdMemCardMapper.selectByWxCardId(cardId);
		int useCustomCode=memCard.getUse_custom_code();
    	
    	String supplyOldBind = memCard.getSupply_old_bind();
    	if(StringUtils.isNotEmpty(memNum)&&supplyOldBind.equals("1")){
    		activationMemCardReq.setMembership_number(memNum);
    	}else{
    		if(useCustomCode==0){
        		activationMemCardReq.setMembership_number(code);
        	}else{
        		//TODO 自定义
        		activationMemCardReq.setMembership_number(code);
        	}
    	}
    	activationMemCardReq.setCode(code);
    	activationMemCardReq.setCard_id(cardId);
    	if(StringUtils.isNotEmpty(memCard.getBackground_pic_url())){
    		activationMemCardReq.setBackground_pic_url(memCard.getBackground_pic_url());	
    	}
    	//获取token 调用激活接口..........
    	ActivationBusiness activationBusiness = new ActivationBusiness(token);
    	
    	ActivationMemCardRes activationMemCardRes=activationBusiness.run(activationMemCardReq);
		return activationMemCardRes;
    	
	}
	@Override
	public WdMemCard queryByWxCardId(String wxCardId) {
		
		return wdMemCardMapper.queryByWxCardId(wxCardId);
	}

}
