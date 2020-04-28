package cn.wandingkeji.memberface.entity;


import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 到店通知
 * @author w.d.k.j
 */
@Data
@ToString
public class WdMemberWxPush {


    private Integer id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * sid
     */
    private Integer sid;

    /**
     * mid
     */
    private Integer mid;

    /**
     * 卡券id
     */
    private String cardId;


    /**
     * 卡券名称
     */
    private String cardTitle;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 备注
     */
    private String remark;

    private String storeName;
}
