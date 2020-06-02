package Tomcat.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	// [1] 드라이버 실행 및 호스트 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con;
	}

	// [2] 학생 등록 메소드
	public void regist(StudentDTO sdto) throws Exception {
		Connection con = getConnection();

		String sql = "INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL,?,?,SYSDATE)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, sdto.getStudent_name());
		ps.setInt(2, sdto.getStudent_score());
		ps.execute();

		con.close();
	}

	// [3] 학생 리스트 메소드
	public List<StudentDTO> getList() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM STUDENT ORDER BY STUDENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<StudentDTO> list = new ArrayList<StudentDTO>();

		while (rs.next()) {
			StudentDTO sdto = new StudentDTO();
			sdto.setStudent_no(rs.getInt("STUDENT_NO"));
			sdto.setStudent_name(rs.getString("STUDENT_NAME"));
			sdto.setStudent_score(rs.getInt("STUDENT_SCORE"));
			sdto.setStudent_create(rs.getString("STUDENT_CREATE"));

			list.add(sdto);
		}

		con.close();

		return list;
	}

	// [4] 학생 검색 메소드
	public List<StudentDTO> getSearch(StudentDTO sdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM STUDENT WHERE INSTR(STUDENT_NAME, ?) > 0 ORDER BY STUDENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, sdto.getStudent_name());

		ResultSet rs = ps.executeQuery();

		List<StudentDTO> list = new ArrayList<StudentDTO>();

		while (rs.next()) {
			sdto = new StudentDTO();
			sdto.setStudent_no(rs.getInt("STUDENT_NO"));
			sdto.setStudent_name(rs.getString("STUDENT_NAME"));
			sdto.setStudent_score(rs.getInt("STUDENT_SCORE"));
			sdto.setStudent_create(rs.getString("STUDENT_CREATE"));

			list.add(sdto);
		}

		con.close();

		return list;

	}

	// [5] 특정 이상 점수 조회
	public List<StudentDTO> getScore(StudentDTO sdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM STUDENT WHERE STUDENT_SCORE >= ? ORDER BY STUDENT_SCORE ASC";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, sdto.getStudent_score());

		ResultSet rs = ps.executeQuery();

		List<StudentDTO> list = new ArrayList<StudentDTO>();

		while (rs.next()) {
			sdto = new StudentDTO();
			sdto.setStudent_no(rs.getInt("STUDENT_NO"));
			sdto.setStudent_name(rs.getString("STUDENT_NAME"));
			sdto.setStudent_score(rs.getInt("STUDENT_SCORE"));
			sdto.setStudent_create(rs.getString("STUDENT_CREATE"));

			list.add(sdto);
		}

		con.close();

		return list;
	}
}
