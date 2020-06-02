package DB.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) throws ClassNotFoundException {
		PreparedStatement ps;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 > ");
			String id = sc.nextLine();
			System.out.print("비밀번호 > ");
			String pw = sc.nextLine();
			sc.close();

			Class.forName("oracle.jdbc.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

			String sql = "INSERT INTO CLIENT VALUES(CLIENT_SEQ.NEXTVAL, ?, ?, '일반회원', SYSDATE, 1000)";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);

			ps.execute();

			con.close();

			System.out.println("회원가입이 완료되었습니다. 감사합니다.");

		} catch (SQLException e) {

			System.out.println("이미 사용중인 아이디입니다.");

		}

	}

}
