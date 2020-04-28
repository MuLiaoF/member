package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.member.UpdateUserReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * add by ws 0520
 * 更新会员
 */
public class PosUpdateUserService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(PosUpdateUserService.class);

    public PosUpdateUserService(String access_token) {
        super(WeiXinConstant.WX_UPDATE_USER + access_token);
    }

    /**
     * 请求一键激活会员卡服务
     *
     * @param updateUserReq 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的JSON数据
     */
    public String request(UpdateUserReq updateUserReq) {
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(updateUserReq);
//	        log.info("==responseContent=="+responseString);
//	        UpdateUserRes checkCodeRes = (UpdateUserRes)  JSON.parseObject(responseString, UpdateUserRes.class);
        return responseString;
    }

}
