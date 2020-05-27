package DB.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		목표 : STUDY 계정의 STUDENT 테이블 데이터 개수를 구하시오
//		구문 : SELECT COUNT(*) FROM STUDENT;

//		준비
//		처리 > SELECT
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		String sql = "SELECT COUNT(*) FROM STUDENT";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

//		그룹 함수를 실행할 경우에은 일반적인 SELECT 와는 다르게
//		데이터가 무조건 1개가 나오므로 WHILE 문이 필요하지 않고 바로 이동하여 데이터를 불러온다.
//		-	count(), min(), max(), sum(), avg() emd
		rs.next();
		int count = rs.getInt(1);
		System.out.println(count);
		con.close();
	}

}
