package homepage.beans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import homepage.beans.dto.MemberJoinDTO;

public class MemberJoinDAO {

	private static DataSource src;

	static {

		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			src = (DataSource) env.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		return src.getConnection();
	}

	// 일반 조회
	public List<MemberJoinDTO> getList() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER_JOIN";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<MemberJoinDTO> list = new ArrayList<MemberJoinDTO>();

		while (rs.next()) {
			MemberJoinDTO mjdto = new MemberJoinDTO(rs);

			list.add(mjdto);
		}

		con.close();

		return list;
	}

	// 기간 조회
	public List<MemberJoinDTO> getTerm(String start, String end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM MEMBER_JOIN WHERE TO_DATE(JOIN, 'YYYY-MM-DD') BETWEEN TO_DATE(?,'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, start);
		ps.setString(2, end);

		ResultSet rs = ps.executeQuery();

		List<MemberJoinDTO> list = new ArrayList<MemberJoinDTO>();

		while (rs.next()) {
			MemberJoinDTO mjdto = new MemberJoinDTO(rs);
			
			list.add(mjdto);
		}
		
		con.close();
		
		return list;
	}
}
