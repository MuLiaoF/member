package cn.wandingkeji.common.base.wx.mp.business;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.QueryCardStatusReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.QueryCardStatusRes;
import cn.wandingkeji.common.base.wx.mp.service.PosQueryCardStatusService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

/*
 * 查询卡卷状态
 * add by ws 0515
 */
public class QueryCardStatusBusiness {

    private String access_token;
    private PosQueryCardStatusService posQueryCardStatusService;
    private static Log log = new Log();

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public PosQueryCardStatusService getPosQueryCardStatusService() {
        return posQueryCardStatusService;
    }

    public void setPosQueryCardStatusService(PosQueryCardStatusService posQueryCardStatusService) {
        this.posQueryCardStatusService = posQueryCardStatusService;
    }

    public QueryCardStatusBusiness(String access_token) {
        this.access_token = access_token;
        posQueryCardStatusService = new PosQueryCardStatusService(access_token);
    }

    public QueryCardStatusRes run(QueryCardStatusReq queryCardStatusReq) {
        // 读取参数
        long costTimeStart = System.currentTimeMillis();
        String responseContent = posQueryCardStatusService.request(queryCardStatusReq);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent==" + responseContent);

        QueryCardStatusRes queryCardStatusRes = (QueryCardStatusRes) JSON.parseObject(responseContent, QueryCardStatusRes.class);
        if (queryCardStatusRes == null || queryCardStatusRes.getErrcode() == null) {
            log.e("【查看卡券详情接口通知失败】查看卡券详情接口通知请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR, "请检测数据是否规范合法");
        }
        if (!queryCardStatusRes.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【查看卡券详情接口通知失败】查看卡券详情接口通知API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL, "请检测数据是否规范合法");
        } else {
            log.i("查看卡券详情接口通知API系统成功返回数据");
            return queryCardStatusRes;
        }

    }

}
