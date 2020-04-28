package cn.wandingkeji.member.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 会员消费详情
 */

@Setter
@Getter
@ToString
public class WdMemConsumeInfo {

    private int id;

    /**
     * order_id  订单id
     */
    private String orderId;

    /**
     * store id 门店id
     */
    private int sid;

    /**
     * mid
     */

    private int mid;
    /**
     * 会员id
     */
    private int memberId;

    /**
     * 消费总金额
     */
    private BigDecimal totalAmount;

    /**
     * 余额支付
     */
    private BigDecimal balancePay;

    /**
     * 赠送支付
     */

    private BigDecimal giftPay;

    /**
     * 支付时间
     */
    private Timestamp payTime;

    /**
     * 支付状态 0->初始状态，1->支付成功，2->支付失败
     */
    private int status;

}
