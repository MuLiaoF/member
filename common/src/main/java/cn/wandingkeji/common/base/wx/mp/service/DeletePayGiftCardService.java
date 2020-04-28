package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.DeleteDeliveryByPayReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.DeleteDeliveryByPayRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * add by ws 0520
 * 更新会员
 */
public class DeletePayGiftCardService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(DeletePayGiftCardService.class);

    public DeletePayGiftCardService(String access_token) {
        super(WeiXinConstant.WX_DELETE_PAY_GIFT + access_token);
    }

    /**
     * 删除支付后投放卡券规则
     *
     * @param deleteDeliveryByPayReq 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的JSON数据
     */
    public DeleteDeliveryByPayRes request(DeleteDeliveryByPayReq deleteDeliveryByPayReq) {
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(deleteDeliveryByPayReq);
//	        log.info("==responseContent=="+responseString);
        DeleteDeliveryByPayRes deletePayGiftRes = (DeleteDeliveryByPayRes) JSON.parseObject(responseString, DeleteDeliveryByPayRes.class);
        return deletePayGiftRes;
    }

}
