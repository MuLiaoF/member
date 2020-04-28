package cn.wandingkeji.member.mapper;

import cn.wandingkeji.member.entity.WdMember;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 会员信息 dao
 * @author jing_huan
 *
 */
public interface WdMemberMapper {
	
	int insert(@Param("wdMember") WdMember wdMember);
	WdMember selectMemByCondition(@Param("condition") Map<String, Object> whereCondition);
	int selectMemberCount(@Param("condition") Map<String, Object> whereCondition);
	List<Map<String,Object>> getMemberByPager(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);
	WdMember selectMemByPrimaryKey(int id);

	int updatePwdByPrimaryKey(@Param("wdMember") WdMember wdMember);

	WdMember checkMemByCondition(@Param("condition") Map<String, Object> whereCondition);

	int updateStatusByPrimaryKey(@Param("wdMember") WdMember wdMember);
	int updateInfoByKey(@Param("wdMember") WdMember wdMember);
	//add by wjl 通过mid和person_id获取会员信息
	WdMember getMemberByMidAndCondition(@Param("condition") Map<String, Object> whereCondition);
	int updateMemberPersonIdByPrimaryKey(@Param("wdMember") WdMember wdMember);

	//add ws 通过小程序的openId查询会员
	WdMember getMemByMiniCondition(@Param("condition") Map<String, Object> whereCondition);
	//ADD BY WS 20180124  激活时更新等级和门店
	int updateLevel(@Param("wdMember") WdMember wdMember);
	//add by ws 按照积分、余额排序查询会员列表
	List<Map<String,Object>> getMemberByAccount(@Param("condition") Map<String, Object> whereCondition, @Param("offset") int offset, @Param("pageSize") int pageSize);

    WdMember getMemberByOpenId(@Param("openId") String openId);

	Map<String, Object> queryMemLevelInfo(@Param("condition") Map<String, Object> whereCondition);
	Map<String, Object> selectMemDonate(@Param("mid") Integer mid, @Param("sid") int sid, @Param("member_id") Integer member_id);
	Map<String, Object> queryMemberBalance(@Param("member_id") Integer member_id);
	void insertDonateAmounts(@Param("mid") Integer mid, @Param("sid") int sid, @Param("member_id") Integer member_id,
                             @Param("donate_amount") BigDecimal donate_amount);
	void updateMemDonates(@Param("mid") Integer mid, @Param("sid") int sid, @Param("member_id") Integer member_id, @Param("donateAmount") BigDecimal donateAmount,
                          @Param("sum_donate") BigDecimal sum_donate);
	Map<String, Object> getConsumerByOpenid(@Param("member_id") int member_id, @Param("mid") int mid);

	//TODO
	//WdCardLevel queryWdCardById(@Param("mid") int mid, @Param("wx_card_id") String wx_card_id, @Param("levelId") Integer levelId);

	//TODO
	//WdCardLevel queryWdCardBySort(@Param("mid") int mid, @Param("wx_card_id") String wx_card_id, @Param("id") String id);
	void updateMemberInfo(@Param("member_id") int member_id, @Param("mid") int mid, @Param("currentLevel") String currentLevel, @Param("currLevelName") String currLevelName);
	Map<String, Object> queryPushTokenId(@Param("mid") int mid, @Param("token_type") String token_type);
	Map<String, Object> findByDataKey(@Param("dataKey") String dataKey);
	List<Map<String, Object>> queryDonateAndBalanceInfo(@Param("member_id") int member_id);
	Map<String, Object> queryDonateInfo(@Param("memberId") int memberId, @Param("mid") Integer mid, @Param("sid") Integer sid);
	void updateDonateAmount(@Param("donateMap") Map<String, Object> donateMap);


}