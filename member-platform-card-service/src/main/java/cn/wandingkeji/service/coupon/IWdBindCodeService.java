package cn.wandingkeji.service.coupon;

import cn.wandingkeji.coupon.entity.WdBindCode;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 用于绑定核销时code码接口
 *
 * @author jing_huan
 */
public interface IWdBindCodeService {

    WdBindCode selectById(int id);

    WdBindCode selectByMdCode(String mdCode);

    int insert(WdBindCode bindCode);

    int updateById(WdBindCode bindCode);

    void deleteByMdCode(String mdCode);

}
