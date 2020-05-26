package DB.Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		String sql = "SELECT * FROM CLIENT WHERE INSTR(CLIENT_ID ,'d') > 0";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		System.out.println("------------------------------------------------------------------------------");
		while (rs.next()) {
			System.out.print(rs.getInt(1) + " \t|\t");
			System.out.print(rs.getString(2) + "\t|\t");
			System.out.print(rs.getString(3) + "\t|\t");
			System.out.print(rs.getString(4) + "\t");
			System.out.println();
			System.out.println("------------------------------------------------------------------------------");
		}
		con.close();
	}

}
