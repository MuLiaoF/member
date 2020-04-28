package cn.wandingkeji.bonus.service.impl;

import cn.wandingkeji.bonus.service.IWdMemBonTransService;
import cn.wandingkeji.bonus.service.IWdMemBonusService;
import cn.wandingkeji.comm.enums.PayStatusEnum;
import cn.wandingkeji.comm.enums.ScenceEnum;
import cn.wandingkeji.comm.enums.TransType;
import cn.wandingkeji.member.entity.WdMemBonTrans;
import cn.wandingkeji.member.entity.WdMemBonus;
import cn.wandingkeji.member.mapper.WdMemBonTransMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员积分业务明细实现类
 *
 * @author jing_huan
 */
@Service("wdMemBonTransService")
public class WdMemBonTransServiceImpl implements IWdMemBonTransService {
    private static final Logger log = LoggerFactory.getLogger(WdMemBonTransServiceImpl.class);
    @Autowired
    private WdMemBonTransMapper wdMemBonTransMapper;

    @Autowired
    private IWdMemBonusService wdMemBonusService;
    /*
     * add by ws
     * 添加积分明细
     * 20190626
     */
    @Override
    public WdMemBonTrans insertBounsTrans(WdMemBonus wdMemBonus, Integer sid, Integer eid, String order_id, BigDecimal bouns,
                                          ScenceEnum scence, TransType transType, Map<String, Object> paramMap) {
        WdMemBonTrans wdMemBonTrans = new WdMemBonTrans();
        log.info("添加积分变动明细入参==" + paramMap);
        try {

            wdMemBonTrans.setMember_id(Integer.valueOf(wdMemBonus.getMember_id()));
            wdMemBonTrans.setMid(Integer.valueOf(wdMemBonus.getOrg()));
            wdMemBonTrans.setSid(sid);
            wdMemBonTrans.setEid(eid);
            wdMemBonTrans.setBonus_id(wdMemBonus.getId());

            wdMemBonTrans.setReason_id(scence.getScence());
            wdMemBonTrans.setOrder_id(order_id);
            wdMemBonTrans.setBouns(bouns);
            wdMemBonTrans.setTrans_type(transType.getStatus());
            if (TransType.IN.equals(transType)) {
                //存入
                wdMemBonTrans.setAccount_bouns(wdMemBonus.getAccount_bouns().add(bouns));
            } else if (TransType.OUT.equals(transType)) {
                wdMemBonTrans.setAccount_bouns(wdMemBonus.getAccount_bouns().subtract(bouns));
            }
            wdMemBonTrans.setStatus(PayStatusEnum.INSERT.getStatus());
            if (paramMap != null && paramMap.get("bal_trans_id") != null) {
                int bal_trans_id = (int) paramMap.get("bal_trans_id");
                log.info("***余额明细id存到积分明细记录中,以此做关联***");
                wdMemBonTrans.setBal_trans_id(bal_trans_id);
            }
            if (paramMap != null && paramMap.get("amount") != null) {
                BigDecimal amount = (BigDecimal) paramMap.get("amount");
                wdMemBonTrans.setAmount(amount);
            }
            wdMemBonTrans.setCreat_stamp(new Timestamp(System.currentTimeMillis()));

            //唯一orderId 主键判断
            WdMemBonTrans  trans = wdMemBonTransMapper.selectOneByOrderId(order_id);
            if (trans == null){
                log.info("不重复，新插入订单");
                wdMemBonTransMapper.insert(wdMemBonTrans);
            }else{
                log.info("重复订单");
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return wdMemBonTrans;
    }

    /*
     * 更新本地数据库积分明细和账户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WdMemBonTrans updateBonusAndTrans(String orderId, PayStatusEnum payStatus) {
        log.info("查询积分明细，orderId：{}，payStatus:{}", orderId, payStatus);
        WdMemBonTrans memBonTrans = null;
        try {
            //通过OrderId查询积分明细
            memBonTrans = wdMemBonTransMapper.selectOneByOrderId(orderId);
            if (memBonTrans == null) {
                log.info("查询积分明细为null，orderId：{}", orderId);
                return null;
            }
            WdMemBonTrans updateBonTrans = new WdMemBonTrans();
            updateBonTrans.setId(memBonTrans.getId());
            updateBonTrans.setStatus(payStatus.getStatus());
            wdMemBonTransMapper.updateByPrimaryKey(updateBonTrans);
            if (PayStatusEnum.SUCCESS.equals(payStatus)) {
                //支付成功，更新账户
                WdMemBonus updateMemBonus = new WdMemBonus();
                updateMemBonus.setId(memBonTrans.getBonus_id());
                updateMemBonus.setAccount_bouns(memBonTrans.getAccount_bouns());
                wdMemBonusService.updateById(updateMemBonus);
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return memBonTrans;
    }


    @Override
    public Map<String, Object> updateBonusAndTrans(int mem_id, String orderId, String scence, String status) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            Map<String, Object> conditionMap = new HashMap<>();
            conditionMap.put("member_id", mem_id);
            conditionMap.put("order_id", orderId);
            WdMemBonTrans wdMemBonTrans = selectByCondition(conditionMap);
            if (wdMemBonTrans != null) {
                // 不等于空,说明有积分变动 积分明细更新支付完成,在更新积分账户可用积分
                WdMemBonTrans memBonTrans = new WdMemBonTrans();
                memBonTrans.setStatus(status);
                log.info("***wdMemBonTrans=" + wdMemBonTrans.toString());
                memBonTrans.setId(wdMemBonTrans.getId());
                updateByPrimaryKey(memBonTrans);
                if ("2".equals(status)) {
                    returnMap.put("subCode", "000000");
                    log.info("***更新明细完成*支付状态为失败,不需要更新积分账户**");
                    return returnMap;
                }
                //更新积分账户
                WdMemBonus wdMemBonus = wdMemBonusService.selectByCondition(conditionMap);
                WdMemBonus memBonus = new WdMemBonus();
                memBonus.setAccount_bouns(wdMemBonTrans.getAccount_bouns());
                memBonus.setId(wdMemBonus.getId());
                wdMemBonusService.updateById(memBonus);
                log.info("***更新积分和明细完成***Bouns=" + memBonTrans.getBouns());
                returnMap.put("bonus", wdMemBonTrans.getBouns());
                returnMap.put("subCode", "000000");
            } else {
                returnMap.put("bonus", new BigDecimal("0"));
                returnMap.put("subCode", "900000");
            }
        } catch (Exception e) {
            returnMap.put("subCode", "100000");
            log.info("更新积分和明细异常");
            log.info(ExceptionUtils.getStackTrace(e));
        }
        return returnMap;
    }

    @Override
    public WdMemBonTrans selectByCondition(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.selectByCondition(whereCondition);
    }

    @Override
    public int insert(WdMemBonTrans wdMemBraTrans) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.insert(wdMemBraTrans);
    }

    @Override
    public int updateByPrimaryKey(WdMemBonTrans wdMemBraTrans) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.updateByPrimaryKey(wdMemBraTrans);
    }

    @Override
    public List<WdMemBonTrans> selectByOrderId(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.selectByOrderId(whereCondition);
    }

    @Override
    public Map<String, Object> selectTransCount(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.selectTransCount(whereCondition);
    }

    @Override
    public List<WdMemBonTrans> getAccTransByPager(Map<String, Object> whereCondition, int offset, int pageSize) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.getAccTransByPager(whereCondition, offset, pageSize);
    }

    @Override
    public List<Map<String, Object>> selectBounsDetail(Map<String, Object> whereCondition, int offset, int pageSize) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.selectBounsDetail(whereCondition, offset, pageSize);
    }

    @Override
    public WdMemBonTrans selectById(int id) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.selectById(id);
    }

    @Override
    public List<Map<String, Object>> getAllIntoTrans(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.getAllIntoTrans(whereCondition);
    }

    @Override
    public Map<String, Object> getTrasnsCountToPhone(Map<String, Object> whereCondition) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.getTrasnsCountToPhone(whereCondition);
    }

    @Override
    public List<Map<String, Object>> getAccTransToPhone(Map<String, Object> whereCondition, int offset, int pageSize) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.getAccTransToPhone(whereCondition, offset, pageSize);
    }

    @Override
    public WdMemBonTrans selectOneByOrderId(String orderId) {
        // TODO Auto-generated method stub
        return wdMemBonTransMapper.selectOneByOrderId(orderId);
    }


}
