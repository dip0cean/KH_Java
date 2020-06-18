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

import homepage.beans.dto.ReplyDTO;

public class ReplyDAO {

	// [1] contex.xml 연결 정보 가져오기
	private static DataSource src;

	static {
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/emv");
			src = (DataSource) env.lookup("jdbc/oracle");
		} catch (NamingException e) {

			e.printStackTrace();
		}
	}

	// [2] 연결 정보 빌려쓰기
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}

	// [3] 댓글 번호 얻기
	public long getReply_no() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT REPLY_SEQ.NEXTVAL FROM DUAL";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();

		long reply_no = rs.getLong(1);

		con.close();

		return reply_no;
	}

	// [4] 댓글 작성
	public void createReply(ReplyDTO rdto) throws Exception {
		Connection con = getConnection();

		String sql = "INSERT INTO REPLY VALUES(?,?,?,?,SYSDATE)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, rdto.getReply_no());
		ps.setLong(2, rdto.getPost_no());
		ps.setString(3, rdto.getReply_id());
		ps.setString(4, rdto.getReply_content());

		ps.execute();

		con.close();
	}

	// [5] 해당 게시글 댓글 조회
	public List<ReplyDTO> postReply(long post_no) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM REPLY WHERE POST_NO = ? ORDER BY REPLY_DATE DESC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, post_no);

		ResultSet rs = ps.executeQuery();

		List<ReplyDTO> list = new ArrayList<ReplyDTO>();

		while (rs.next()) {
			ReplyDTO rdto = new ReplyDTO(rs);

			list.add(rdto);
		}

		con.close();

		return list;
	}

	// [6] 해당 회원 댓글 조회
	public List<ReplyDTO> userReply(String member_id) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM REPLY WHERE REPLY_ID = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, member_id);

		ResultSet rs = ps.executeQuery();

		List<ReplyDTO> list = new ArrayList<ReplyDTO>();

		while (rs.next()) {
			ReplyDTO rdto = new ReplyDTO(rs);
			
			list.add(rdto);
		}
		
		con.close();
		
		return list;
	}
}
