package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;

import java.util.List;

/**
 * @author fjr
 * <p>
 * 核查code接口res
 */
public class CheckCodeRes extends ResBaseData {


    public CheckCodeRes() {
    }

    List<String> exist_code;
    List<String> not_exist_code;

    public List<String> getExist_code() {
        return exist_code;
    }

    public void setExist_code(List<String> exist_code) {
        this.exist_code = exist_code;
    }

    public List<String> getNot_exist_code() {
        return not_exist_code;
    }

    public void setNot_exist_code(List<String> not_exist_code) {
        this.not_exist_code = not_exist_code;
    }

}
