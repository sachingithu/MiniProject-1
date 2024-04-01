package in.ashokit.dto;

public class Dashboard {
	private Long totalEnquiry;
	private Long openEnquiry;
	private Long enrolledEnquiry;
	private Long lostEnuiry;
	public Long getTotalEnquiry() {
		return totalEnquiry;
	}
	public void setTotalEnquiry(Long totalEnquiry) {
		this.totalEnquiry = totalEnquiry;
	}
	public Long getOpenEnquiry() {
		return openEnquiry;
	}
	public void setOpenEnquiry(Long openEnquiry) {
		this.openEnquiry = openEnquiry;
	}
	public Long getEnrolledEnquiry() {
		return enrolledEnquiry;
	}
	public void setEnrolledEnquiry(Long enrolledEnquiry) {
		this.enrolledEnquiry = enrolledEnquiry;
	}
	public Long getLostEnuiry() {
		return lostEnuiry;
	}
	public void setLostEnuiry(Long lostEnuiry) {
		this.lostEnuiry = lostEnuiry;
	}
	
}
