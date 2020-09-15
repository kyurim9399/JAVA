package vo;

public class campSiteVo {
	private String siteCode; // 
	private String areaCode; // 
	private int minPpl; // 객실코드
	private int maxPpl; // 예약인원
	private int cPrice; // 객실총가격
	
	public campSiteVo() {
		// TODO Auto-generated constructor stub
	}

	public campSiteVo(String siteCode, String areaCode, int minPpl, int maxPpl, int cPrice) {
		super();
		this.siteCode = siteCode;
		this.areaCode = areaCode;
		this.minPpl = minPpl;
		this.maxPpl = maxPpl;
		this.cPrice = cPrice;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getMinPpl() {
		return minPpl;
	}

	public void setMinPpl(int minPpl) {
		this.minPpl = minPpl;
	}

	public int getMaxPpl() {
		return maxPpl;
	}

	public void setMaxPpl(int maxPpl) {
		this.maxPpl = maxPpl;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}
	
}
