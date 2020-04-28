package cn.wandingkeji.common.system.config.data;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestApiResult<T> extends ApiResult<T> {

	private static final long serialVersionUID = -1305295834810515230L;

	@JsonSetter(value = "sub_code")
	protected String subCode;

	@JsonSetter(value = "sub_msg")
	protected String subMsg;

	protected String url;

}
