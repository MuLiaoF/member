package cn.wandingkeji.balance.impl;

import cn.wandingkeji.balance.IWdMemBalTransService;
import cn.wandingkeji.balance.IWdMemBalanceService;
import cn.wandingkeji.member.entity.WdMemBalTrans;
import cn.wandingkeji.member.mapper.WdMemBalTransMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wdMemBalTransService")
public class WdMemBalTransServiceImpl implements IWdMemBalTransService {
    private static final Logger log = LoggerFactory.getLogger(WdMemBalTransServiceImpl.class);
    @Autowired
    private WdMemBalTransMapper wdMemBalTransMapper;
    @Autowired
    private IWdMemBalanceService wdMemBalanceService;

    //@Autowired
    //private DepositOrderMapper depositOrderMapper;
    
    //@Autowired
    //private IMemberUtilService memberUtilServiceImpl;
/*
    @Override
    public WdMemBalTrans insertBalanceTrans(WdMemBalance wdMemBalance, Integer sid, Integer eid, String order_id, BigDecimal amount,
                                            ScenceEnum scence, TransType transType, Map<String, Object> paramMap, String employee_no) {
        log.info("添加余额变动明细入参==" + paramMap);
        log.info("===  充值transType is 1 == : {} " + transType);
        WdMemBalTrans wdMemBalTrans = new WdMemBalTrans();
        try {

            //sid 赋值
            log.info("sid :"+sid);
            sid = (null == sid ||sid==0)?wdMemBalTransMapper.selectConsumeByOrderId(order_id):sid;
            wdMemBalance.setPayStoreId(sid);

            // 会员平台的order_id
            wdMemBalTrans.setBalance_id(wdMemBalance.getId());
            wdMemBalTrans.setMember_id(Integer.valueOf(wdMemBalance.getMember_id()));
            wdMemBalTrans.setMid(Integer.valueOf(wdMemBalance.getOrg()));
            wdMemBalTrans.setSid(sid);
            wdMemBalTrans.setEid(eid);
            wdMemBalTrans.setTrans_type(transType.getStatus());
            wdMemBalTrans.setReason_id(scence.getScence());
            wdMemBalTrans.setOrder_id(order_id);
            wdMemBalTrans.setAmount(amount);

            if (TransType.IN.equals(transType)) {
                //存入，余额增加
            	log.info("the current scense is : {}, is CZZS ? : {}", scence.getScence(), StringUtils.equals(ScenceEnum.CZZS.toString(), scence.getScence()));
            	if (!StringUtils.equals(ScenceEnum.CZZS.toString(), scence.getScence())) {
            		wdMemBalTrans.setAccount_balance(wdMemBalance.getActual_balance().add(amount));
				}
            	else
            	{
            		wdMemBalTrans.setAccount_balance(wdMemBalance.getActual_balance());
            	}
            } else if (TransType.OUT.equals(transType)) {
                //支出。 账户当前余额 正向(加)+ 退款(减)-
                DepositOrder order = new DepositOrder();
                log.info(wdMemBalTrans.toString());
                order.setMember_id(Integer.valueOf(wdMemBalance.getMember_id()));
                order.setSid(sid);


                Map<String, Object> memDonate = depositOrderMapper.selectMemDonate(order);


                //输出 消费详情；用于对账；
                WdMemConsumeInfo consumeInfo = new WdMemConsumeInfo();
                consumeInfo.setSid(sid);
                consumeInfo.setOrderId(order_id);
                consumeInfo.setMemberId(Integer.valueOf(wdMemBalance.getMember_id()));
                consumeInfo.setTotalAmount(amount);
                consumeInfo.setBalancePay(amount);
                consumeInfo.setGiftPay(new BigDecimal(0L));
                consumeInfo.setMid(Integer.valueOf(wdMemBalance.getOrg()));

                if (null != memDonate) {
                    Double mapney = memDonate.get("donate_amount") == null ? 0 : Double.parseDouble(memDonate.get("donate_amount").toString());
                    BigDecimal hisdonate = BigDecimal.valueOf(mapney);
                    BigDecimal donate = new BigDecimal(0);
                    if (memDonate != null) {
                        if (hisdonate.compareTo(donate) == 1) {

                            if (hisdonate.compareTo(amount) > -1) {
                                log.info("消费：" + amount + ";使用赠送金额付款：" + amount);
                                donate = hisdonate.subtract(amount);
                                consumeInfo.setGiftPay(amount);

                                wdMemBalTrans.setComments("PS:使用赠送余额:"+amount+"使用会员余额:"+0);
                                //置空 amount
                                amount = new BigDecimal(0);
                                consumeInfo.setBalancePay(amount);
                            } else {
                                log.info("消费：" + amount + "使用赠送金额付款：" + hisdonate + "使用存款付款：" + amount.subtract(hisdonate));
                                //置空 donate
                                donate = new BigDecimal(0);
                                amount = amount.subtract(hisdonate);

                                consumeInfo.setBalancePay(amount);
                                consumeInfo.setGiftPay(hisdonate);
                                wdMemBalTrans.setComments("PS:使用赠送余额:"+hisdonate+"使用会员余额:"+amount);
                            }
                            log.info("剩余赠送余额为："+donate);
                            wdMemBalTrans.setAccount_donate(donate);
                        }else{
                            wdMemBalTrans.setAccount_donate(donate);
                        }
                    }
                }
                consumeInfo.setStatus(0);
                log.info(" 入参数为 "+consumeInfo);
                consumeInfo.setPayTime(new Timestamp(System.currentTimeMillis()));
                wdMemBalTransMapper.insertMemConsumeInfo(consumeInfo);
                wdMemBalTrans.setAccount_balance(wdMemBalance.getActual_balance().subtract(amount));
            }

            // 0准备支付 1支付成功 2支付失败
            wdMemBalTrans.setStatus(PayStatusEnum.INSERT.getStatus());
            wdMemBalTrans.setCreat_stamp(new Timestamp(System.currentTimeMillis()));

            //update 2019/12/31 w.d 重复订单
            Map<String,Object> whereCondition = new HashMap<>(16);
            whereCondition.put("order_id",order_id);
            log.info("订单入库查询入参 ->{}",whereCondition);
            List<WdMemBalTrans> list =  wdMemBalTransMapper.selectByOrderId(whereCondition);
            if(list.size()>0){
               log.info("重复订单");
            }
            else{
                wdMemBalTransMapper.insert(wdMemBalTrans);
                log.info("******** the employee_id is ****************** : {}", employee_no);
                if (StringUtils.isNotEmpty(employee_no)) {
                    wdMemBalTrans.setEmployee_no(employee_no);
                    wdMemBalTransMapper.updateByPrimaryKey(wdMemBalTrans);
                }
            }

            //更新账户余额信息

        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return wdMemBalTrans;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WdMemBalTrans updateTransAndBalance(String orderId, PayStatusEnum payStatus) {
        log.info("更新余额明细和账户,订单号{}，状态{}", orderId, payStatus);
        WdMemBalTrans memBalTrans = null;
        try {
            //通过orderId查询余额明细
            memBalTrans = wdMemBalTransMapper.selectOneByOrderId(orderId);
            if (memBalTrans == null) {
                log.info("通过订单号查询余额明细为null，条件{}", orderId);
                return null;
            }
            WdMemBalTrans updateBalalceTrans = new WdMemBalTrans();
            updateBalalceTrans.setStatus(payStatus.getStatus());
            updateBalalceTrans.setId(memBalTrans.getId());
            wdMemBalTransMapper.updateByPrimaryKey(updateBalalceTrans);
            if (PayStatusEnum.SUCCESS.equals(payStatus)) {

                BigDecimal consume =  memBalTrans.getAmount();
                log.info("update member balance  !"+memBalTrans);


                //   验证成功，更新账户
                WdMemBalance memBalance = new WdMemBalance();
                memBalance.setActual_balance(memBalTrans.getAccount_balance());
                memBalance.setId(memBalTrans.getBalance_id());
                WdMemBalance wdMembalance = wdMemBalanceService.selectByBalanceId(memBalTrans.getBalance_id());
                //充值
                if(memBalTrans.getTrans_type().equals("IN")) {
                    log.info("-----充值-----");
                }else{
                    log.info("-----消费-----");

                    log.info("wdMembalance is :"+wdMembalance);
                    BigDecimal hisConsume = wdMembalance.getCum_trans_amt();
                    hisConsume.add(consume);
                    memBalance.setDonate_amount(memBalTrans.getAccount_donate());
                    memBalance.setCum_trans_amt(hisConsume);
                    memBalance.setPayTimeLatest(new Timestamp(System.currentTimeMillis()));
                    int payCount = wdMembalance.getPayCount();
                    log.info("pay count is " + payCount);
                    memBalance.setPayCount(++payCount);
                    memBalance.setPayStoreId(memBalTrans.getSid());
                }

                log.info("更新余额入参"+memBalance);
                wdMemBalanceService.updateByBalanceId(memBalance);

                if(memBalTrans.getTrans_type().equals("OUT")) {
                    log.info("支付成功，更新赠送余额信息");
                    DepositOrder order = new DepositOrder();
                    order.setMember_id(Integer.valueOf(wdMembalance.getMember_id()));
                    order.setBalance(memBalTrans.getAccount_donate());
                    order.setAmount(memBalTrans.getAccount_donate());
                    order.setSid(memBalTrans.getSid());
                    log.info("赠送余额信息入参" + order);
                    if(memBalTrans.getAccount_donate()!=null){
                        depositOrderMapper.updateMemDonate(order);
                    }
                    log.info("更新消费详情信息");
                    WdMemConsumeInfo consumeInfo = new WdMemConsumeInfo();
                    consumeInfo.setOrderId(memBalTrans.getOrder_id());
                    wdMemBalTransMapper.updateMemConsumeInfo(consumeInfo);
                }

                if (ScenceEnum.SXF.getScence().equals(memBalTrans.getReason_id())) {
                    // 累计消费，会员升级 
                    log.info("-------累积消费金额，会员升级  mid : {} , member id : {} , amount : {} ", memBalTrans.getMid(), memBalTrans.getId(), memBalTrans.getAmount());
                    Map<String, Object> memCumTransAmt = memberUtilServiceImpl.judgeUpgradeMemCard(memBalTrans.getMid(), memBalTrans.getMember_id(), memBalTrans.getAmount());
                    log.info("------------会员更新z : {}", memCumTransAmt.toString());
                    BigDecimal cum_trans_amt = (BigDecimal) memCumTransAmt.get("cum_trans_amt");
                    String currentSort = (String) memCumTransAmt.get("currentSort");
                    String card_barcode = (String) memCumTransAmt.get("card_barcode");
                    memberUtilServiceImpl.updateMemLevelByAmtBalance(cum_trans_amt, memBalTrans.getMember_id(), memBalTrans.getMid(), currentSort, card_barcode);
                }

            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return memBalTrans;
    }*/
	
