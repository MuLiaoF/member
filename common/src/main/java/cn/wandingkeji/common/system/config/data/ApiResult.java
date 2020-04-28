package cn.wandingkeji.common.system.config.data;

import cn.wandingkeji.common.system.config.dataApi.Result;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResult<T> extends Result<T> {

	private static final long serialVersionUID = 4957503755669493540L;
	
	protected String timestamp;

}
