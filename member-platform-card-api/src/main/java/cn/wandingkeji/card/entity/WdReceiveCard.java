package cn.wandingkeji.card.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 领取会员卡实体
 * @author jing_huan
 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WdReceiveCard {
    private Integer id;

    private String card_id;

    private String user_openid;

    private String friend_openid;

    private String user_card_code;

    private String old_user_card_code;

    private String outer_str;

    private Boolean is_restore_memcard;

    private String unionid;

    private String empId;
    private String scene;
    private String scenevalue;
    private String reserve1;
    private String reserve2;
    private String reserve3;

    private String receivetime;

    private Timestamp createtime;

   
}