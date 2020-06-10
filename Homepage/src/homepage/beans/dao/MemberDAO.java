package homepage.beans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import homepage.beans.dto.MemberDTO;

public class MemberDAO {

	// [1] 드라이버 실행 및 호스트 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##KH", "C##KH");
	}

	// [2] 회원 가입
	public void join(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		// 회원가입 SQL문 전송
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?)";

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

		// 회원가입 시간 SQL문 전송
		sql = "INSERT INTO MEMBER_ACCESS(MEMBER_ID, ACCESS_AUTH) VALUES(?,'일반회원')";

		ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getMember_id());

		ps.execute();

		con.close();

	}

	// [3] 로그인
	public MemberDTO login(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, mdto.getMember_id());
		ps.setString(2, mdto.getMember_pw());

		ResultSet rs = ps.executeQuery();

		boolean result = rs.next();

		if (result) {

			mdto = new MemberDTO();
			mdto.setMember_id(rs.getString("MEMBER_ID"));
			mdto.setMember_pw(rs.getString("MEMBER_PW"));
			mdto.setMember_nick(rs.getString("MEMBER_NICK"));
			mdto.setMember_post(rs.getString("MEMBER_POST"));
			mdto.setMember_base_addr(rs.getString("MEMBER_BASE_ADDR"));
			mdto.setMember_extra_addr(rs.getString("MEMBER_EXTRA_ADDR"));
			mdto.setMember_birth(rs.getString("MEMBER_BIRTH"));
			mdto.setMember_phone(rs.getString("MEMBER_PHONE"));
			mdto.setMember_intro(rs.getString("MEMBER_INTRO"));

			sql = "SELECT * FROM MEMBER_ACCESS WHERE MEMBER_ID = ?";

			ps = con.prepareStatement(sql);

			ps.setString(1, mdto.getMember_id());

			rs = ps.executeQuery();
			rs.next();
			mdto.setAccess_auth(rs.getString("ACCESS_AUTH"));
			mdto.setAccess_join(rs.getString("ACCESS_JOIN"));
			mdto.setAccess_login(rs.getString("ACCESS_LOGIN"));

		} else if (!result) {

			mdto = null;
		}

		con.close();

		return mdto;

	}

	// [4] 접속 시간 갱신
	public void updateLoginTime(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "UPDATE MEMBER_ACCESS SET ACCESS_LOGIN = SYSDATE WHERE MEMBER_ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, mdto.getMember_id());

		ps.execute();
	}

	// [5] 아이디 찾기
	public MemberDTO findId(MemberDTO mdto) throws Exception {

		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER WHERE MEMBER_PHONE = ? AND MEMBER_BIRTH = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, mdto.getMember_phone());
		ps.setString(2, mdto.getMember_birth());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			mdto = new MemberDTO();
			mdto.setMember_id(rs.getString("MEMBER_ID"));
			mdto.setMember_pw(rs.getString("MEMBER_PW"));
			mdto.setMember_nick(rs.getString("MEMBER_NICK"));
			mdto.setMember_post(rs.getString("MEMBER_POST"));
			mdto.setMember_base_addr(rs.getString("MEMBER_BASE_ADDR"));
			mdto.setMember_extra_addr(rs.getString("MEMBER_EXTRA_ADDR"));
			mdto.setMember_birth(rs.getString("MEMBER_BIRTH"));
			mdto.setMember_phone(rs.getString("MEMBER_PHONE"));
			mdto.setMember_intro(rs.getString("MEMBER_INTRO"));

			sql = "SELECT * FROM MEMBER_ACCESS WHERE MEMBER_ID = ?";

			ps = con.prepareStatement(sql);

			ps.setString(1, mdto.getMember_id());

			rs = ps.executeQuery();
			
			rs.next();
			mdto.setAccess_auth(rs.getString("ACCESS_AUTH"));
			mdto.setAccess_join(rs.getString("ACCESS_JOIN"));
			mdto.setAccess_login(rs.getString("ACCESS_LOGIN"));

		} else {

			mdto = null;

		}
		con.close();

		return mdto;
	}

	// [6] 비밀번호 찾기
	public MemberDTO findPw(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PHONE = ? AND MEMBER_BIRTH = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, mdto.getMember_id());
		ps.setString(2, mdto.getMember_phone());
		ps.setString(3, mdto.getMember_birth());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			mdto = new MemberDTO();
			mdto.setMember_id(rs.getString("MEMBER_ID"));
			mdto.setMember_pw(rs.getString("MEMBER_PW"));
			mdto.setMember_nick(rs.getString("MEMBER_NICK"));
			mdto.setMember_post(rs.getString("MEMBER_POST"));
			mdto.setMember_base_addr(rs.getString("MEMBER_BASE_ADDR"));
			mdto.setMember_extra_addr(rs.getString("MEMBER_EXTRA_ADDR"));
			mdto.setMember_birth(rs.getString("MEMBER_BIRTH"));
			mdto.setMember_phone(rs.getString("MEMBER_PHONE"));
			mdto.setMember_intro(rs.getString("MEMBER_INTRO"));

			sql = "SELECT * FROM MEMBER_ACCESS WHERE MEMBER_ID = ?";

			ps = con.prepareStatement(sql);

			ps.setString(1, mdto.getMember_id());

			rs = ps.executeQuery();
			
			rs.next();
			mdto.setAccess_auth(rs.getString("ACCESS_AUTH"));
			mdto.setAccess_join(rs.getString("ACCESS_JOIN"));
			mdto.setAccess_login(rs.getString("ACCESS_LOGIN"));

		} else {
			mdto = null;
		}

		con.close();

		return mdto;
	}
}
