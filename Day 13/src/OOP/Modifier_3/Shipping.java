package OOP.Modifier_3;

public class Shipping {

//	Field	
	String zip, city1, city2;

//	Setter / Getter Method
	private void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip() {
		return this.zip;
	}

	private void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity1() {
		return this.city1;
	}

	private void setCity2(String city2) {
		this.city2 = city2;
	}

	public String getCity2() {
		return this.city2;
	}

	public String total() {
		return "배송지 : " + "[" + this.getZip() + "] " + this.getCity1() + " " + this.getCity2();
	}

	public Shipping(String zip, String city1, String city2) {
		this.setZip(zip);
		this.setCity1(city1);
		this.setCity2(city2);

	}

}
