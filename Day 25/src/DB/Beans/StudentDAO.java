package DB.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//	DAO > Data Access Object > 데이터(DB) 접근 객체
//	-	DB 에 연관된 기능들을 보관한 뒤 편하게 불러서 사용하도록 구성하는 클래스
public class StudentDAO {

	// DB에는 반드시 연결 코드가 있어야 하니가 보관해두고 불러서 사용
	// - 수행 내용 : 데이터 베이스 연결 (드라이버 로딩 + 연결코드)
	// - 반환 데이터 : 스트림 정보(Connection)
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con; // 연결 정보 반환

	}

	// 카운트를 구하는 모든 작업을 수행할 메소드
	// 준비물 > X
	// 이름 > getCount
	// 반환형 > 카운트 값 (int)

	public int getCount() throws Exception {
		Connection con = this.getConnection();
		String sql = "SELECT COUNT(*) CNT FROM STUDENT";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("CNT");
		con.close();
		return count;
	}

	// 등록 메소드
	// 준비물 > 이름 , 점수
	// 이름 > regist
	// 반환형 > X(vodi)
	public void regist(String student_name, int student_score) throws Exception {
		Connection con = this.getConnection();

		String sql = "INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, ?, ? ,SYSDATE)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student_name);
		ps.setInt(2, student_score);
		ps.execute();

		con.close();

		System.out.println("데이터 저장에 성공했습니다.");
	}
}
