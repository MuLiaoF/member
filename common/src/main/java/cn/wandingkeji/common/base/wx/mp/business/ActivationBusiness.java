package cn.wandingkeji.common.base.wx.mp.business;


import cn.wandingkeji.common.base.wx.mp.protocol.activation.ActivationMemCardReq;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.ActivationMemCardRes;
import cn.wandingkeji.common.base.wx.mp.service.PosActivationService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

/*
 * 激活business
 * add  by  ws 0513
 */
public class ActivationBusiness {

	private String access_token;
	
	
	private PosActivationService posActivationService;
	private static Log log = new Log();
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	
	public PosActivationService getPosActivationService() {
		return posActivationService;
	}
	public void setPosActivationService(PosActivationService posActivationService) {
		this.posActivationService = posActivationService;
	}
	public ActivationBusiness(String access_token) {
		// TODO Auto-generated constructor stub
		this.access_token = access_token;
		posActivationService = new PosActivationService(access_token);
	}
    public ActivationMemCardRes run(ActivationMemCardReq activationMemCardReq){
		
		
		// 读取参数
	
		
		long costTimeStart = System.currentTimeMillis();
		String responseContent = posActivationService.request(activationMemCardReq);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent=="+responseContent);

        ActivationMemCardRes activationMemCardRes = (ActivationMemCardRes)  JSON.parseObject(responseContent, ActivationMemCardRes.class);
        if (activationMemCardRes == null || activationMemCardRes.getErrcode() == null) {
            log.e("【激活接口通知失败】激活接口通知请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR,"请检测数据是否规范合法");
        }

        if (!activationMemCardRes.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【激活接口通知失败】激活接口通知API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL,"请检测数据是否规范合法");
        } else {        
        	 log.i("激活接口通知API系统成功返回数据");
        	
        	 
     
        	 return activationMemCardRes;
        }
		
	}

}
