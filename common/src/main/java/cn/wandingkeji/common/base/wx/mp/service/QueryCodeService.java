package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.QueryCodeReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.QueryCodeRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by ws 0605
 * 查询code接口
 */
public class QueryCodeService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(QueryCodeService.class);

    public QueryCodeService(String access_token) {
        super(WeiXinConstant.WX_QUERY_CODE + access_token);

    }

    /**
     * 查询code接口
     *
     * @return API返回的JSON数据
     */
    public QueryCodeRes request(QueryCodeReq queryCodeReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(queryCodeReq);
        log.info("==responseContent==" + responseString);
        QueryCodeRes queryCodeRes = (QueryCodeRes) JSON.parseObject(responseString, QueryCodeRes.class);
        return queryCodeRes;
    }

}
