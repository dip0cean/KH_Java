package DB.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		PreparedStatement 의 방식을 이용하여 오류없이 데이터를 추가하여 명령 실행
		String name = "홍길동";
		int score = 59;
		
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");
		String sql = "INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, ? , ? , SYSDATE)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setInt(2, score);
		ps.execute();
		
		con.close();
		System.out.println("성공!");
	}

}
