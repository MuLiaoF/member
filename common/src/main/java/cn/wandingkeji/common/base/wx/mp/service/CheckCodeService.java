package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.CheckCodeReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code.CheckCodeRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 核查code接口
 */
public class CheckCodeService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(CheckCodeService.class);

    public CheckCodeService(String access_token) {
        super(WeiXinConstant.WX_CHECK_CODE + access_token);
        // TODO Auto-generated constructor stub
    }

    /**
     * 核查code接口
     *
     * @return API返回的JSON数据
     */
    public CheckCodeRes request(CheckCodeReq checkCodeReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(checkCodeReq);
        log.info("==responseContent==" + responseString);
        CheckCodeRes checkCodeRes = (CheckCodeRes) JSON.parseObject(responseString, CheckCodeRes.class);
        return checkCodeRes;
    }

}
