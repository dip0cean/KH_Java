package DB.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		String sql = "SELECT SUM(PRICE) 합계, AVG(PRICE) 평균 FROM PRODUCT WHERE EXTRACT(YEAR FROM MADE) = 2020";
	
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();
		int sum = rs.getInt("합계");
		int avg = rs.getInt("평균");
		con.close();
		System.out.println("sum = " + sum +"원");
		System.out.println("avg = " + avg + "원");

	}
}
