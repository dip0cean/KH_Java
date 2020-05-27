package DB.Task;

public class ClientDTO {
//	Field

	private int client_no;
	private String client_id;
	private String client_pw;
	private String client_auth;
	private String client_join;
	private int client_point;

	public ClientDTO() {
		super();
	}

	public int getNumber() {
		return client_no;
	}

	public void setNumber(int number) {
		this.client_no = number;
	}

	public String getId() {
		return client_id;
	}

	public void setId(String id) {
		this.client_id = id;
	}

	public String getPw() {
		return client_pw;
	}

	public void setPw(String pw) {
		this.client_pw = pw;
	}

	public String getAuth() {
		return client_auth;
	}

	public void setAuth(String auth) {
		this.client_auth = auth;
	}

	public String getJoin() {
		return client_join;
	}

	public void setJoin(String join) {
		this.client_join = join;
	}

	public int getPoint() {
		return client_point;
	}

	public void setPoint(int point) {
		this.client_point = point;
	}

}
