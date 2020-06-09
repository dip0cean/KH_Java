package homepage.beans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
