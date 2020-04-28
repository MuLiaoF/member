package cn.wandingkeji.member.service;

import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.comm.enums.ScenceEnum;
import cn.wandingkeji.comm.enums.TransType;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.common.base.wx.mp.protocol.member.UpdateUserRes;
import cn.wandingkeji.member.entity.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 会员信息基础业务
 *
 * @author jing_huan
 * @date 2019年5月22日
 */

public interface IWdMemberService {
    /**
     * 会员验证密码
     *
     * @param memId
     * @param password
     * @return
     */
    boolean verifyMemPassword(int memId, String password);

    /**
     * 会员下单成功后更新余额/积分等相关信息
     *
     * @param memId
     * @param orderId
     * @param scence
     * @return
     */
    Map<String, Object> updateMemberConsumption(int memId, String orderId, String scence, String tokenUrl, String status);
    /**
     * 会员消费
     * @param openid
     * @param balance
     * @param order_id
     * @param sign(标识 1为消费,2暂为充值...)
     * @return
     */
    //Map<String,Object> memberConsumption(String orderId);

    /**
     * 同步微信会员信息
     *
     * @param bouns
     * @return
     */
    Map<String, Object> updateWX(BigDecimal bouns, String code, String card_id, String tokenUrl, int mid);

    Map<String, Object> updateWXBouns(String tokenUrl, int mid, BigDecimal bonus, BigDecimal addBonus, BigDecimal amount,
                                      BigDecimal addAmount, String card_id, String code, String scene, Map<String, Object> paramMap);

    WdMember selectMemByPrimaryKey(int id);

    /**
     * 根据条见查询会员信息
     *
     * @param cardId
     * @param code
     * @param openId
     * @return
     */
    WdMember queryWdMember(String cardId, String code, String openId);

    // TODO
    WdMember insertMember(Map<String, Object> oldUserInfo, String cardId, String code, WdMemCard memCard, GetUserInfoRes getUserInfoRes);

    // TODO
    WdMember updateMenber(Map<String, Object> oldUserInfo, String cardId, String code, WdMemCard memCard, WdMember member, GetUserInfoRes getUserInfoRes);

    //修改会员密码
    Map<String, Object> updateMemPwd(int memberId, String password, String mpwd, String mpwd2);

    //重置会员密码
    Map<String, Object> resetMemPwd(int memberId, String password);

    int insert(WdMember wdMember);

    WdMember selectMemByCondition(Map<String, Object> whereCondition);

    int selectMemberCount(Map<String, Object> whereCondition);

    List<Map<String, Object>> getMemberByPager(Map<String, Object> whereCondition, int offset, int pageSize);

    int updatePwdByPrimaryKey(WdMember wdMember);

    WdMember checkMemByCondition(Map<String, Object> whereCondition);

    int updateStatusByPrimaryKey(WdMember wdMember);

    int updateInfoByKey(WdMember wdMember);

    WdMember getMemberByMidAndCondition(Map<String, Object> whereCondition);

    int updateMemberPersonIdByPrimaryKey(WdMember wdMember);
	/*Map<String, Object> insertMemOrderRecord(int memId, int mid, int sid, int eid, String order_id, BigDecimal amount,
			String scence, String sourceType, Map<String, Object> paramMap);*/

    /**
     * 更新微信积分和余额
     *
     * @param memBonTrans
     * @param memBalTrans
     * @param tokenUrl
     * @return
     */
    UpdateUserRes updateWxBonusAndBalance(WdMemBonTrans memBonTrans, WdMemBalTrans memBalTrans, String tokenUrl);

    //Map<String, Object> updateWxBounsAndBalance(String orderId, PayStatusEnum payStatus, String tokenUrl);
    Map<String, Object> memRefund(String refundOrderId, String orderId, String tokenUrl);

    WdMember findMemIdByOpenId(String openId);

    Map<String, Object> addBonusToMember(WdMemBonus wdMemBonus, int sid, int eid, String orderId, BigDecimal bouns,
                                         ScenceEnum scence, TransType transType, Map<String, Object> paramMap);

    Map<String, Object> addBalanceToMember(WdMemBalance wdMemBalance, int sid, int eid, String orderId,
                                           BigDecimal amount, ScenceEnum scence, TransType transType, Map<String, Object> paramMap);

    WdMember insertMemberByReceiveCard(String cardId, String openId, String userCardCode, int mid, String levelId,
                                       String levelName, Integer sid, String empId);

    boolean updateWxLevel(String levelName, String cardId, String cardCode, String token) throws Exception;

    WdMember findMemInfo(String mdCode);

    String sysMember(String cardId, String code, String token);

    Map<String, Object> queryMemLevelInfo(Map<String, Object> whereCondition);

    Map<String, Object> selectMemDonate(Integer mid, int sid, Integer member_id);

    Map<String, Object> queryMemberBalance(Integer member_id);

    void updateMemDonates(Integer mid, int sid, Integer member_id, BigDecimal donateAmount,
                          BigDecimal sum_donate);

    Map<String, Object> getConsumerByOpenid(int member_id, int mid);

    //TODO
    //WdCardLevel queryWdCardById(int mid, String wx_card_id, Integer levelId);
    //TODO
    //WdCardLevel queryWdCardBySort(int mid, String wx_card_id, String id);
    void updateMemberInfo(int member_id, int mid, String currentLevel, String currLevelName);

    Map<String, Object> queryPushTokenId(int mid, String token_type);

    Map<String, Object> findByDataKey(String dataKey);

    void insertDonateAmounts(Integer mid, int sid, Integer member_id, BigDecimal donate_amount);

    List<Map<String, Object>> queryDonateAndBalanceInfo(int i);

    Map<String, Object> queryDonateInfo(int memberId, Integer mid, Integer sid);

    void updateDonateAmount(Map<String, Object> donateMap);

    //add by jh 2020/01/09  会员裂变赠送积分
    Map<String, Object> addBonusToInvitation(WdMemBonus wdMemBonus, int sid, int eid, String orderId, BigDecimal bouns,
                                             ScenceEnum scence, TransType transType, Map<String, Object> paramMap);
    //此方法以及迁移到system项目中wxsession业务方法中了
    //Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition);
}
