package homepage.beans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

		sql = "SELECT ACCESS_LOGIN FROM MEMBER_ACCESS";

		ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();

		mdto.setAccess_login(rs.getString("ACCESS_LOGIN"));

		con.close();
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

	// [7] 회원 정보 수정
	public void edit(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "UPDATE MEMBER SET MEMBER_NICK = ? , MEMBER_POST = ? , MEMBER_BASE_ADDR = ? , MEMBER_EXTRA_ADDR = ? , MEMBER_PHONE = ? , MEMBER_INTRO = ? WHERE MEMBER_ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getMember_nick());
		ps.setString(2, mdto.getMember_post());
		ps.setString(3, mdto.getMember_base_addr());
		ps.setString(4, mdto.getMember_extra_addr());
		ps.setString(5, mdto.getMember_phone());
		ps.setString(6, mdto.getMember_intro());
		ps.setString(7, mdto.getMember_id());

		ps.execute();

		con.close();
	}

	// [8] 비밀번호 수정
	public void editPw(MemberDTO mdto) throws Exception {
		Connection con = getConnection();

		String sql = "UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, mdto.getMember_pw());
		ps.setString(2, mdto.getMember_id());

		ps.execute();

		con.close();

	}

	// [9] 회원 탈퇴
	public boolean exit(MemberDTO mdto, String exit_user) throws Exception {
		String user_answer = exit_user;
		String exit = "모든 정보를 삭제하겠습니다.";

		boolean result;

		if (exit.equals(user_answer)) {
			Connection con = getConnection();

			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mdto.getMember_id());

			ps.execute();

			sql = "DELETE FROM MEMBER_ACCESS WHERE MEMBER_ID = ? AND ACCESS_AUTH = ?";

			ps = con.prepareStatement(sql);

			ps.setString(1, mdto.getMember_id());
			ps.setString(2, mdto.getAccess_auth());

			ps.execute();

			con.close();

			result = true;

		} else {

			result = false;
		}

		return result;
	}

	// [10] 단일조회 메소드
	public MemberDTO get(String member_id) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, member_id);

		ResultSet rs = ps.executeQuery();

		MemberDTO mdto;

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

	// [11] 회원 검색
	public List<MemberDTO> search(String member_id) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER WHERE INSTR(MEMBER_ID, ?) > 0 ORDER BY MEMBER_ID ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, member_id);

		ResultSet rs = ps.executeQuery();

		List<MemberDTO> list = new ArrayList<MemberDTO>();

		while (rs.next()) {
			MemberDTO mdto = new MemberDTO(rs);
			
			String sql2 = "SELECT * FROM MEMBER_ACCESS WHERE MEMBER_ID = ?";

			PreparedStatement ps2 = con.prepareStatement(sql2);

			ps2.setString(1, mdto.getMember_id());

			ResultSet rs2 = ps2.executeQuery();
			
			rs2.next();
			
			mdto.setMember_Access(rs2);

			list.add(mdto);
		}

		con.close();

		return list;
	}
}
