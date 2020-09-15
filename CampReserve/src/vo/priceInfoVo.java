package vo;

public class priceInfoVo {
	private	int nights;
	private int addPpl;
	private int addPrice;
	private int price1;
	private int price2;
	
	public priceInfoVo() {
		// TODO Auto-generated constructor stub
	}

	

	public priceInfoVo(int nights, int addPpl, int addPrice, int price1, int price2) {
		super();
		this.nights = nights;
		this.addPpl = addPpl;
		this.addPrice = addPrice;
		this.price1 = price1;
		this.price2 = price2;
	}


	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}



	public int getAddPpl() {
		return addPpl;
	}

	public void setAddPpl(int addPpl) {
		if(addPpl < 0) {
			addPpl = 0;
		}
		this.addPpl = addPpl;
	}

	public int getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(int addPrice) {
		this.addPrice = addPrice;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}
}
