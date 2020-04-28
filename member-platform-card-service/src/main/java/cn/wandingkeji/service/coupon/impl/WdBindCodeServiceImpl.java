package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.coupon.entity.WdBindCode;
import cn.wandingkeji.coupon.mapper.WdBindCodeMapper;
import cn.wandingkeji.member.api.WdMemberApi;
import cn.wandingkeji.member.entity.WdMember;
import cn.wandingkeji.service.coupon.IWdBindCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("wdBindCodeService")
public class WdBindCodeServiceImpl implements IWdBindCodeService {

	@Autowired
	private WdBindCodeMapper wdBindCodeMapper;

	/**
	 * 通过id查询
	 */
	@Override
	public WdBindCode selectById(int id) {
		return wdBindCodeMapper.selectById(id);
	}

	/**
	 * 通过mdCode查询
	 */
	@Override
	public WdBindCode selectByMdCode(String mdCode) {
		return wdBindCodeMapper.selectByMdCode(mdCode);
	}
	/**
	 * 添加
	 */
	@Override
	public int insert(WdBindCode bindCode) {
		return wdBindCodeMapper.insert(bindCode);
	}
	/**
	 * 更新
	 */
	@Override
	public int updateById(WdBindCode bindCode) {
		return wdBindCodeMapper.updateById(bindCode);
	}

	@Override
	public void deleteByMdCode(String mdCode) {
		 wdBindCodeMapper.deleteByMdCode(mdCode);
	}

}
