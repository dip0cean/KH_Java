package DB.Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요. > ");
		String str = sc.nextLine();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		String sql = "SELECT * FROM CLIENT WHERE INSTR(CLIENT_ID, ?) > 0 ORDER BY CLIENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, str);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(4) + "\t");
			System.out.println();
			System.out.println("------------------------------");
		}

		con.close();

	}

}
