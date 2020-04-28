package cn.wandingkeji.common.system.config.dataApi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_EMPTY)
public abstract class Result<T> implements Serializable {

	private static final long serialVersionUID = -2222823015828263118L;

	protected String code;

	protected String msg;

	protected T data;
	
	protected String timestamp;

}
