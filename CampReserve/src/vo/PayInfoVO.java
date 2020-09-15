package vo;

public class PayInfoVO {
	private int pNo;
	private String noRes;
	private int pPrice;
	private String pMethod;
	private String pData;
	private String pState;
	
	public PayInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public PayInfoVO(int pNo, String noRes, int pPrice, String pMethod, String pData, String pState) {
		super();
		this.pNo = pNo;
		this.noRes = noRes;
		this.pPrice = pPrice;
		this.pMethod = pMethod;
		this.pData = pData;
		this.pState = pState;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getNoRes() {
		return noRes;
	}

	public void setNoRes(String noRes) {
		this.noRes = noRes;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpMethod() {
		return pMethod;
	}

	public void setpMethod(String pMethod) {
		this.pMethod = pMethod;
	}

	public String getpData() {
		return pData;
	}

	public void setpData(String pData) {
		this.pData = pData;
	}

	public String getpState() {
		return pState;
	}

	public void setpState(String pState) {
		this.pState = pState;
	}
}
