/**
 * 
 */
package tech.yhao.eclib.merchant.vo;

import org.springframework.util.StringUtils;

import tech.yhao.eclib.merchant.constant.ErrorCode;
import tech.yhao.eclib.merchant.dao.MerchantDao;
import tech.yhao.eclib.merchant.entity.Merchant;

/**
 * @author TaoJn
 *
 */
public class CreateMerchantRequest {

	private String name;
	private String logoUrl;
	private String licenseUrl;
	private String phone;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ErrorCode validate(MerchantDao merchantDao) {
		if (StringUtils.isEmpty(name)) {
			return ErrorCode.EMPTY_NAME;
		}

		if (StringUtils.isEmpty(logoUrl)) {
			return ErrorCode.EMPTY_LOGO;
		}

		if (StringUtils.isEmpty(licenseUrl)) {
			return ErrorCode.EMPTY_LICENSE;
		}

		if (StringUtils.isEmpty(phone)) {
			return ErrorCode.ERROR_PHONE;
		}

		if (StringUtils.isEmpty(address)) {
			return ErrorCode.EMPTY_ADDRESS;
		}

		return ErrorCode.SUCCESS;
	}

	public Merchant toMerchant() {
		Merchant merchant = new Merchant();
		merchant.setName(name);
		merchant.setLogoUrl(logoUrl);
		merchant.setLicenseUrl(licenseUrl);
		merchant.setPhone(phone);
		merchant.setAddress(address);
		merchant.setIsAudit(false);

		return merchant;
	}

}
