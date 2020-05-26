package DB.Connect.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		[1] ojdbc8.jar 라이브러리를 import 한다.
//		-	오라클 드라이버를 자바에서 인식하게 하도록 한다.
		Class.forName("oracle.jdbc.OracleDriver");

//		[2] 스트림을 만든다
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		con.close();
		System.out.println("성공을 원하나!");

	}

}
