/**
 * 
 */
package tech.yhao.eclib.merchant.constant;

/**
 * @author TaoJn General constants definitions
 */
public class Constants {

	/** The kafka topic for merchants drop the pass template */
	public static final String TEMPLATE_TOPIC = "merchants-template";

	/**
	 * The token header.
	 */
	public static final String TOEKN_HEADER = "token";

	/**
	 * The token string used to validate whether the request is authorized or not
	 */
	public static final String TOEKN = "eclib-passbook-merchants";
}
