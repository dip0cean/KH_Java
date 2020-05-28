package DB.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
	// [1] 드라이버 실행 및 호스트 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con; // 연결 정보 반환

	}

	// [2] 총 학생수 조회
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

	// [3] 학생 및 점수 등록
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

	// [4] 학생 및 점수 변경
	public boolean edit(StudentDTO sdto) throws Exception {
		Connection con = this.getConnection();

		String sql = "UPDATE STUDENT SET STUDENT_NAME = ? ,STUDENT_SCORE= ? WHERE STUDENT_NO = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, sdto.getStudent_name());
		ps.setInt(2, sdto.getStudent_score());
		ps.setInt(3, sdto.getStudent_no());

		int count = ps.executeUpdate();

		con.close();
		
		boolean result;

		if (count == 1) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}
}
