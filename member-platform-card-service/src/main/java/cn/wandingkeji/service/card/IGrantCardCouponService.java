package cn.wandingkeji.service.card;

import com.member.weixin.api.mp.protocol.receive.MiniAddCard;

import java.util.List;
import java.util.Map;

/**
 * 投放卡劵业务处理
 *
 * @author 王森
 * @date 2019年5月17日
 */
public interface IGrantCardCouponService {

    /**
     * 初始化领取卡劵配置，获取jsapi_ticket
     * @param url
     * @param jsapiToken
     * @param appid
     * @param param
     * @return
     */
    Map<String, Object> getJsSdkConfig(String url, String jsapiToken, String appid, Map<String, Object> param);

    /**
     * 组装领卡参数
     * @param cardIdList
     * @param apiToken
     * @param outerStr
     * @return
     */
    List<MiniAddCard> getAddCardListConfig(List<String> cardIdList, String apiToken, String outerStr);

    /**
     * 初始化领卡参数
     * @param cardIdList
     * @param mid
     * @param outerStr
     * @param tokenUrl
     * @return
     */
    Map<String, Object> initReceiveConfig(List<String> cardIdList, int mid, String outerStr, String tokenUrl);

    Map<String, Object> receiveCardAfterPayment(String wdCardId, String outerStr, String getTokenUrl, Map<String, Object> param);

    Map<String, Object> addWxCardList(String wxCardId, String outerStr, String getTokenUrl);


}
