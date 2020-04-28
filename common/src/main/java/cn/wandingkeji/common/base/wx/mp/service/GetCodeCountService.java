package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.GetCodeCountReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code.GetCodeCountRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 查询导入code数目接口
 */
public class GetCodeCountService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(GetCodeCountService.class);

    public GetCodeCountService(String access_token) {
        super(WeiXinConstant.WX_GET_CODE_COUNT + access_token);
    }

    /**
     * 查询导入code数目接口
     *
     * @return API返回的JSON数据
     */
    public GetCodeCountRes request(GetCodeCountReq getCodeCountReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(getCodeCountReq);

        log.info("==responseContent==" + responseString);
        GetCodeCountRes depositCodeRes = (GetCodeCountRes) JSON.parseObject(responseString, GetCodeCountRes.class);
        return depositCodeRes;
    }

}
