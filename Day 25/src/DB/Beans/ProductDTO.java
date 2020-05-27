package DB.Beans;

//	DTO > Data Transfer Object > 포장용 클래스
//	-	데이터 베이스의 한 줄은 자바에서는 하나의 객체와 같으므로 이를 포장하여 편하게 쓰기 위한 클래스
//	-	필드 + 기본 생성자 + setter/getter 기본적으로 필요
public class ProductDTO {
	// 필드 : DB 한 줄의 데이터를 필드 변수로 입력
	private int no;
	private String name;
	private String type;
	private int price;
	private String made;
	private String expire;

	public ProductDTO() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

}
