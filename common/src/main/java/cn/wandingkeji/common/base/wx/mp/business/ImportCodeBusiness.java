package cn.wandingkeji.common.base.wx.mp.business;


import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.CheckCodeReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.DepositCodeReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code.GetCodeCountReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code.CheckCodeRes;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code.DepositCodeRes;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.code.GetCodeCountRes;
import cn.wandingkeji.common.base.wx.mp.service.CheckCodeService;
import cn.wandingkeji.common.base.wx.mp.service.DepositCodeService;
import cn.wandingkeji.common.base.wx.mp.service.GetCodeCountService;
import cn.wandingkeji.common.base.wx.mp.service.ModifyStockService;
import cn.wandingkeji.common.base.wx.mp.util.ApiException;
import cn.wandingkeji.common.base.wx.mp.util.Log;
import cn.wandingkeji.common.base.wx.mp.util.WXPayExcepFactor;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 导入code
 * add by ws 0513
 */
public class ImportCodeBusiness {

    private String access_token;
    //	private PosCreatQrService posCreatQrService;
    private static Log log = new Log();
    private DepositCodeService depositCodeService;
    private CheckCodeService checkCodeService;
    private GetCodeCountService getCodeCountService;
    private ModifyStockService modifyStockService;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public ImportCodeBusiness(String access_token) {
        this.access_token = access_token;
        depositCodeService = new DepositCodeService(access_token);
        checkCodeService = new CheckCodeService(access_token);
        getCodeCountService = new GetCodeCountService(access_token);
        modifyStockService = new ModifyStockService(access_token);

    }

    public DepositCodeRes run(DepositCodeReq depositCodeReq) {

        long costTimeStart = System.currentTimeMillis();
        String responseContent = depositCodeService.request(depositCodeReq);
        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.i("api请求总耗时：" + totalTimeCost + "ms");
        log.i("==responseContent==" + responseContent);

        DepositCodeRes depositCodeRes = (DepositCodeRes) JSON.parseObject(responseContent, DepositCodeRes.class);
        if (depositCodeRes == null || depositCodeRes.getErrcode() == null) {
            log.e("【导入code失败】创建二维码请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_ERROR, "请检测数据是否规范合法");
        }

        if (!depositCodeRes.getErrcode().equals("0")) {
            //注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.e("【导入code失败】创建二维码API系统返回失败，请检测Post给API的数据是否规范合法");
            throw new ApiException(WXPayExcepFactor.E_RETURN_CODE_FAIL, "请检测数据是否规范合法");
        } else {
            log.i("创建二维码API系统成功返回数据");
            //处理depositCodeRes返回值，如果重复或失败应该删除
            List<String> duplicate_code = depositCodeRes.getDuplicate_code();
            List<String> fail_code = depositCodeRes.getFail_code();
            List<String> code = depositCodeReq.getCode();
            List<String> codeCopy = new ArrayList<String>();
            Collections.copy(code, codeCopy);
            codeCopy.removeAll(duplicate_code);
            codeCopy.removeAll(fail_code);
            if (codeCopy.size() == 0) {
                log.e("此次导入生效的code为空");
                return depositCodeRes;
            }
            //查询code数目,注意：经测试只要调用导入code接口，经查询code接口查询的结果数量就是在原来基础上增加导入的code,即使code重复也会增加，所以更新库存不能以getCodeCountRes.getCount()为准
            GetCodeCountReq getCodeCountReq = new GetCodeCountReq();
            getCodeCountReq.setCard_id(depositCodeReq.getCard_id());
            GetCodeCountRes getCodeCountRes = getCodeCountService.request(getCodeCountReq);
            log.d("查询导入code数目：" + getCodeCountRes.getCount());
            //核查code
            CheckCodeReq checkCodeReq = new CheckCodeReq();
            checkCodeReq.setCard_id(depositCodeReq.getCard_id());
            checkCodeReq.setCode(codeCopy);
            CheckCodeRes checkCodeRes = checkCodeService.request(checkCodeReq);
            if (codeCopy.size() == checkCodeRes.getExist_code().size()) {

            }
            return depositCodeRes;

        }

    }


}
