package cn.wandingkeji.common.base.wx.mp.protocol.member;

import java.util.Map;

/*
 *  更新会员信息
 *  add by ws
 *  0520
 */
public class UpdateUserReq {

    private String code;
    private String card_id;
    private String background_pic_url;
    private String record_bonus;//商家自定义积分消耗记录
    private Integer bonus;
    private Integer add_bonus;
    private Integer balance;
    private Integer add_balance;
    private String record_balance;
    private String custom_field_value1;
    private String custom_field_value2;
    private String custom_field_value3;
    private Map<String, Object> notify_optional;


    public String getCustom_field_value3() {
        return custom_field_value3;
    }

    public void setCustom_field_value3(String custom_field_value3) {
        this.custom_field_value3 = custom_field_value3;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getBackground_pic_url() {
        return background_pic_url;
    }

    public void setBackground_pic_url(String background_pic_url) {
        this.background_pic_url = background_pic_url;
    }

    public String getRecord_bonus() {
        return record_bonus;
    }

    public void setRecord_bonus(String record_bonus) {
        this.record_bonus = record_bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getAdd_bonus() {
        return add_bonus;
    }

    public void setAdd_bonus(Integer add_bonus) {
        this.add_bonus = add_bonus;
    }

    public String getCustom_field_value1() {
        return custom_field_value1;
    }

    public void setCustom_field_value1(String custom_field_value1) {
        this.custom_field_value1 = custom_field_value1;
    }

    public String getCustom_field_value2() {
        return custom_field_value2;
    }

    public void setCustom_field_value2(String custom_field_value2) {
        this.custom_field_value2 = custom_field_value2;
    }

    public Map<String, Object> getNotify_optional() {
        return notify_optional;
    }

    public void setNotify_optional(Map<String, Object> notify_optional) {
        this.notify_optional = notify_optional;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAdd_balance() {
        return add_balance;
    }

    public void setAdd_balance(Integer add_balance) {
        this.add_balance = add_balance;
    }

    public String getRecord_balance() {
        return record_balance;
    }

    public void setRecord_balance(String record_balance) {
        this.record_balance = record_balance;
    }


}
