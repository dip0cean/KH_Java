package DB.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		목표 : 등록한 ojdbc8.jar 를 이용하여 데이터 베이스에 접속하여 명령을 실행

//		[1]	등록한 ojdbc8.jar 에서 정보 파일을 불러와서 실행
		Class.forName("oracle.jdbc.OracleDriver");

//		[2] 오라클 데이터베이스와 연결할 수 있도록 통로를 생성(Connection)		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KH", "KH");

//		[3] 원하는 명령을 준비해서 전송

//		[4] 연결 종료
		con.close();
		System.out.println("성공!");
	}

}
