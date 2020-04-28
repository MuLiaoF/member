package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;

/**
 * @author fjr
 * 查询导入code数目接口
 */
public class GetCodeCountRes extends ResBaseData {

    public GetCodeCountRes() {
        // TODO Auto-generated constructor stub
    }

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
