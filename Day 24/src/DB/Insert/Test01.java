package DB.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		목표 : STUDY 에 테이블을 만들고 해당하는 테이블에 데이터를 추가하는 것
//		-	테이블은 DB Tool 에서 제작 > 한번만 제작하면 되니까.
//		-	데이터는 어떻게 추가하는가?

//		진행 순서
//		[1] 드라이버 실행 -> [2] 연결 -> [3] 명령 준비 및 실행 -> [4] 종료 -> [5] 성공 메세지 출력

//		[1] 드라이버 실행
		Class.forName("oracle.jdbc.OracleDriver");

//		[2]	연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

//		[3-0]	명령 준비 및 실행 > DB Tool 에서 작업하듯이 명령을 준비해서 전송
		String sql = "INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, '심성헌',100,SYSDATE)";

//		[3-1] 전송 객체 생성 (연결이 되어 있을 때만 사용이 가능하므로 연결 정보에서 획득)
		PreparedStatement ps = con.prepareStatement(sql);
		
//		[3-2] 전송		
		ps.execute();
		
//		[4] 종료
		con.close();

//		[5]	메세지 출력
		System.out.println("성공");
	}

}