	/*@Override
	public Map<String, Object> insertBalanceTrans(int memId, int mid, int sid, int eid, String order_id, BigDecimal amount,
			String scence, String sourceType, Map<String, Object> paramMap) {
		log.info("添加会员余额变动明细insertParam()入参==" + paramMap);
		Map<String, Object> returnMap = new HashMap<>();
		WdMemBalTrans wdMemBalTrans = new WdMemBalTrans();
		try {
			Map<String, Object> conditionMap = new HashMap<>();
			WdMember wdMember = wdMemberService.selectMemByPrimaryKey(memId);
			conditionMap.put("member_id", memId);
			conditionMap.put("user_code_id", wdMember.getCard_barcode());
			conditionMap.put("card_id", wdMember.getCard_id());
			WdMemBalance wdMemBalance = wdMemBalanceService.selectByCondition(conditionMap);
			// 会员平台的order_id
			wdMemBalTrans.setBalance_id(String.valueOf(wdMemBalance.getId()));
			
			wdMemBalTrans.setMember_id(String.valueOf(memId));
			wdMemBalTrans.setMid(mid);
			if(sid!=0) {
				wdMemBalTrans.setSid(String.valueOf(sid));
			}
			if(eid!=0) {
				wdMemBalTrans.setEid(String.valueOf(eid));
			}
			wdMemBalTrans.setReason_id(scence);
			wdMemBalTrans.setOrder_id(order_id);
			wdMemBalTrans.setAmount(amount);
			if (ScenceEnum.SCZ.getScence().equals(scence)) {
				wdMemBalTrans.setAccount_balance(wdMemBalance.getActual_balance().add(amount));
			}else if(ScenceEnum.SXF.getScence().equals(scence)) {
				// 账户当前余额 正向(加)+ 退款(减)-
				wdMemBalTrans.setAccount_balance(wdMemBalance.getActual_balance().subtract(amount));
			}
			// 0准备支付 1支付失败 2支付完成 3.包括退款
			wdMemBalTrans.setStatus(WriteOff.ERRCODE.getSta());
			wdMemBalTrans.setCreat_stamp(new Timestamp(new Date().getTime()));
			int insertSuccess = insert(wdMemBalTrans);
			if (NumSuc.SUCEESS.getSta() == insertSuccess) {
				returnMap.put("subCode", "000000");
			} else {
				returnMap.put("subCode", "100000");
			}
			returnMap.put("bal_trans_id", wdMemBalTrans.getId());
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			returnMap.put("subCode", "100000");
		}
		log.info("添加会员余额变动明细insertParam()出参==" + returnMap);
		return returnMap;
	}*/

