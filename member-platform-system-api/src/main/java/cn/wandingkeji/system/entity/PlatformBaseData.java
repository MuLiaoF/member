package cn.wandingkeji.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
	@author jing_huan 
	@Description 平台基础数据对象
	@Date 2019年6月6日
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlatformBaseData {
	
	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 数据描述
	 */
	private String dataType;
	
	/**
	 * key
	 */
	private String dataKey;
	
	/**
	 * value
	 */
	private String dataValue;




}
