/**
 * 
 */
package tech.yhao.eclib.merchant.constant;

/**
 * @author TaoJn
 * 
 *         Error code enum defintion
 */
public enum ErrorCode {

	SUCCESS(0, ""),

	DUPLICATE_NAME(1, "merchant name duplicate"),

	EMPTY_LOGO(2, "merchant logo is empty"),

	EMPTY_LICENSE(3, "merchant license url is empty"),

	ERROR_PHONE(4, "merchant phone is invalid"),

	EMPTY_ADDRESS(5, "merchant address is empty"),

	MERCHANT_NOT_EXIST(6, "merchant does not exist"),

	EMPTY_NAME(7, "merchant name is empty");

	private Integer code;
	private String desc;

	ErrorCode(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}
}
