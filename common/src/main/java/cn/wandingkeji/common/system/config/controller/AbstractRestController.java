package cn.wandingkeji.common.system.config.controller;

import cn.wandingkeji.common.system.config.data.RestApiResult;
import cn.wandingkeji.common.system.config.dataApi.ErrorCode;
import cn.wandingkeji.common.system.config.dataApi.RestErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 
 * @author liaoxiang
 *
 */

public class AbstractRestController extends AbstractController {

	protected static final String LOG_EXCEPTION_TEMPLET1 = "REST API:[%s],IP:[%s],code:[%s],msg:[%s],Ex:[%s]";

	protected static final String LOG_EXCEPTION_TEMPLET2 = "REST API:[%s],IP:[%s],code:[%s],msg:[%s],subCode:[%s],subMsg:[%s],Ex:[%s]";

	@Override
	protected <T> RestApiResult<T> success(T result) {
		return success(null, result);
	}

	@Override
	protected <T> RestApiResult<T> success(String msg, T result) {
		RestApiResult<T> apiResult = new RestApiResult<>();
		apiResult.setCode(SUCCESS);
		apiResult.setMsg("SUCCESS");
		apiResult.setSubCode(SUCCESS);
		apiResult.setSubMsg(msg);
		apiResult.setData(result);
		apiResult.setTimestamp(String.valueOf(new Date().getTime()));
		return apiResult;
	}

	@Override
	protected <T> RestApiResult<T> failure(String msg) {
		RestApiResult<T> apiResult = new RestApiResult<>();
		apiResult.setCode(SUCCESS);
		apiResult.setMsg("SUCCESS");
		apiResult.setSubCode(FAILURE);
		apiResult.setSubMsg(msg);
		apiResult.setTimestamp(String.valueOf(new Date().getTime()));
		return apiResult;
	}

	@Override
	protected <T> RestApiResult<T> failure(ErrorCode errorCode) {
		RestApiResult<T> apiResult = new RestApiResult<>();
		apiResult.setCode(errorCode.getCode());
		apiResult.setMsg(errorCode.getMsg());
		if (errorCode instanceof RestErrorCode) {
			RestErrorCode restErrorCode = (RestErrorCode) errorCode;
			apiResult.setSubCode(restErrorCode.getSubCode());
			apiResult.setSubMsg(restErrorCode.getSubMsg());
		}
		apiResult.setTimestamp(String.valueOf(new Date().getTime()));
		return apiResult;
	}

	protected <T> RestApiResult<T> failure(String subCode, String subMsg) {
		return failure(null, subCode, subMsg);
	}

	protected <T> RestApiResult<T> failure(ErrorCode errorCode, String subCode, String subMsg) {
		RestApiResult<T> apiResult = new RestApiResult<>();
		apiResult.setCode(SUCCESS);
		apiResult.setMsg("SUCCESS");
		apiResult.setSubCode(errorCode != null ? errorCode.getCode() + ";" : "" + subCode);
		apiResult.setSubMsg(errorCode != null ? errorCode.getMsg() + ";" : "" + subMsg);
		apiResult.setTimestamp(String.valueOf(new Date().getTime()));
		return apiResult;
	}

	private String getDetailsInfo(final String msg, final String detailsInfo) {
		boolean flag = false;
		StringBuilder builder = new StringBuilder(4);
		if (!StringUtils.isEmpty(msg)) {
			builder.append(msg);
			flag = true;
		}
		if (flag) {
			if (!StringUtils.isEmpty(detailsInfo)) {
				builder.append("(").append(detailsInfo).append(")");
			}
		} else {
			builder.append(detailsInfo);

		}
		return builder.toString();
	}

}
