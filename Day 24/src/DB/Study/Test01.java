package DB.Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Insert
		Scanner sc = new Scanner(System.in);

		System.out.print("호텔 > ");
		String name = sc.nextLine();
		System.out.print("위치 > ");
		String reg = sc.nextLine();
		System.out.print("평점 > ");
		double rate = sc.nextDouble();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		String insert = "INSERT INTO HOTEL VALUES(HOTEL_SEQ.NEXTVAL, ?, ?, ?)";

		PreparedStatement in = con.prepareStatement(insert);
		in.setString(1, name);
		in.setString(2, reg);
		in.setDouble(3, rate);
		in.execute();

		String select = "SELECT * FROM HOTEL ORDER BY HOTEL_CODE";

		PreparedStatement out = con.prepareStatement(select);
		ResultSet rs = out.executeQuery();

		System.out.println("호텔 목록 > ");
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getDouble(4) + "\t");
			System.out.println();
		}
		con.close();

	}

}
