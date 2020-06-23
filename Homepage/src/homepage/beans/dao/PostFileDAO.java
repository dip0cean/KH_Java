package homepage.beans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import homepage.beans.dto.PostFileDTO;

public class PostFileDAO {

	private static DataSource src;

	static {

		try {

			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			src = (DataSource) env.lookup("jdbc/oracle");

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	// [1] 드라이브 실행 및 호스트 연결
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}

	// [2] POST_FILE 테이블 기본키 번호 추출
	public long getSequence() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT POST_FILE_SEQ.NEXTVAL FROM DUAL";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		long result = rs.getLong(1);
		
		con.close();
		
		return result;
	}
	
	// [3] POST_FILE 테이블 데이터 저장
	public void save(PostFileDTO pfdto) throws Exception {
		Connection con = getConnection();
		
		String sql = "INSERT INTO POST_FILE VALUES(? , ? , ? , ? , ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setLong(1, pfdto.getPost_file_no());
		ps.setLong(2, pfdto.getPost_no());
		ps.setString(3, pfdto.getPost_file_name());
		ps.setString(4, pfdto.getPost_file_type());
		ps.setLong(5, pfdto.getPost_file_size());
		
		ps.execute();
		
		con.close();		
	}
}
