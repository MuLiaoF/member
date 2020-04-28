package cn.wandingkeji.common.base.wx.mp.business;

import cn.wandingkeji.common.base.wx.mp.protocol.store.in.GetStoreInfoReq;
import cn.wandingkeji.common.base.wx.mp.protocol.store.out.GetStoreInfoRes;
import cn.wandingkeji.common.base.wx.mp.service.PosGetStoreInfoService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

/*
 * 查询门店信息business
 * add by ws 0513
 */
public class GetStoreInfoBusiness {

    private String access_token;
    private PosGetStoreInfoService posGetStoreInfoService;
    private static Log log = new Log();

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public PosGetStoreInfoService getPosGetStoreInfoService() {
        return posGetStoreInfoService;
    }

    public void setPosGetStoreInfoService(PosGetStoreInfoService posGetStoreInfoService) {
        this.posGetStoreInfoService = posGetStoreInfoService;
    }

    public GetStoreInfoBusiness(String access_token) {
        this.access_token = access_token;
        posGetStoreInfoService = new PosGetStoreInfoService(access_token);
    }

    public GetStoreInfoRes run(GetStoreInfoReq getStoreInfoReq) {


        // 读取参数


        long costTimeStart = System.currentTimeMillis();
        String responseContent = posGetStoreInfoService.request(getStoreInfoReq);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent==" + responseContent);

        GetStoreInfoRes getStoreInfoRes = (GetStoreInfoRes) JSON.parseObject(responseContent, GetStoreInfoRes.class);
        log.i("结果可返回");
        if (getStoreInfoRes == null || getStoreInfoRes.getErrcode() == null) {
            log.e("【查询门店信息通知失败】查询门店信息通知请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR, "请检测数据是否规范合法");
        }

    /*    if (!getStoreInfoRes.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【查询门店信息通知失败】查询门店信息通知API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL,"请检测数据是否规范合法");
        } else {        
        	 log.i("创建会员卡通知API系统成功返回数据");
        	 return getStoreInfoRes;
        }*/
        return getStoreInfoRes;
    }
}
