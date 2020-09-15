package vo;

public class reserveVo {
	private String noRes; // 예약번호
	private String id; // 회원아이디
	private String siteCode; // 객실코드
	private int total_p; // 예약인원
	private int sPrice; // 객실총가격
	private String stdDate; // 예약날짜
	private String endDate; // 퇴실날짜

	// 기본생성자
	public reserveVo() {}

	// 모든 매개변수 생성자
	public reserveVo(String noRes, String id, String siteCode, int total_p, int sPrice, String stdDate, String endDate) {
		super();
		this.noRes = noRes;
		this.id = id;
		this.siteCode = siteCode;
		this.total_p = total_p;
		this.sPrice = sPrice;
		this.stdDate = stdDate;
		this.endDate = endDate;
	}

	public String getNoRes() {
		return noRes;
	}

	public void setNoRes(String noRes) {
		this.noRes = noRes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public int getTotal_p() {
		return total_p;
	}

	public void setTotal_p(int total_p) {
		this.total_p = total_p;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public String getStdDate() {
		return stdDate;
	}

	public void setStdDate(String stdDate) {
		this.stdDate = stdDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
