package tech.yhao.eclib.merchant.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * It presents the merchant entity. It is the mapping class for merchants table.
 * 
 * @author TaoJn
 */
@Entity
@Table(name = "merchants")
public class Merchant {

	/** Merchant key. **/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	/** Merchant name. **/
	@Basic
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	/** Merchant logo url. **/
	@Basic
	@Column(name = "logo_url", nullable = false)
	private String logoUrl;

	/** Merchant business license url. **/
	@Basic
	@Column(name = "license_url", nullable = false)
	private String licenseUrl;

	/** Merchant contact phone number. **/
	@Basic
	@Column(name = "phone", nullable = false)
	private String phone;

	/** Merchant contact address. **/
	@Basic
	@Column(name = "address", nullable = false)
	private String address;

	/** A flag indicating whether merchant has been auditted. **/
	@Basic
	@Column(name = "is_audit", nullable = false)
	private Boolean isAudit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Boolean getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(Boolean isAudit) {
		this.isAudit = isAudit;
	}

}
