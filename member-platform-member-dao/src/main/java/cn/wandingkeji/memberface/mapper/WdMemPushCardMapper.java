package cn.wandingkeji.memberface.mapper;

import cn.wandingkeji.memberface.entity.WdMemberWxPush;
import org.apache.ibatis.annotations.Param;

public interface WdMemPushCardMapper {


    /**
     * 根据门店及商户ID查询规则
     * @param shopId
     * @param merchantId
     * @return
     */
    WdMemberWxPush selectBySidAndMid(@Param("sid") Integer shopId, @Param("mid") String merchantId) throws Exception;

}
