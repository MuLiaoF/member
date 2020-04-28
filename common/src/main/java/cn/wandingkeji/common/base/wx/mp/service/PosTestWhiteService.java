package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.test.TestCreatCardReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;


/*
 * add by ws 0512
 * 一键激活
 */
public class PosTestWhiteService extends BaseAPIService {

    public PosTestWhiteService(String access_token) {
        super(WeiXinConstant.WX_TEST_WHITE + access_token);
        // TODO Auto-generated constructor stub
    }

    /**
     * 请求一键激活会员卡服务
     *
     * @param CreatCardReq 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的JSON数据
     */
    public String request(TestCreatCardReq testCreatCardReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(testCreatCardReq);

        return responseString;
    }

}
