/**
 * 
 */
package tech.yhao.eclib.merchant.vo;

import java.util.Date;

import tech.yhao.eclib.merchant.constant.ErrorCode;
import tech.yhao.eclib.merchant.dao.MerchantDao;

/**
 * @author TaoJn 投放的优惠券对象
 */
public class PassTemplate {

	/** 商户Id */
	private Integer id;

	/** 优惠券标题 */
	private String title;

	/** 优惠券摘要 */
	private String summary;

	/** 优惠券消息描述 */
	private String description;

	/** 最大限制 */
	private Long limit;

	/** 优惠券是否有Token， 用于商户核销 */
	private boolean hasToken;

	/** 优惠券背景颜色 */
	private Integer background;

	/** 优惠券开始时间 */
	private Date start;

	/** 优惠券结束时间 */
	private Date end;

	public ErrorCode validate(MerchantDao merchantDao) {
		if (null == merchantDao.findById(id)) {
			return ErrorCode.MERCHANT_NOT_EXIST;
		}

		return ErrorCode.SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public boolean isHasToken() {
		return hasToken;
	}

	public void setHasToken(boolean hasToken) {
		this.hasToken = hasToken;
	}

	public Integer getBackground() {
		return background;
	}

	public void setBackground(Integer background) {
		this.background = background;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
