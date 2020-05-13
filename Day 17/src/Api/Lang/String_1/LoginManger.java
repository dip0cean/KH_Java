package Api.Lang.String_1;

public class LoginManger {
	private User[] data = new User[3];

	public LoginManger() {
		data[0] = new User("tester", "test1234");
		data[1] = new User("master", "master1234");
		data[2] = new User("user", "user1234");

	}

	public boolean login(String id, String pw) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (id.equals(data[i].getId()) && pw.equals(data[i].getPw())) {
				count++;
				break;
			}
		}
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}
}