    @Override
    public WdMemBalTrans selectByCondtion(Map<String, Object> whereCondition) {
        return wdMemBalTransMapper.selectByCondtion(whereCondition);
    }

    @Override
    public int insert(WdMemBalTrans wdMemBalTrans) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.insert(wdMemBalTrans);
    }

    @Override
    public int updateByPrimaryKey(WdMemBalTrans wdMemBalTrans) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.updateByPrimaryKey(wdMemBalTrans);
    }

    @Override
    public List<WdMemBalTrans> selectByOrderId(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.selectByOrderId(whereCondition);
    }

    @Override
    public Map<String, Object> selectTransCount(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.selectTransCount(whereCondition);
    }

    @Override
    public List<Map<String, Object>> getAccTransByPager(Map<String, Object> whereCondition, int offset, int pageSize) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.getAccTransByPager(whereCondition, offset, pageSize);
    }

    @Override
    public List<Map<String, Object>> selectBounsDetail(Map<String, Object> whereCondition, int offset, int pageSize) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.selectBounsDetail(whereCondition, offset, pageSize);
    }

    @Override
    public WdMemBalTrans selectById(int id) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.selectById(id);
    }

    @Override
    public List<Map<String, Object>> getAllIntoTrans(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.getAllIntoTrans(whereCondition);
    }

    @Override
    public Map<String, Object> getTrasnsCountToPhone(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.getTrasnsCountToPhone(whereCondition);
    }

    @Override
    public List<Map<String, Object>> getAccTransToPhone(Map<String, Object> whereCondition, int offset, int pageSize) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.getAccTransToPhone(whereCondition, offset, pageSize);
    }

    @Override
    public WdMemBalTrans selectOneByOrderId(String orderId) {
        // TODO Auto-generated method stub
        return wdMemBalTransMapper.selectOneByOrderId(orderId);
    }

}

