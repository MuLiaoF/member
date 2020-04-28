package cn.wandingkeji.member.service.impl;

import cn.wandingkeji.balance.IWdMemBalTransService;
import cn.wandingkeji.balance.IWdMemBalanceService;
import cn.wandingkeji.bonus.service.IWdMemBonTransService;
import cn.wandingkeji.bonus.service.IWdMemBonusService;
import cn.wandingkeji.card.api.MemCardApi;
import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.comm.enums.AccessTokenType;
import cn.wandingkeji.comm.enums.PayStatusEnum;
import cn.wandingkeji.comm.enums.ScenceEnum;
import cn.wandingkeji.comm.enums.TransType;
import cn.wandingkeji.comm.utils.MD5Util;
import cn.wandingkeji.common.base.wx.mp.business.UpdateUserBusiness;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.UserInfo;
import cn.wandingkeji.common.base.wx.mp.protocol.member.UpdateUserReq;
import cn.wandingkeji.common.base.wx.mp.protocol.member.UpdateUserRes;
import cn.wandingkeji.common.base.wx.mp.protocol.member.UpdateUserSubReq;
import cn.wandingkeji.common.enums.ErrorCode;
import cn.wandingkeji.common.enums.Reason;
import cn.wandingkeji.common.utils.Constant;
import cn.wandingkeji.common.utils.PasswordEncoder;
import cn.wandingkeji.coupon.api.WdBindCodeApi;
import cn.wandingkeji.coupon.entity.WdBindCode;
import cn.wandingkeji.member.entity.*;
import cn.wandingkeji.member.mapper.WdMemberMapper;
import cn.wandingkeji.member.service.IWdMemberService;
import cn.wandingkeji.token.api.TokenApi;
import cn.wandingkeji.token.entity.AccessTokenRes;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员实现类
 *
 * @author jing_huan
 * @date 2019年5月22日
 */
@Service("wdMemberService")
public class WdMemberServiceImpl implements IWdMemberService {
    private static final Logger log = LoggerFactory.getLogger(WdMemberServiceImpl.class);

    @Autowired
    private WdMemberMapper wdMemberMapper;

    @Autowired
    private MemCardApi wdMemCardService;

    @Autowired
    private IWdMemBalanceService wdMemBalanceService;

    @Autowired
    private IWdMemBonusService wdMemBonusService;
    @Autowired
    private TokenApi tokenApi;
    @Autowired
    private IWdMemberService wdMemberService;
    @Autowired
    private IWdMemBalTransService wdMemBalTransService;
    @Autowired
    private IWdMemBonTransService wdMemBonTransService;

    @Autowired
    private WdBindCodeApi wdBindCodeApi;


    /*public static void main(String[] args) {
        String md5 = MD5Util.MD5("123456");
        System.out.println(md5);

    }*/

    /*
     * 更新会员卡积分和余额
     */
    /*@Override
    public Map<String, Object> updateWxBounsAndBalance(String orderId, PayStatusEnum payStatus, String tokenUrl) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            WdMemBalTrans memBalTrans = wdMemBalTransService.updateTransAndBalance(orderId, payStatus);
            //更新本地会员积分
            WdMemBonTrans memBonTrans = wdMemBonTransService.updateBonusAndTrans(orderId, payStatus);
      *//*      if(org.springframework.util.StringUtils.isEmpty(memBalTrans)){
               log.info("积分商城积分兑换！");
            }else{
                log.info("mem111111111--------->"+memBalTrans.getAmount());
                memBonTrans.setAmount(memBalTrans.getAmount().multiply(new BigDecimal("100")));
            }*//*
            log.info("更新微信积分和余额memBonTrans---------------------》"+memBonTrans);
            if (PayStatusEnum.SUCCESS.equals(payStatus)) {
                UpdateUserRes updateUserRes = updateWxBonusAndBalance(memBonTrans, memBalTrans, tokenUrl);
                log.info("更新微信账户返回参数{}", updateUserRes);
                if (updateUserRes != null && updateUserRes.getErrcode().equals("0") && updateUserRes.getErrmsg().equals("ok")) {
                    returnMap.put("subCode", Errcode.SUCCESS.getSta());
                    returnMap.put("msg", "微信账户信息更新成功");
                    returnMap.put("memBalTrans", memBalTrans);
                } else {
                    returnMap.put("subCode", ErrorCode.DEFAULT_ERROR.getErrorCode());
                    returnMap.put("msg", "微信账户信息更新失败");
                }
            } else {
                returnMap.put("subCode", Errcode.SUCCESS.getSta());
                returnMap.put("msg", "会员账户更新完成");
                returnMap.put("memBalTrans", memBalTrans);
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            returnMap.put("subCode", ErrorCode.DEFAULT_ERROR.getErrorCode());
            returnMap.put("msg", "会员账户信息更新失败");
        }
        return returnMap;
    }*/

