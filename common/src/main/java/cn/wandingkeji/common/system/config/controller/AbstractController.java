package cn.wandingkeji.common.system.config.controller;

import cn.wandingkeji.common.system.config.dataApi.ErrorCode;
import cn.wandingkeji.common.system.config.dataApi.Result;

/**
 * 
 * @author liaoxiang
 *
 */
public abstract class AbstractController {

	protected static final String SUCCESS = "000000";

	protected static final String FAILURE = "100000";

	protected <T> boolean isSuccess(Result<T> result) {
		return result != null && SUCCESS.equals(result.getCode());
	}

	protected <T> boolean isFailure(Result<T> result) {
		return result != null && FAILURE.equals(result.getCode());
	}

	protected abstract <T> Result<T> success(T result);

	protected abstract <T> Result<T> success(String msg, T result);

	protected abstract <T> Result<T> failure(String msg);

	protected abstract <T> Result<T> failure(ErrorCode errorCode);

}
