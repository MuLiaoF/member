package cn.wandingkeji.common.base.wx.mp.business;


import cn.wandingkeji.common.base.wx.mp.protocol.activation.OneButtonActivationReq;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.OneButtonActivationRes;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.OptionalForm;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.RequiredForm;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CreatCardReq;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CreatCardRes;
import cn.wandingkeji.common.base.wx.mp.service.PosActivationCardService;
import cn.wandingkeji.common.base.wx.mp.service.PosCreatCardService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreatCardBusiness {
	

	private String access_token ;
	private PosCreatCardService posCreatCardService;
	private PosActivationCardService posActivationCardService;
	
	private static Log log = new Log();
	
	public CreatCardBusiness(String access_token) {
		// TODO Auto-generated constructor stub
		this.access_token = access_token;
		posCreatCardService = new PosCreatCardService(access_token);
		posActivationCardService = new PosActivationCardService(access_token);
		
		
	}

	public CreatCardRes run(Map<String, CreatCardReq> card){
		
		
		// 读取参数
	
		
		long costTimeStart = System.currentTimeMillis();
		String responseContent = posCreatCardService.request(card);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent=="+responseContent);

        CreatCardRes scanCraetCardResData = (CreatCardRes)  JSON.parseObject(responseContent, CreatCardRes.class);
        if (scanCraetCardResData == null || scanCraetCardResData.getErrcode() == null) {
            log.e("【创建会员卡通知失败】创建会员卡通知请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR,"请检测数据是否规范合法");
        }

        if (!scanCraetCardResData.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【创建会员卡通知失败】添加商户通知API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL,"请检测数据是否规范合法");
        } else {        
        	 log.i("创建会员卡通知API系统成功返回数据");
        	 //调用激活开卡字段设置   add by ws 0512
        	 String card_id=scanCraetCardResData.getCard_id();
        	 OneButtonActivationReq oneButtonActivationReq=new OneButtonActivationReq();
        	 oneButtonActivationReq.setCard_id(card_id);
        	/* String supplyOldBind = memCard.getSupply_old_bind();
        	
        	 if(supplyOldBind.equals("1")){
        		 Map<String,Object> bind_old_card = new HashMap<>();
            	 bind_old_card.put("name",memCard.getOld_mem_bind_name());
            	 bind_old_card.put("url", memCard.getOld_mem_bind_url());
            	 oneButtonActivationReq.setBind_old_card(bind_old_card);
        	 }*/
        	
        	 //必输字段
        	 RequiredForm requiredForm=new RequiredForm();
        	 requiredForm.setCan_modify(false);
        	 List<String> common_field_id_list=new ArrayList<>();
        	 common_field_id_list.add("USER_FORM_INFO_FLAG_NAME");
        	 common_field_id_list.add("USER_FORM_INFO_FLAG_MOBILE");
        	 requiredForm.setCommon_field_id_list(common_field_id_list);
        	 oneButtonActivationReq.setRequired_form(requiredForm);
        	 
        	//非必输字段
        	 OptionalForm optionalForm=new OptionalForm();
        	 optionalForm.setCan_modify(false);
        	 List<String> list=new ArrayList<>();
        	 list.add("USER_FORM_INFO_FLAG_BIRTHDAY");
        	 optionalForm.setCommon_field_id_list(list);
        	 oneButtonActivationReq.setOptional_form(optionalForm);
        	 log.d("设置开卡字段请求参数======"+oneButtonActivationReq.toString());
        	 String res=posActivationCardService.request(oneButtonActivationReq);
        	 OneButtonActivationRes oneButtonActivationRes = (OneButtonActivationRes)  JSON.parseObject(responseContent, OneButtonActivationRes.class);
        	 log.d("设置开卡字段请求结果======"+oneButtonActivationRes);
        	
        	 return scanCraetCardResData;
        	
        }
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public PosCreatCardService getPosCreatCardService() {
		return posCreatCardService;
	}
	public void setPosCreatCardService(PosCreatCardService posCreatCardService) {
		this.posCreatCardService = posCreatCardService;
	}

	public PosActivationCardService getPosActivationCardService() {
		return posActivationCardService;
	}

	public void setPosActivationCardService(PosActivationCardService posActivationCardService) {
		this.posActivationCardService = posActivationCardService;
	}

	
}