    @Override
    public UpdateUserRes updateWxBonusAndBalance(WdMemBonTrans memBonTrans, WdMemBalTrans memBalTrans, String tokenUrl) {
        UpdateUserRes updateUserRes = null;
        try {
            if (memBonTrans == null && memBalTrans == null) {
                return null;
            }
            log.info("交易成功，需同步更新会员卡积分，余额信息");
            UpdateUserReq updateUserReq = new UpdateUserReq();
            int memberId = 0;
            int mid = 0;
            boolean updateWxMember = false;
            if (memBonTrans != null) {
                log.info("积分有变动，同步微信积分");
                updateWxMember = true;
                //查询会员卡，查询会员
                memberId = memBonTrans.getMember_id();
                mid = memBonTrans.getMid();
                String bonusTransType = memBonTrans.getTrans_type();
                String bounsScence = memBonTrans.getReason_id();
                BigDecimal amount = memBonTrans.getAmount();
                /*if(amount!=null){
                    amount = amount.divide(new BigDecimal("100"));
                }*/
                updateUserReq.setBonus(memBonTrans.getAccount_bouns().intValue());
                if (TransType.IN.getStatus().equals(bonusTransType)) {
                    //积分添加
                    updateUserReq.setAdd_bonus(memBonTrans.getBouns().intValue());
                } else {
                    updateUserReq.setAdd_bonus(0 - memBonTrans.getBouns().intValue());
                }
                if (ScenceEnum.SDH.getScence().equals(bounsScence)) {
                    updateUserReq.setRecord_bonus(ScenceEnum.SDH.getMsg() + ",使用" + memBonTrans.getBouns() + "积分");
                } else if (ScenceEnum.SCZ.getScence().equals(bounsScence)) {
                    updateUserReq.setRecord_bonus(ScenceEnum.SCZ.getMsg() + amount + "元" + ",赠送" + memBonTrans.getBouns() + "积分");
                } else if (ScenceEnum.CZZS.getScence().equals(bounsScence)) {
//                    updateUserReq.setRecord_bonus(ScenceEnum.CZZS.getMsg() + amount + "元" + ",赠送" + memBonTrans.getBouns() + "积分");
                    updateUserReq.setRecord_bonus(ScenceEnum.CZZS.getMsg() + "赠送" + memBonTrans.getBouns() + "积分");
                } else if (ScenceEnum.SXF.getScence().equals(bounsScence)) {
                    log.info("充值消费有礼amount-----》" + amount);
                    updateUserReq.setRecord_bonus(ScenceEnum.SXF.getMsg() + amount + "元" + ",赠送" + memBonTrans.getBouns() + "积分");
                } else if (ScenceEnum.LBZS.getScence().equals(bounsScence)) {
                    log.info("会员裂变赠送积分amount-----》" + amount);
                    updateUserReq.setRecord_bonus(ScenceEnum.LBZS.getMsg() + "赠送" + memBonTrans.getBouns() + "积分");
                } else if (ScenceEnum.FXCZJL.getScence().equals(bounsScence)) {
                    log.info("----------------会员CZ分销奖励积分----->>>>>>>>>>>>>");
                    updateUserReq.setRecord_bonus(ScenceEnum.FXCZJL.getMsg() + "奖励" + memBonTrans.getBouns() + "积分");
                } else if (ScenceEnum.FXXFJL.getScence().equals(bounsScence)) {
                    log.info("----------------会员XF分销奖励积分----->>>>>>>>>>>>>");
                    updateUserReq.setRecord_bonus(ScenceEnum.FXXFJL.getMsg() + "奖励" + memBonTrans.getBouns() + "积分");
                }
            } else {
                log.info("积分无变动，同步微信积分");
                memberId = memBalTrans.getMember_id();
                mid = memBalTrans.getMid();
            }
            WdMember member = wdMemberService.selectMemByPrimaryKey(memberId);
            WdMemCard memCard = wdMemCardService.getByWxCardId(member.getCard_id());
            String cardId = member.getCard_id();
            String cardCode = member.getCard_barcode();
            updateUserReq.setCard_id(cardId);
            updateUserReq.setCode(cardCode);
            int isSupBalance = memCard.getSupply_balance();
            if (memBalTrans != null) {
                log.info("余额有变动");
                if (isSupBalance == 1) {
                    log.info("余额有变动同步微信余额");
                    updateWxMember = true;
                    String balanceTransType = memBalTrans.getTrans_type();
                    updateUserReq.setBalance(memBalTrans.getAccount_balance().multiply(new BigDecimal(100)).intValue());
                    if (TransType.IN.getStatus().equals(balanceTransType)) {
                        // 会员卡充值
                        updateUserReq.setAdd_balance((memBalTrans.getAmount().multiply(new BigDecimal(100)).intValue()));
                        updateUserReq.setRecord_balance(ScenceEnum.SCZ.getMsg() + memBalTrans.getAmount() + "元");
                    } else {
                        // 充值
                        updateUserReq.setAdd_balance(0 - memBalTrans.getAmount().multiply(new BigDecimal(100)).intValue());
                        updateUserReq.setRecord_balance(ScenceEnum.SXF.getMsg() + memBalTrans.getAmount() + "元");
                    }
                } else {
                    log.info("余额有变动不需要同步微信");
                }

            }
         /*   if (updateUserReq.getBonus() == null && updateUserReq.getBalance() == null) {
                return null;
            }*/
            if (updateWxMember) {
                AccessTokenRes token = tokenApi.getToken(mid, tokenUrl, AccessTokenType.TYPE_4.getType());
                UpdateUserBusiness updateUserBusiness = new UpdateUserBusiness(token.getAccessToken());
                log.info("会员积分同步到微信---------------》" + updateUserBusiness);
                WdMemBonus wdMemBonus = wdMemBonusService.selectByMemId(memberId);
                updateUserReq.setBonus(wdMemBonus.getAccount_bouns().intValue());
                log.info("会员积分同步到微信-------参数--------》" + updateUserReq.toString());
                updateUserRes = updateUserBusiness.run(updateUserReq);
            } else {
                updateUserRes = new UpdateUserRes();
                updateUserRes.setErrcode("0");
                updateUserRes.setErrmsg("ok");
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return updateUserRes;


    }

    /*
     * 会员退款
     * add by ws
     * 20190626
     */
    @Override
    public Map<String, Object> memRefund(String refundOrderId, String orderId, String tokenUrl) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            //查询积分明细表和余额明细表
            WdMemBalTrans oldMemBalTrans = wdMemBalTransService.selectOneByOrderId(refundOrderId);

            if (oldMemBalTrans == null) {
                returnMap.put("status", ErrorCode.DEFAULT_ERROR.getErrorCode());
                returnMap.put("message", "未找到原订单");
                return returnMap;
            }
            //插入余额明细
            Integer balanceId = oldMemBalTrans.getBalance_id();
            WdMemBalance memBalance = wdMemBalanceService.selectByBalanceId(balanceId);
            WdMemBalTrans memBalTrans = wdMemBalTransService.insertBalanceTrans(memBalance, oldMemBalTrans.getSid(), oldMemBalTrans.getEid(), orderId, oldMemBalTrans.getAmount(), ScenceEnum.REFUND, TransType.IN, null, null);
            WdMemBonTrans oldMemBonTrans = wdMemBonTransService.selectOneByOrderId(refundOrderId);
            WdMemBonTrans insertBounsTrans = null;
            if (oldMemBonTrans != null) {
                WdMemBonus memBonus = wdMemBonusService.selectById(oldMemBonTrans.getBonus_id());
                Map<String, Object> bounsTransParam = new HashMap<>();
                bounsTransParam.put("bal_trans_id", oldMemBonTrans.getId());
                insertBounsTrans = wdMemBonTransService.insertBounsTrans(memBonus, oldMemBonTrans.getSid(), oldMemBonTrans.getEid(), orderId, oldMemBonTrans.getBouns(), ScenceEnum.REFUND, TransType.OUT, bounsTransParam);
            }
            //更新微信账户余额积分
            PayStatusEnum payStatus = null;
            UpdateUserRes updateWxBonusAndBalance = updateWxBonusAndBalance(insertBounsTrans, memBalTrans, tokenUrl);
            if (updateWxBonusAndBalance == null) {
                log.info("不需同步微信官方会员信息");
                payStatus = PayStatusEnum.SUCCESS;
            } else {
                if (updateWxBonusAndBalance.getErrcode().equals("0") && updateWxBonusAndBalance.getErrmsg().equals("ok")) {
                    //更新明细和账户
                    payStatus = PayStatusEnum.SUCCESS;
                } else {
                    payStatus = PayStatusEnum.FAIL;
                }
            }
            wdMemBalTransService.updateTransAndBalance(orderId, payStatus);
            wdMemBonTransService.updateBonusAndTrans(orderId, payStatus);
            if (PayStatusEnum.SUCCESS.equals(payStatus)) {
                returnMap.put("status", ErrorCode.SUCCESS.getErrorCode());
                returnMap.put("message", "退款成功");
            } else {
                returnMap.put("status", ErrorCode.DEFAULT_ERROR.getErrorCode());
                returnMap.put("message", "退款失败");
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            log.error("会员退款异常");
        }
        return returnMap;
    }

    /*
     * add by ws
     * 充值余额
     * 20190705
     */
    @Override
    public Map<String, Object> addBalanceToMember(WdMemBalance wdMemBalance, int sid, int eid, String orderId, BigDecimal amount,
                                                  ScenceEnum scence, TransType transType, Map<String, Object> paramMap) {
        Map<String, Object> returnMap = new HashMap<>();
        String tokenUrl = (String) paramMap.get("tokenUrl");
        try {
            log.info("开始充值余额");
            //创建余额明细
            wdMemBalTransService.insertBalanceTrans(wdMemBalance, sid, eid, orderId, amount, scence, transType, paramMap, null);
            //更新积分明细
            WdMemBalTrans memBalTrans = wdMemBalTransService.updateTransAndBalance(orderId, PayStatusEnum.SUCCESS);
            //更新微信积分
            wdMemberService.updateWxBonusAndBalance(null, memBalTrans, tokenUrl);
            returnMap.put("status", ErrorCode.SUCCESS.getErrorCode());
            returnMap.put("message", "充值余额成功");
            returnMap.put("data", memBalTrans);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            log.error("添加会员积分异常");
            returnMap.put("status", ErrorCode.DEFAULT_ERROR.getErrorCode());
            returnMap.put("message", "充值余额失败");
        }
        return returnMap;
    }

    /*
     * 充值积分
     * add by ws
     * 20190705
     */
    @Override
//	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Map<String, Object> addBonusToMember(WdMemBonus wdMemBonus, int sid, int eid, String orderId, BigDecimal bouns,
                                                ScenceEnum scence, TransType transType, Map<String, Object> paramMap) {
        String tokenUrl = (String) paramMap.get("tokenUrl");
        Map<String, Object> returnMap = new HashMap<>();
        try {
            //创建积分明细
            log.error("创建积分明细Start");
            wdMemBonTransService.insertBounsTrans(wdMemBonus, sid, eid, orderId, bouns, scence, transType, paramMap);
            log.error("创建积分明细end");
            //更新积分明细
            WdMemBonTrans updateBonusAndTrans = wdMemBonTransService.updateBonusAndTrans(orderId, PayStatusEnum.SUCCESS);
            log.error("更新积分明细end");
            //更新微信积分
            log.error("更新微信积分:" + tokenUrl + " ---->>>" + updateBonusAndTrans);
            wdMemberService.updateWxBonusAndBalance(updateBonusAndTrans, null, tokenUrl);
            returnMap.put("status", ErrorCode.SUCCESS.getErrorCode());
            returnMap.put("message", "添加会员积分成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            log.error("添加会员积分异常");
            returnMap.put("status", ErrorCode.DEFAULT_ERROR.getErrorCode());
            returnMap.put("message", "添加会员积分失败");
        }
        return returnMap;
    }

    /*
     * 领卡插入会员基本信息
     * add by ws
     * 20190710
     */
    @Override
    public WdMember insertMemberByReceiveCard(String cardId, String openId, String userCardCode, int mid, String levelId, String levelName, Integer sid, String empId) {
        try {
            WdMember insertMember = new WdMember();
            insertMember.setCard_id(cardId);
            insertMember.setOpenid(openId);
            insertMember.setCard_barcode(userCardCode);
            insertMember.setMid(mid);
            insertMember.setLoc_status("0");//领卡插入状态
            insertMember.setCreat_time(new Timestamp(System.currentTimeMillis()));
            insertMember.setLevel(levelId);
            insertMember.setLevel_name(levelName);
            insertMember.setStore_id(sid);
            insertMember.setEmpId(empId);

            wdMemberService.insert(insertMember);
            return insertMember;
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            log.error("添加会员信息异常");
            return null;
        }
    }

    @Override
    public WdMember findMemIdByOpenId(String openId) {
        WdMember wdMember = wdMemberMapper.getMemberByOpenId(openId);
        return wdMember;
    }

    /**
     * 验证会员密码
     *
     * @param memId
     * @param password
     * @return
     */
    @Override
    public boolean verifyMemPassword(int memId, String password) {
        Boolean isTure = false;
        try {
            WdMember wdMember = wdMemberService.selectMemByPrimaryKey(memId);
            log.info("正在验证密码的会员是" + wdMember);
            if (wdMember != null) {
                String memPassWord = wdMember.getPassword();
                String salt = wdMember.getSalt();
                PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
                if (!encoderSha.isPasswordValid(memPassWord, password)) {
                    log.debug("密码验证失败");
                    log.info("密码验证失败");
                    isTure = false;
                } else {
                    isTure = true;
                }
            } else {
                log.info("会员信息不存在");
            }
        } catch (Exception e) {
            log.info("会员验证密码异常");
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return isTure;
    }

    /**
     * 会员下单成功后更新余额/积分等相关信息 根据场景判断 1.充值消费 2.积分兑换
     *
     * @param orderId
     * @return
     */
    @Override
    public Map<String, Object> updateMemberConsumption(int memId, String orderId, String scence, String tokenUrl,
                                                       String status) {
        log.info("***开始更新余额账户(入参)***memId=" + memId + " orderId=" + orderId + " scence=" + scence);
        Map<String, Object> returnMap = new HashMap<>();
        try {
            returnMap = wdMemBalanceService.updateBalanceAndTrans3(memId, orderId, scence, status);
            String subCode = (String) returnMap.get("subCode");
            // 更新成功,同步微信
            if ("000000".equals(subCode)) {
                log.info("***开始更新积分明细***=" + subCode);
                // TODO 查询是否有积分变动,有:更新,无不更新}
                returnMap = wdMemBonTransService.updateBonusAndTrans(memId, orderId, scence, status);
            } else {
                log.info("***更新余额账户失败***");
                returnMap.put("subCode", "100000");
            }
        } catch (Exception e) {
            log.info("更新余额积分账户异常");
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return returnMap;
    }

    /**
     * 同步更新微信会员信息(积分)
     *
     * @param
     * @return
     */
    @Override
    public Map<String, Object> updateWX(BigDecimal bonus, String code, String card_id, String tokenUrl, int mid) {
        Map<String, Object> returnMap = new HashMap<>();
        log.info("同步更新微信会员信息入参***=bouns=" + bonus + "==code=" + code + " card_id" + card_id + " mid=" + mid);
        try {
            UpdateUserReq updateUserReq = new UpdateUserReq();
            updateUserReq.setCode(code);
            updateUserReq.setCard_id(card_id);
            updateUserReq.setAdd_bonus(bonus.intValue());
            AccessTokenRes token = tokenApi.getToken(mid, tokenUrl, AccessTokenType.TYPE_42.getType());
            log.info("token==" + token.getAccessToken());
            UpdateUserBusiness updateUserBusiness = new UpdateUserBusiness(token.getAccessToken());
            UpdateUserRes updateUserRes = updateUserBusiness.run(updateUserReq);
            log.info("更新微信返回的数据==" + updateUserRes);
            String returnCode = updateUserRes.getErrcode();
            String returnMessage = updateUserRes.getErrmsg();
            if (returnCode.equals("0") && returnMessage.equals("ok")) {
                returnMap.put("subCode", "000000");
                returnMap.put("msg", "修改成功");
            } else {
                returnMap.put("subCode", "100000");
                returnMap.put("msg", "修改失败" + returnMessage);
            }
        } catch (Exception e) {
            log.info("同步微信余额积分异常");
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return returnMap;
    }

    /**
     * 同步更新微信会员信息(积分)
     *
     * @param paramMap  扩展
     * @param tokenUrl
     * @param mid
     * @param bonus     显示积分(可用积分)
     * @param addBonus  增量积分()
     * @param amount    显示金额
     * @param addAmount 显示金额
     * @return
     */
    @SuppressWarnings("unlikely-arg-type")
    @Override
    public Map<String, Object> updateWXBouns(String tokenUrl, int mid, BigDecimal bonus, BigDecimal addBonus, BigDecimal amount,
                                             BigDecimal addAmount, String card_id, String code, String scene, Map<String, Object> paramMap) {
        Map<String, Object> returnMap = new HashMap<>();
        WdMemCard wdCard = wdMemCardService.getByWxCardId(card_id);
        int isSupBalance = wdCard.getSupply_balance();
        log.info("同步更新微信会员信息入参***=bouns=" + bonus + "==code=" + code + " card_id" + card_id + " mid=" + mid);
        try {
            UpdateUserSubReq updateUserReq = new UpdateUserSubReq();
            updateUserReq.setCode(code);
            updateUserReq.setCard_id(card_id);
            updateUserReq.setBonus(bonus.intValue());
            if (ScenceEnum.SDH.getScence().equals(scene) && addBonus.compareTo(BigDecimal.ZERO) != 0) {
                updateUserReq.setAdd_bonus(0 - addBonus.intValue());
                updateUserReq.setRecord_bonus(Reason.exchange.getComments() + ",使用" + addBonus + "积分");
            } else if (ScenceEnum.SCZ.getScence().equals(scene) && addBonus.compareTo(BigDecimal.ZERO) != 0) {
                updateUserReq.setAdd_bonus(addBonus.intValue());
                updateUserReq.setRecord_bonus(Reason.deposit.getComments() + amount + "元，获得" + addBonus + "积分");
            } else if (ScenceEnum.SXF.getScence().equals(scene) && addBonus.compareTo(BigDecimal.ZERO) != 0) {
                updateUserReq.setAdd_bonus(addBonus.intValue());
                updateUserReq.setRecord_bonus(Reason.withdraw.getComments() + amount + "元，获得" + addBonus + "积分");
            }
            // 通过cardId查会员卡，根据是否支持储值来决定是否setBalance.
            if (isSupBalance == 1) {
                updateUserReq.setBalance(amount.multiply(new BigDecimal(100)).intValue());
                if (ScenceEnum.SXF.getScence().equals(scene)) {
                    // 会员卡消费
                    updateUserReq.setAdd_balance(0 - (addAmount.multiply(new BigDecimal(100)).intValue()));
                    updateUserReq.setRecord_balance(Reason.withdraw.getComments() + addAmount);
                    // 普通线下消费

                } else {
                    // 充值
                    updateUserReq.setAdd_balance(addAmount.multiply(new BigDecimal(100)).intValue());
                    updateUserReq.setRecord_balance(Reason.deposit.getComments() + addAmount);
                }
            }
            UpdateUserReq req = null;
            if (isSupBalance != 1) {
                req = new UpdateUserReq();
                req.setCard_id(card_id);
                req.setCode(code);
                req.setBonus(bonus.intValue());
                req.setAdd_bonus(updateUserReq.getAdd_bonus());// 要增加的积分
                req.setRecord_bonus(updateUserReq.getRecord_bonus());
                req.setNotify_optional(updateUserReq.getNotify_optional());
            } else {
                req = updateUserReq;
            }
            AccessTokenRes token = tokenApi.getToken(mid, tokenUrl, AccessTokenType.TYPE_4.getType());
            log.info("token==" + token.getAccessToken());
            UpdateUserBusiness updateUserBusiness = new UpdateUserBusiness(token.getAccessToken());

            UpdateUserRes updateUserRes = updateUserBusiness.run(req);

            log.info("微信会员信息更新结果==" + updateUserRes.toString());
            String returnCode = updateUserRes.getErrcode();
            String returnMessage = updateUserRes.getErrmsg();
            if (returnCode.equals("0") && returnMessage.equals("ok")) {
                returnMap.put("subCode", "000000");
                returnMap.put("msg", "更新微信账户成功");
                returnMap.put("result_bonus", updateUserRes.getResult_bonus());
                returnMap.put("result_balance", updateUserRes.getResult_balance());
                returnMap.put("openid", updateUserRes.getOpenid());
            } else {
                returnMap.put("subCode", "100000");
                returnMap.put("msg", "修改失败" + returnMessage);
            }
        } catch (Exception e) {
            log.info("同步微信余额积分异常");
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return returnMap;
    }

    @Override
    public int insert(WdMember wdMember) {
        return wdMemberMapper.insert(wdMember);
    }

    @Override
    public WdMember selectMemByCondition(Map<String, Object> whereCondition) {
        return wdMemberMapper.selectMemByCondition(whereCondition);
    }

    @Override
    public int selectMemberCount(Map<String, Object> whereCondition) {
        return wdMemberMapper.selectMemberCount(whereCondition);
    }

    @Override
    public List<Map<String, Object>> getMemberByPager(Map<String, Object> whereCondition, int offset, int pageSize) {
        return wdMemberMapper.getMemberByPager(whereCondition, offset, pageSize);
    }

    @Override
    public WdMember selectMemByPrimaryKey(int id) {
        return wdMemberMapper.selectMemByPrimaryKey(id);
    }

    @Override
    public int updatePwdByPrimaryKey(WdMember wdMember) {
        return wdMemberMapper.updatePwdByPrimaryKey(wdMember);
    }

    @Override
    public WdMember checkMemByCondition(Map<String, Object> whereCondition) {
        return wdMemberMapper.checkMemByCondition(whereCondition);
    }

    @Override
    public int updateStatusByPrimaryKey(WdMember wdMember) {
        return wdMemberMapper.updateStatusByPrimaryKey(wdMember);
    }

    @Override
    public int updateInfoByKey(WdMember wdMember) {
        return wdMemberMapper.updateInfoByKey(wdMember);
    }

    @Override
    public WdMember getMemberByMidAndCondition(Map<String, Object> whereCondition) {
        return wdMemberMapper.getMemberByMidAndCondition(whereCondition);
    }

    @Override
    public int updateMemberPersonIdByPrimaryKey(WdMember wdMember) {
        return wdMemberMapper.updateMemberPersonIdByPrimaryKey(wdMember);
    }

    /**
     * 查询会员 信息
     */
    @Override
    public WdMember queryWdMember(String cardId, String code, String openId) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("card_id", cardId);
        condition.put("openid", openId);
        condition.put("code", code);
        WdMember member = wdMemberMapper.selectMemByCondition(condition);
        return member;
    }

    /**
     * 添加会员信息以及会员账户信息
     *
     * @param oldUserInfo
     * @param cardId
     * @param code
     * @param memCard
     * @param getUserInfoRes
     */
    @Override
    public WdMember insertMember(Map<String, Object> oldUserInfo, String cardId, String code, WdMemCard memCard,
                                 GetUserInfoRes getUserInfoRes) {

        String phone = null;
        String userName = null;
        WdMember updateWdMember = new WdMember();
        updateWdMember.setCard_id(cardId);
        updateWdMember.setCard_no(getUserInfoRes.getMembership_number());
        updateWdMember.setOpenid(getUserInfoRes.getOpenid());
        try {
            updateWdMember.setWx_name(URLEncoder.encode(getUserInfoRes.getNickname(), Constant.DEFAULT_CHARSET));
            updateWdMember.setCard_barcode(code);
            updateWdMember.setLoc_status("1");
            // 积分信息，余额信息
            String bonus = getUserInfoRes.getBonus();
            int bounsInt = 0;
            if (StringUtils.isNotEmpty(bonus)) {
                bounsInt = Integer.valueOf(bonus);
            }
            updateWdMember.setBonus(bounsInt);
            BigDecimal balance = getUserInfoRes.getBalance();
            if (balance == null) {
                balance = BigDecimal.ZERO;
            }
            updateWdMember.setBalance(balance);
            updateWdMember.setStatus(getUserInfoRes.getUser_card_status());
            updateWdMember.setMid(memCard.getMid());
            // 否已经被激活
            boolean hasActive = getUserInfoRes.isHas_active();
            if (hasActive) {
                updateWdMember.setHas_active(1);
            } else {
                updateWdMember.setHas_active(0);
            }
            updateWdMember.setSex(getUserInfoRes.getSex());
            UserInfo userInfo = getUserInfoRes.getUser_info();
            String pwAccNum = null;
            if (userInfo != null) {
                List<Map<String, Object>> common_field_list = userInfo.getCommon_field_list();
                for (int i = 0; i < common_field_list.size(); i++) {
                    Map<String, Object> map = common_field_list.get(i);
                    if (map.get("name").equals("USER_FORM_INFO_FLAG_NAME")) {
                        userName = (String) map.get("value");
                        // updateWdMember.setName(userName);
                    } else if (map.get("name").equals("USER_FORM_INFO_FLAG_MOBILE")) {
                        phone = (String) map.get("value");
                        updateWdMember.setPhone(phone);
                        pwAccNum = (String) map.get("value") + code;
                    } else if (map.get("name").equals("USER_FORM_INFO_FLAG_BIRTHDAY")) {
                        String birthday = (String) map.get("value");
                        String[] birthday3 = birthday.split("-");
                        updateWdMember.setYear(Integer.valueOf(birthday3[0]));
                        updateWdMember.setMonth(Integer.valueOf(birthday3[1]));
                        updateWdMember.setDay(Integer.valueOf(birthday3[2]));
                    }
                }
            }
            if (oldUserInfo != null) {
                userName = (String) oldUserInfo.get("name");
                phone = (String) oldUserInfo.get("phone");
                updateWdMember.setPhone(phone);
                updateWdMember.setEmail((String) oldUserInfo.get("email"));
                String birthday = (String) oldUserInfo.get("birthday");
                log.info("会员生日" + birthday);
                String[] birthday3 = birthday.split("-");
                updateWdMember.setYear(Integer.valueOf(birthday3[0]));
                updateWdMember.setMonth(Integer.valueOf(birthday3[1]));
                updateWdMember.setDay(Integer.valueOf(birthday3[2]));
                if (oldUserInfo.get("idcard") != null) {
                    updateWdMember.setIdcard((String) oldUserInfo.get("idcard"));
                }
            }
            updateWdMember.setName(userName);
            Timestamp time = new Timestamp(new Date().getTime());
            updateWdMember.setCreat_time(time);
            // add by ws 0616 初始化密码
            String salt = PasswordEncoder.getSalt();// request.getParameter("salt");
            PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
            String mpwd = MD5Util.lowerMD5(Constant.password + pwAccNum);
            String encodePwd = encoderSha.encode(mpwd);
            updateWdMember.setSalt(salt);
            updateWdMember.setPassword(encodePwd);
            // end
            insert(updateWdMember);// 返回主键id
        } catch (Exception e) {

            log.info("****添加会员信息以及会员账户信息异常****");
            log.error(ExceptionUtils.getStackTrace(e));
        }

        return updateWdMember;
    }

    /**
     * 更新会员信息以及会员账户信息
     *
     * @param oldUserInfo
     * @param cardId
     * @param code
     * @param memCard
     * @param member
     * @param getUserInfoRes
     */
    @Override
    public WdMember updateMenber(Map<String, Object> oldUserInfo, String cardId, String code, WdMemCard memCard,
                                 WdMember member, GetUserInfoRes getUserInfoRes) {
        String phone = null;
        String userName = null;
        WdMember updateWdMember = new WdMember();
        try {
            UserInfo userInfo = getUserInfoRes.getUser_info();
            String pwAccNum = null;
            updateWdMember.setCard_no(getUserInfoRes.getMembership_number());
            try {
                updateWdMember.setWx_name(URLEncoder.encode(getUserInfoRes.getNickname(), Constant.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            updateWdMember.setLoc_status("1");
            // 积分信息，余额信息
            String bouns = getUserInfoRes.getBonus();
            if (StringUtils.isNotEmpty(bouns)) {
                updateWdMember.setBonus(Integer.valueOf(bouns));
            }

            BigDecimal balance = getUserInfoRes.getBalance();
            if (balance == null) {
                balance = BigDecimal.ZERO;
            }
            updateWdMember.setBalance(balance);
            updateWdMember.setStatus(getUserInfoRes.getUser_card_status());
            // 否已经被激活
            boolean hasActive = getUserInfoRes.isHas_active();
            if (hasActive) {
                updateWdMember.setHas_active(1);
            } else {
                updateWdMember.setHas_active(0);
            }
            updateWdMember.setSex(getUserInfoRes.getSex());
            if (userInfo != null) {
                List<Map<String, Object>> common_field_list = userInfo.getCommon_field_list();
                for (int i = 0; i < common_field_list.size(); i++) {
                    Map<String, Object> map = common_field_list.get(i);
                    if (map.get("name").equals("USER_FORM_INFO_FLAG_NAME")) {
                        userName = (String) map.get("value");
                        // updateWdMember.setName(userName);
                    } else if (map.get("name").equals("USER_FORM_INFO_FLAG_MOBILE")) {
                        phone = (String) map.get("value");
                        updateWdMember.setPhone(phone);
                        pwAccNum = (String) map.get("value") + code;
                    } else if (map.get("name").equals("USER_FORM_INFO_FLAG_BIRTHDAY")) {
                        String birthday = (String) map.get("value");
                        String[] birthday3 = birthday.split("-");
                        updateWdMember.setYear(Integer.valueOf(birthday3[0]));
                        updateWdMember.setMonth(Integer.valueOf(birthday3[1]));
                        updateWdMember.setDay(Integer.valueOf(birthday3[2]));
                    }
                }
            }
            log.info("******pwAccNum=" + pwAccNum + " code=" + code);
            if (oldUserInfo != null) {
                userName = (String) oldUserInfo.get("name");
                phone = (String) oldUserInfo.get("phone");
                updateWdMember.setPhone(phone);
                updateWdMember.setEmail((String) oldUserInfo.get("email"));
                String birthday = (String) oldUserInfo.get("birthday");
                log.info("会员生日" + birthday);
                String[] birthday3 = birthday.split("-");
                updateWdMember.setYear(Integer.valueOf(birthday3[0]));
                updateWdMember.setMonth(Integer.valueOf(birthday3[1]));
                updateWdMember.setDay(Integer.valueOf(birthday3[2]));
                if (oldUserInfo.get("idcard") != null) {
                    updateWdMember.setIdcard((String) oldUserInfo.get("idcard"));
                }
            }
            updateWdMember.setName(userName);
            Timestamp time = new Timestamp(new Date().getTime());
            if ("0".equals(member.getLoc_status())) {
                // add by ws 0616 初始化密码
                String salt = PasswordEncoder.getSalt();// request.getParameter("salt");
                PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
                String mpwd = MD5Util.lowerMD5(Constant.password + pwAccNum);

                String encodePwd = encoderSha.encode(mpwd);
                updateWdMember.setSalt(salt);
                updateWdMember.setPassword(encodePwd);
                updateWdMember.setId(member.getId());
            }
            // 更新会员信息
            updateInfoByKey(updateWdMember);
        } catch (Exception e) {
            log.error("***更新会员信息异常***");
            log.error(ExceptionUtils.getStackTrace(e));
        }

        return updateWdMember;
    }

    @Override
    public Map<String, Object> updateMemPwd(int memberId, String password, String mpwd, String mpwd2) {

        Map<String, Object> resultMap = new HashMap<>();
        try {
            WdMember wdMember = wdMemberMapper.selectMemByPrimaryKey(memberId);
            String oldSolt = wdMember.getSalt();
            String oldPwd = wdMember.getPassword();
            if (!mpwd.equals(mpwd2)) {
                // 验证失败，返回到修改页面
                resultMap.put("message", "两次输入密码不一致");
                resultMap.put("status", 300);
                return resultMap;
            }
            // 验证老密码是否正确
            PasswordEncoder encoderShaOld = new PasswordEncoder(oldSolt, "SHA");

            if (!encoderShaOld.isPasswordValid(oldPwd, password)) {
                // 验证失败，返回到修改页面
                resultMap.put("message", "旧密码不正确");
                resultMap.put("status", 300);
                return resultMap;
            } else if (encoderShaOld.isPasswordValid(oldPwd, mpwd)) {
                resultMap.put("message", "新密码和旧密码不能相同");
                resultMap.put("status", 300);
                return resultMap;
            }
            // 验证的盐值
            String salt = PasswordEncoder.getSalt();// request.getParameter("salt");
            PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
            String encodePwd = encoderSha.encode(mpwd);
            WdMember updateMember = new WdMember();
            updateMember.setId(memberId);
            updateMember.setPassword(encodePwd);
            updateMember.setSalt(salt);

            log.debug("updateMemberPassWord" + wdMemberMapper.updatePwdByPrimaryKey(updateMember));
            resultMap.put("message", "密码修改成功！");
            resultMap.put("status", 200);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            resultMap.put("message", "密码修改失败！");
            resultMap.put("status", 300);
        }
        return resultMap;
    }

    /*
     *  重置会员卡消费密码
     */
    @Override
    public Map<String, Object> resetMemPwd(int memberId, String password) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String salt = PasswordEncoder.getSalt();// request.getParameter("salt");
            PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
            String encodePwd = encoderSha.encode(password);
            WdMember memberInfo = wdMemberMapper.selectMemByPrimaryKey(memberId);
            if (memberInfo != null) {
                WdMember updateMember = new WdMember();
                updateMember.setId(memberId);
                updateMember.setPassword(encodePwd);
                updateMember.setSalt(salt);
                wdMemberMapper.updatePwdByPrimaryKey(updateMember);
                resultMap.put("message", "会员用户（" + memberInfo.getName() + "）密码重置成功！");
                resultMap.put("status", 200);
            } else {
                resultMap.put("message", "请核实会员信息是否真实有效");
                resultMap.put("status", 300);
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            resultMap.put("message", "密码重置失败！");
            resultMap.put("status", 300);
        }
        return resultMap;
    }

    /*
     * 更新微信等级
     */
    @Override
    public boolean updateWxLevel(String levelName, String cardId, String cardCode, String token) throws Exception {
        boolean isSuccess = false;
        try {
            UpdateUserReq updateUserReq = new UpdateUserReq();
            updateUserReq.setCustom_field_value3(levelName);
            updateUserReq.setCard_id(cardId);
            updateUserReq.setCode(cardCode);

            UpdateUserBusiness updateUserBusiness = new UpdateUserBusiness(token);
            UpdateUserRes updateUserRes = updateUserBusiness.run(updateUserReq);
            String errcode = updateUserRes.getErrcode();
            if ("0".equals(errcode)) {
                isSuccess = true;
            } else {
                log.error("更新微信会员等级失败！");
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            log.error("更新微信会员等级异常！");
        }
        return isSuccess;
    }

    @Override
    public WdMember findMemInfo(String mdCode) {
        Map<String, Object> map = new HashMap<>();
        try {
            //会员信息
            WdBindCode wdb = wdBindCodeApi.getByMdCode(mdCode);
            Map<String, Object> condition = new HashMap<>();
            condition.put("openid", wdb.getOpenid());
            condition.put("mid", wdb.getMid());
            condition.put("unionid", wdb.getUnionid());
            condition.put("card_id", wdb.getReserve1());
            WdMember wdm = wdMemberService.selectMemByCondition(condition);
            if (wdm != null) {
                map.put("status", "000000");
                map.put("data", wdb);
                map.put("msg", "会员身份验证成功！！");
            }
            return wdm;
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * 异常情况同步会员信息
     * add by ws
     * 20190731
     */
    @Override
    public String sysMember(String cardId, String code, String token) {
        String respContent = null;
        try {
            String userName = null;
            String memNum = null;
            WdMemCard memCard = wdMemCardService.getByWxCardId(cardId);
            int mid = memCard.getMid();
            Map<String, Object> condition = new HashMap<>();
            condition.put("mid", mid);
            condition.put("card_id", cardId);
            condition.put("code", code);
            WdMember member = wdMemberMapper.selectMemByCondition(condition);
            if (member == null) {
                wdMemCardService.activationCard(cardId, code, memNum, token);
                // 1.调用拉取会员信息接口
                GetUserInfoRes getUserInfoRes = wdMemCardService.getUserInfo(cardId, code, token);
                if (getUserInfoRes.getErrcode().equals("0") && getUserInfoRes.getErrmsg().equals("ok")) {
                    // 3. 拉取会员信息 插入会员表 code,name,pone.....
                    WdMember updateWdMember = new WdMember();
                    updateWdMember.setCard_id(cardId);
                    updateWdMember.setCard_no(getUserInfoRes.getMembership_number());
                    updateWdMember.setOpenid(getUserInfoRes.getOpenid());
                    updateWdMember.setWx_name(URLEncoder.encode(getUserInfoRes.getNickname(), Constant.DEFAULT_CHARSET));
                    updateWdMember.setCard_barcode(code);
                    updateWdMember.setLoc_status("1");
                    // 积分信息，余额信息
                    if (getUserInfoRes.getBonus() != null) {
                        updateWdMember.setBonus(Integer.valueOf(getUserInfoRes.getBonus()));
                    }
                    BigDecimal balance = getUserInfoRes.getBalance();
                    if (balance == null) {
                        balance = BigDecimal.ZERO;
                    }
                    updateWdMember.setBalance(balance);
                    updateWdMember.setStatus(getUserInfoRes.getUser_card_status());
                    updateWdMember.setMid(mid);
                    // 否已经被激活
                    boolean hasActive = getUserInfoRes.isHas_active();
                    if (hasActive) {
                        updateWdMember.setHas_active(1);
                    } else {
                        updateWdMember.setHas_active(0);
                    }
                    updateWdMember.setSex(getUserInfoRes.getSex());
                    UserInfo userInfo = getUserInfoRes.getUser_info();
                    String pwAccNum = null;
                    if (userInfo != null) {
                        List<Map<String, Object>> common_field_list = userInfo.getCommon_field_list();
                        for (int i = 0; i < common_field_list.size(); i++) {
                            Map<String, Object> map = common_field_list.get(i);
                            if (map.get("name").equals("USER_FORM_INFO_FLAG_NAME")) {
                                userName = (String) map.get("value");
                                //updateWdMember.setName(userName);
                            } else if (map.get("name").equals("USER_FORM_INFO_FLAG_MOBILE")) {
                                updateWdMember.setPhone((String) map.get("value"));
                                pwAccNum = (String) map.get("value") + code;
                            } else if (map.get("name").equals("USER_FORM_INFO_FLAG_BIRTHDAY")) {
                                String birthday = (String) map.get("value");
                                String[] birthday3 = birthday.split("-");
                                updateWdMember.setYear(Integer.valueOf(birthday3[0]));
                                updateWdMember.setMonth(Integer.valueOf(birthday3[1]));
                                updateWdMember.setDay(Integer.valueOf(birthday3[2]));
                            }
                        }
                    }

                    updateWdMember.setName(userName);
                    Timestamp time = new Timestamp(System.currentTimeMillis());
                    updateWdMember.setCreat_time(time);
                    //add by ws 0616 初始化密码
                    String salt = PasswordEncoder.getSalt();//request.getParameter("salt");
                    PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
                    String mpwd = MD5Util.lowerMD5(Constant.password + pwAccNum);
                    String encodePwd = encoderSha.encode(mpwd);
                    updateWdMember.setSalt(salt);
                    updateWdMember.setPassword(encodePwd);
                    wdMemberMapper.insert(updateWdMember);//返回主键id
                    //TODO 创建余额账户，创建积分账户

                    wdMemBalanceService.insertWdMemBalance(updateWdMember, getUserInfoRes, memCard, cardId, getUserInfoRes.getMembership_number());
                    wdMemBonusService.insertWdMemBonus(updateWdMember, getUserInfoRes, memCard, cardId, getUserInfoRes.getMembership_number());
                }
            } else {
                // 更新会员表，根据本地状态的值插入到账户表
                GetUserInfoRes getUserInfoRes = wdMemCardService.getUserInfo(cardId, code, token);
                WdMember updateWdMember = new WdMember();
                UserInfo userInfo = getUserInfoRes.getUser_info();
                String pwAccNum = null;
                updateWdMember.setCard_no(getUserInfoRes.getMembership_number());
                updateWdMember.setWx_name(URLEncoder.encode(getUserInfoRes.getNickname(), Constant.DEFAULT_CHARSET));
                updateWdMember.setLoc_status("1");
                // 积分信息，余额信息
                updateWdMember.setBonus(Integer.valueOf(getUserInfoRes.getBonus()));
                BigDecimal balance = getUserInfoRes.getBalance();
                if (balance == null) {
                    balance = BigDecimal.ZERO;
                }
                updateWdMember.setBalance(balance);
                updateWdMember.setStatus(getUserInfoRes.getUser_card_status());
                // 否已经被激活
                boolean hasActive = getUserInfoRes.isHas_active();
                if (hasActive) {
                    updateWdMember.setHas_active(1);
                } else {
                    updateWdMember.setHas_active(0);
                }
                updateWdMember.setSex(getUserInfoRes.getSex());
                if (userInfo != null) {
                    List<Map<String, Object>> common_field_list = userInfo.getCommon_field_list();
                    for (int i = 0; i < common_field_list.size(); i++) {
                        Map<String, Object> map = common_field_list.get(i);
                        if (map.get("name").equals("USER_FORM_INFO_FLAG_NAME")) {
                            userName = (String) map.get("value");
                            // updateWdMember.setName(userName);
                        } else if (map.get("name").equals("USER_FORM_INFO_FLAG_MOBILE")) {
                            updateWdMember.setPhone((String) map.get("value"));
                            pwAccNum = (String) map.get("value") + code;
                        } else if (map.get("name").equals("USER_FORM_INFO_FLAG_BIRTHDAY")) {
                            String birthday = (String) map.get("value");
                            String[] birthday3 = birthday.split("-");
                            updateWdMember.setYear(Integer.valueOf(birthday3[0]));
                            updateWdMember.setMonth(Integer.valueOf(birthday3[1]));
                            updateWdMember.setDay(Integer.valueOf(birthday3[2]));
                        }
                    }
                }
                updateWdMember.setName(userName);

                // add by ws 0616 初始化密码
                String salt = PasswordEncoder.getSalt();// request.getParameter("salt");
                PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
                String mpwd = MD5Util.lowerMD5(Constant.password + pwAccNum);
                String encodePwd = encoderSha.encode(mpwd);
                updateWdMember.setSalt(salt);
                updateWdMember.setPassword(encodePwd);
                updateWdMember.setId(member.getId());

                if ("0".equals(member.getLoc_status())) {
                    //
                    log.debug("开始插入账户信息");
                    wdMemBalanceService.insertWdMemBalance(updateWdMember, getUserInfoRes, memCard, cardId, getUserInfoRes.getMembership_number());
                    wdMemBonusService.insertWdMemBonus(updateWdMember, getUserInfoRes, memCard, cardId, getUserInfoRes.getMembership_number());
                }
                // end
                wdMemberMapper.updateInfoByKey(updateWdMember);
            }
            respContent = "success";
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            respContent = "error";
        }
        return respContent;
    }

    @Override
    public Map<String, Object> queryMemLevelInfo(Map<String, Object> whereCondition) {
        return wdMemberMapper.queryMemLevelInfo(whereCondition);
    }

    @Override
    public Map<String, Object> selectMemDonate(Integer mid, int sid, Integer member_id) {
        return wdMemberMapper.selectMemDonate(mid, sid, member_id);
    }

    @Override
    public Map<String, Object> queryMemberBalance(Integer member_id) {
        return wdMemberMapper.queryMemberBalance(member_id);
    }

    @Override
    public void insertDonateAmounts(Integer mid, int sid, Integer member_id, BigDecimal donate_amount) {
        wdMemberMapper.insertDonateAmounts(mid, sid, member_id, donate_amount);
    }

    @Override
    public void updateMemDonates(Integer mid, int sid, Integer member_id, BigDecimal donateAmount, BigDecimal sum_donate) {
        wdMemberMapper.updateMemDonates(mid, sid, member_id, donateAmount, sum_donate != null ? sum_donate : new BigDecimal(0.00));
    }

    @Override
    public Map<String, Object> getConsumerByOpenid(int member_id, int mid) {
        return wdMemberMapper.getConsumerByOpenid(member_id, mid);
    }
    /*
    TODO
    @Override
    public WdCardLevel queryWdCardById(int mid, String wx_card_id, Integer levelId) {
        return wdMemberMapper.queryWdCardById(mid, wx_card_id, levelId);
    }

    @Override
    public WdCardLevel queryWdCardBySort(int mid, String wx_card_id, String id) {
        return wdMemberMapper.queryWdCardBySort(mid, wx_card_id, id);
    }*/

    @Override
    public void updateMemberInfo(int member_id, int mid, String currentLevel, String currLevelName) {
        wdMemberMapper.updateMemberInfo(member_id, mid, currentLevel, currLevelName);
    }

    @Override
    public Map<String, Object> queryPushTokenId(int mid, String token_type) {
        return wdMemberMapper.queryPushTokenId(mid, token_type);
    }

    @Override
    public Map<String, Object> findByDataKey(String dataKey) {
        return wdMemberMapper.findByDataKey(dataKey);
    }

    @Override
    public List<Map<String, Object>> queryDonateAndBalanceInfo(int member_id) {
        return wdMemberMapper.queryDonateAndBalanceInfo(member_id);
    }

    @Override
    public Map<String, Object> queryDonateInfo(int memberId, Integer mid, Integer sid) {
        return wdMemberMapper.queryDonateInfo(memberId, mid, sid);
    }

    @Override
    public void updateDonateAmount(Map<String, Object> donateMap) {
        wdMemberMapper.updateDonateAmount(donateMap);
    }


    //
    /*
     * 会员裂变赠送积分
     * add by jh
     * 20200109
     */
    @Override
    public Map<String, Object> addBonusToInvitation(WdMemBonus wdMemBonus, int sid, int eid, String orderId, BigDecimal bouns,
                                                    ScenceEnum scence, TransType transType, Map<String, Object> paramMap) {
        String tokenUrl = (String) paramMap.get("tokenUrl");
        Map<String, Object> returnMap = new HashMap<>();
        try {
            //创建积分明细
            log.error("创建积分明细Start");
            wdMemBonTransService.insertBounsTrans(wdMemBonus, sid, eid, orderId, bouns, scence, transType, paramMap);
            log.error("创建积分明细end");
            //更新积分明细
            WdMemBonTrans updateBonusAndTrans = wdMemBonTransService.updateBonusAndTrans(orderId, PayStatusEnum.SUCCESS);
            log.error("更新积分明细end");
            //更新微信积分
            log.error("更新微信积分:" + tokenUrl + " ---->>>" + updateBonusAndTrans);
            wdMemberService.updateWxBonusAndBalance(updateBonusAndTrans, null, tokenUrl);
            returnMap.put("status", ErrorCode.SUCCESS.getErrorCode());
            returnMap.put("message", "添加会员积分成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            log.error("添加会员积分异常");
            returnMap.put("status", ErrorCode.DEFAULT_ERROR.getErrorCode());
            returnMap.put("message", "添加会员积分失败");
        }
        return returnMap;
    }

    //此方法以及迁移到system项目中wxsession业务方法中了
    /*
    @Override
    public Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition) {
        return wdMemberMapper.findWxSessionByMiniOpenId(condition);
    }*/
}
