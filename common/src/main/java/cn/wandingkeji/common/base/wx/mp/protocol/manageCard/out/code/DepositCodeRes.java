package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;

import java.util.List;

/**
 * @author fjr
 * 导入code
 */
public class DepositCodeRes extends ResBaseData {

    public DepositCodeRes() {
    }

    private List<String> succ_code;//成功个数
    private List<String> duplicate_code;//重复导入的code会自动被过滤。
    private List<String> fail_code;//失败个数


    public List<String> getSucc_code() {
        return succ_code;
    }


    public void setSucc_code(List<String> succ_code) {
        this.succ_code = succ_code;
    }


    public List<String> getDuplicate_code() {
        return duplicate_code;
    }


    public void setDuplicate_code(List<String> duplicate_code) {
        this.duplicate_code = duplicate_code;
    }


    public List<String> getFail_code() {
        return fail_code;
    }


    public void setFail_code(List<String> fail_code) {
        this.fail_code = fail_code;
    }


    public static void main(String[] args) {

//		DepositCodeRes test = new DepositCodeRes();
//		test.setDuplicate_code(1);
//		test.setErrcode("0");test.setErrmsg("ok");
//		test.setFail_code(2);
//		test.setSucc_code(7);
//		System.out.println(JSONObject.toJSONString(test));
//		
    }

}
