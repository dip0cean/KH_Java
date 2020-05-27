package DB.Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// [1] 사용자 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("포함할 문자를 입력하세요 > ");
		String str = sc.nextLine();
		sc.close();

		// [2] Driver 실행
		Class.forName("oracle.jdbc.OracleDriver");

		// [3] Driver 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		// [4] SQL 로 전달할 명령어 변수화
		String sql = "SELECT * FROM CLIENT WHERE INSTR(CLIENT_ID ,?) > 0";

		// [4] ? 부분 변별
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, str);

		// [5] 전달된 명령값 회수
		ResultSet rs = ps.executeQuery();
		System.out.println("------------------------------------------------------------------------------");
		while (rs.next()) {
			System.out.print(rs.getInt(1) + " \t|\t");
			System.out.print(rs.getString(2) + "\t|\t");
			System.out.print(rs.getString(4) + "\t");
			System.out.println();
			System.out.println("------------------------------------------------------------------------------");
		}
		con.close();
	}

}
