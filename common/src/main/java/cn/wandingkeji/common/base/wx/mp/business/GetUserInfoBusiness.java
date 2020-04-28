package cn.wandingkeji.common.base.wx.mp.business;

import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoReq;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.common.base.wx.mp.service.PosGetUserInfoService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

/*
 * 调用拉取会员信息business
 * add by ws 0513
 */
public class GetUserInfoBusiness {

    private String access_token;
    private PosGetUserInfoService posGetUserInfoService;
    private static Log log = new Log();

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public PosGetUserInfoService getPosGetUserInfoService() {
        return posGetUserInfoService;
    }

    public void setPosGetUserInfoService(PosGetUserInfoService posGetUserInfoService) {
        this.posGetUserInfoService = posGetUserInfoService;
    }

    public GetUserInfoBusiness(String access_token) {
        this.access_token = access_token;
        posGetUserInfoService = new PosGetUserInfoService(access_token);
    }

    public GetUserInfoRes run(GetUserInfoReq getUserInfoReq) {

        long costTimeStart = System.currentTimeMillis();
        String responseContent = posGetUserInfoService.request(getUserInfoReq);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent==" + responseContent);

        GetUserInfoRes scanUserInfoResData = (GetUserInfoRes) JSON.parseObject(responseContent, GetUserInfoRes.class);
        if (scanUserInfoResData == null || scanUserInfoResData.getErrcode() == null) {
            log.e("【拉取会员信息通知失败】拉取会员信息通知请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR, "请检测数据是否规范合法");
        }

        if (!scanUserInfoResData.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【拉取会员信息通知失败】拉取会员信息通知API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL, "请检测数据是否规范合法");
        } else {
            log.i("拉取会员信息通知API系统成功返回数据");


            return scanUserInfoResData;

        }

    }


}
