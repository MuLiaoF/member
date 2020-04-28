package cn.wandingkeji.common.system.config.dataApi;

public interface RestErrorCode extends ErrorCode {

	String getSubCode();

	void setSubCode(String subCode);

	String getSubMsg();

	void setSubMsg(String subMsg);


}
