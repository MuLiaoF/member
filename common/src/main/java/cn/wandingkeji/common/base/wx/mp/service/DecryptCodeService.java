package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.DecryptCodeReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code.DecryptCodeRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 解密code数目接口
 */
public class DecryptCodeService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(DecryptCodeService.class);

    public DecryptCodeService(String access_token) {
        super(WeiXinConstant.WX_DECRYPT_CODE + access_token);
    }

    /**
     * 查询导入code数目接口
     *
     * @return API返回的JSON数据
     */
    public DecryptCodeRes request(DecryptCodeReq getCodeReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(getCodeReq);

        log.info("==responseContent==" + responseString);
        DecryptCodeRes getCodeRes = (DecryptCodeRes) JSON.parseObject(responseString, DecryptCodeRes.class);
        return getCodeRes;
    }

}
