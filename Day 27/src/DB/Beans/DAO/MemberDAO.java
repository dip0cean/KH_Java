package DB.Beans.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.Beans.DTO.MemberDTO;

public class MemberDAO {

	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##KH", "C##KH");

		return con;
	}

	// 회원가입
	public void regist(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "INSERT INTO MEMBER_2 VALUES(?,?,?,?,?,?,?,?,?,'일반회원',SYSDATE,NULL)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, mdto.getMember_id());
		ps.setString(2, mdto.getMember_pw());
		ps.setString(3, mdto.getMember_nick());
		ps.setString(4, mdto.getMember_post());
		ps.setString(5, mdto.getMember_base_addr());
		ps.setString(6, mdto.getMember_extra_addr());
		ps.setString(7, mdto.getMember_birth());
		ps.setString(8, mdto.getMember_phone());
		ps.setString(9, mdto.getMember_intro());
		ps.execute();

		con.close();
		System.out.println("회원가입 완료!");
	}

	// 로그인 1 > 카운트 조회
	public boolean login(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT COUNT(*) FROM MEMBER_2 WHERE MEMBER_ID = ? AND MEMBER_PW = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getMember_id());
		ps.setString(2, mdto.getMember_pw());
		ResultSet rs = ps.executeQuery();

		rs.next();
		int result = rs.getInt(1);

		con.close();

		return result == 1;

	}

	// 로그인 2 > 데이터 여부 조회
	public boolean login2(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER_2 WHERE MEMBER_ID = ? AND MEMBER_PW = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getMember_id());
		ps.setString(2, mdto.getMember_pw());
		ResultSet rs = ps.executeQuery();

		boolean result = rs.next();

		con.close();

		return result;
	}

	// 아이디 찾기
	public String findId(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT MEMBER_ID FROM MEMBER_2 WHERE MEMBER_NICK = ? AND MEMBER_PHONE = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getMember_nick());
		ps.setString(2, mdto.getMember_phone());

		ResultSet rs = ps.executeQuery();
		boolean result = rs.next();

		String id;

		if (result == true) {
			id = rs.getString(1);
		} else {
			id = null;
		}

		con.close();

		return id;
	}
}
