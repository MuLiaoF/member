package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.ModifyStockReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 修改库存
 */
public class ModifyStockService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(ModifyStockService.class);

    public ModifyStockService(String access_token) {
        super(WeiXinConstant.WX_MODIFYSTOCK + access_token);
        // TODO Auto-generated constructor stub
    }

    /**
     * 修改库存
     *
     * @return API返回的JSON数据
     */
    public ResBaseData request(ModifyStockReq modifyStockReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(modifyStockReq);
        log.info("==responseContent==" + responseString);
        ResBaseData depositCodeRes = (ResBaseData) JSON.parseObject(responseString, ResBaseData.class);
        return depositCodeRes;
    }

}
