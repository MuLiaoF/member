package cn.wandingkeji.common.base.wx.mp.business;


import cn.wandingkeji.common.base.wx.mp.protocol.createQrCard.CreatQrCardReq;
import cn.wandingkeji.common.base.wx.mp.protocol.createQrCard.CreatQrCardRes;
import cn.wandingkeji.common.base.wx.mp.service.PosCreatQrService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

/*
 * 调用创建二维码business
 * add by ws 0513
 */
public class CreateQrCodeBusiness {

	private String access_token ;
	private PosCreatQrService posCreatQrService;
	private static Log log = new Log();
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	
	public PosCreatQrService getPosCreatQrService() {
		return posCreatQrService;
	}
	public void setPosCreatQrService(PosCreatQrService posCreatQrService) {
		this.posCreatQrService = posCreatQrService;
	}
	public CreateQrCodeBusiness(String access_token){
		this.access_token = access_token;
		posCreatQrService=new PosCreatQrService(access_token);
	}
	
	public CreatQrCardRes run(CreatQrCardReq creatQrCardReq){

		long costTimeStart = System.currentTimeMillis();
		String responseContent = posCreatQrService.request(creatQrCardReq);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent=="+responseContent);

        CreatQrCardRes creatQrCardRes = (CreatQrCardRes)  JSON.parseObject(responseContent, CreatQrCardRes.class);
        if (creatQrCardRes == null || creatQrCardRes.getErrcode() == null) {
            log.e("【创建二维码失败】创建二维码请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR,"请检测数据是否规范合法");
        }

        if (!creatQrCardRes.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【创建二维码失败】创建二维码API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL,"请检测数据是否规范合法");
        } else {        
        	 log.i("创建二维码API系统成功返回数据");
        	 return creatQrCardRes;
        	
        }
		
	}
	
	
}
