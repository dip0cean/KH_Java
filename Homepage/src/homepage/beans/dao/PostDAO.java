package homepage.beans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import homepage.beans.dto.PostDTO;

public class PostDAO {

	// [1] 드라이버 실행 및 드라이버 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##KH", "C##KH");

		return con;
	}

	// [2] 전체 게시글 조회
	public List<PostDTO> fullPost() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM POST ORDER BY POST_DATE DESC";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);
			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [3] 게시글 작성
	public void creatPost(PostDTO pdto) throws Exception {
		Connection con = getConnection();

		String sql = "INSERT INTO POST VALUES(? , ? , ? , ? , ? , SYSDATE , 0)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, pdto.getPost_no());
		ps.setString(2, pdto.getPost_id());
		ps.setString(3, pdto.getPost_sub());
		ps.setString(4, pdto.getPost_title());
		ps.setString(5, pdto.getPost_content());

		ps.execute();

		con.close();
	}

	// [4] 전체 게시판에서 제목으로 게시글 조회
	public List<PostDTO> searchPost(PostDTO pdto) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM POST WHERE INSTR(POST_TITLE, ? ) > 0 AND POST_SUB = ? ORDER BY POST_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, pdto.getPost_title());
		ps.setString(2, pdto.getPost_sub());

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [5] 단일 조회
	public PostDTO getPost(long post_no) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM POST WHERE POST_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, post_no);

		ResultSet rs = ps.executeQuery();

		// 3항 연산자
		PostDTO pdto = rs.next() ? new PostDTO(rs) : null;

		con.close();

		return pdto;

	}

	// [6] 조회수
	public void getHits(long post_no) throws Exception {

		Connection con = getConnection();

		String sql = "UPDATE POST SET POST_HITS = POST_HITS + 1 WHERE POST_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, post_no);

		ps.execute();

		con.close();
	}

	// [7] 게시글 수정
	public long editPost(PostDTO pdto) throws Exception {
		Connection con = getConnection();

		String sql = "UPDATE POST SET POST_SUB = ? , POST_TITLE = ? , POST_CONTENT = ? WHERE POST_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, pdto.getPost_sub());
		ps.setString(2, pdto.getPost_title());
		ps.setString(3, pdto.getPost_content());
		ps.setLong(4, pdto.getPost_no());

		ps.execute();

		con.close();

		return pdto.getPost_no();
	}

	// [8] 작성자 게시물 검색
	public List<PostDTO> userPost(String post_id) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM POST WHERE POST_ID = ? ORDER BY POST_DATE DESC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_id);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [9] 게시판 별 게시글 리스트
	public List<PostDTO> boardPost(String post_sub) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM POST WHERE POST_SUB = ? ORDER BY POST_DATE DESC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_sub);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [10] 게시글 삭제
	public void deletePost(long post_no) throws Exception {
		Connection con = getConnection();

		String sql = "DELETE FROM POST WHERE POST_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, post_no);

		ps.execute();

		con.close();
	}

	// [11] 아이디 검색으로 게시물 조회
	public List<PostDTO> searchId_post(String post_id) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM POST WHERE INSTR(POST_ID,?) > 0 ORDER BY POST_ID ASC , POST_NO DESC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_id);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [12] 게시글 번호 찾기
	public long getSequence() throws Exception {
		Connection con = getConnection();
		
		// dual 테이블은 오라클이 제공하는 임시 테이블
		String sql = "SELECT POST_NO_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		long getSequence = rs.getLong(1);
		
		con.close();
		
		return getSequence;
	}
}
