package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;

/**
 * @author fjr
 * 解密code接口
 */
public class DecryptCodeRes extends ResBaseData {

    public DecryptCodeRes() {
        // TODO Auto-generated constructor stub
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
