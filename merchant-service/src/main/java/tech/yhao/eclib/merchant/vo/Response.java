/**
 * 
 */
package tech.yhao.eclib.merchant.vo;

import tech.yhao.eclib.merchant.constant.ErrorCode;

/**
 * @author TaoJn
 *
 */
public class Response {

	/** Error code, 0 means success */
	private Integer errorCode;

	/** Error Message */
	private String errorMsg;

	/** The response data */
	private Object data;

	public Response(ErrorCode errorCode) {
		this.setErrorCode(errorCode.getCode());
		this.setErrorMsg(errorCode.getDesc());
	}

	public Response(Object data) {
		this.data = data;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
