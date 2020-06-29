package homepage.beans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import homepage.beans.dto.PostDTO;

public class PostDAO {

	// context.xml에서 관리하는 자원 객체를 참조할 수 있도록 연결 코드 구현
	private static DataSource src; // 리모컨 선언

	// static 변수의 초기화가 복잡할 경우에 사용할 수 있는 static 전용 구문
	static {
		// src= context.xml 에서 관리하는 자원의 정보

		try {

			Context ctx = new InitialContext(); // 탐색 도구
			Context env = (Context) ctx.lookup("java:/comp/env"); // Object 를 Context 로 다운 캐스팅
			src = (DataSource) env.lookup("jdbc/oracle");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// [1] 드라이버 실행 및 드라이버 연결
	public Connection getConnection() throws Exception {
//		Class.forName("oracle.jdbc.OracleDriver");
//
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##KH", "C##KH");
//
//		return con;

		return src.getConnection();
	}

	// [2] 전체 게시글 조회
	public List<PostDTO> fullPost(long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, start);
		ps.setLong(2, end);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);
			list.add(pdto);
		}

		con.close();

		return list;
	}

	// - 번호가 이미 생성되어서 pdto 에 들어있으므로 시퀀스 사용 금지!
	// - pdto.getSuper_no() == 0
	// - pdto.getSuper_no() > 0
	// - pdto 에 들어갈 데이터(상위글 번호, 그룹번호, 차수정보) 를 계산하여 등록!

	// - 새글 등록 기준
	// - 상위글 번호 : 0
	// - 그룹번호 : 원본글과 동일
	// - 차수 : 0
	// - 답글 등록 기준
	// - 상위글 번호 : 원본글 번호
	// - 그룹번호 " 원본글 그룹 번호
	// - 차수 : 원본글 차수 + 1

	// [3] 게시글 작성
	public void creatPost(PostDTO pdto) throws Exception {
		if (pdto.getSuper_no() == 0) {
			// 새글일 경우
			// pdto 에는 5개의 정보가 들어있다. (번호 / 말머리 / 제목/ 작성자 / 내용)
			// 추가로 그룹번호 설정 (나머지 값 == 0)
			pdto.setGroup_no(pdto.getPost_no());

		} else {
			// 답글일 경우
			// pdto 에는 6개의 정보가 들어있다. (번호 / 말머리 / 제목/ 작성자 / 내용 / 상위글번호)
			// 추가로 그룹번호와 차수를 설정해주어야 한다.
			// 원본글의 정보가 필요하므로 불러온다.
			PostDTO upPost = this.getPost(pdto.getSuper_no());
			// 원본글 그룹 번호 가지고 오기
			pdto.setGroup_no(upPost.getGroup_no());
			pdto.setDepth(upPost.getDepth() + 1);
		}
		Connection con = getConnection();

		String sql = "INSERT INTO POST VALUES(? , ? , ? , ? , ? , SYSDATE , 0 , ? , ? , ?)";

		PreparedStatement ps = con.prepareStatement(sql); 

		ps.setLong(1, pdto.getPost_no());
		ps.setString(2, pdto.getPost_id());
		ps.setString(3, pdto.getPost_sub());
		ps.setString(4, pdto.getPost_title());
		ps.setString(5, pdto.getPost_content());
		if (pdto.getSuper_no() == 0) {

			ps.setNull(6, Types.INTEGER);

		} else {

			ps.setLong(6, pdto.getSuper_no());

		}
		ps.setLong(7, pdto.getGroup_no());
		ps.setLong(8, pdto.getDepth());

		ps.execute();

		con.close();
	}

	// [4-1] 아이디, 말머리와 제목으로 게시글 조회
	public List<PostDTO> searchMyPost(PostDTO pdto, long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST WHERE POST_ID = ? AND INSTR(POST_TITLE, ? ) > 0 AND POST_SUB = ? CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, pdto.getPost_id());
		ps.setString(2, pdto.getPost_title());
		ps.setString(3, pdto.getPost_sub());
		ps.setLong(4, start);
		ps.setLong(5, end);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}
	
	// [4-2] 말머리와 제목으로 게시글 조회
	public List<PostDTO> searchPost(PostDTO pdto, long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST WHERE INSTR(POST_TITLE, ? ) > 0 AND POST_SUB = ? CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, pdto.getPost_title());
		ps.setString(2, pdto.getPost_sub());
		ps.setLong(3, start);
		ps.setLong(4, end);

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
	public void getHits(long post_no, String member_id) throws Exception {

		Connection con = getConnection();

		String sql = "UPDATE POST SET POST_HITS = POST_HITS + 1 WHERE POST_NO = ? AND POST_ID != ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, post_no);
		ps.setString(2, member_id);

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
	public List<PostDTO> userPost(String post_id, long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST WHERE POST_ID = ? CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_id);
		ps.setLong(2, start);
		ps.setLong(3, end);

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
	public List<PostDTO> boardPost(String post_sub, long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST WHERE POST_SUB = ? CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_sub);
		ps.setLong(2, start);
		ps.setLong(3, end);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [10] 닉네임 검색으로 게시물 조회
	public List<PostDTO> searchNickpost(String member_nick, long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST WHERE INSTR(POST_ID,(SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = ? )) > 0 CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, member_nick);
		ps.setLong(2, start);
		ps.setLong(3, end);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [11] 말머리와 닉네임으로 게시글 찾기
	public List<PostDTO> searchNickpost(String go, String member_nick, long start, long end) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM (SELECT ROWNUM RN, T.* FROM (SELECT * FROM POST WHERE POST_SUB = ? AND INSTR(POST_ID,(SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = ? )) > 0 CONNECT BY PRIOR POST_NO=SUPER_NO START WITH SUPER_NO IS NULL ORDER SIBLINGS BY GROUP_NO DESC, POST_NO ASC) T ) WHERE RN BETWEEN ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, go);
		ps.setString(2, member_nick);
		ps.setLong(3, start);
		ps.setLong(4, end);

		ResultSet rs = ps.executeQuery();

		List<PostDTO> list = new ArrayList<PostDTO>();

		while (rs.next()) {
			PostDTO pdto = new PostDTO(rs);

			list.add(pdto);
		}

		con.close();

		return list;
	}

	// [12] 게시글 삭제
	public void deletePost(long post_no) throws Exception {
		Connection con = getConnection();

		String sql = "DELETE FROM POST WHERE POST_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setLong(1, post_no);

		ps.execute();

		con.close();
	}

	// [13] 게시글 번호 찾기
	public long getSequence() throws Exception {
		Connection con = getConnection();

		// dual 테이블은 오라클이 제공하는 임시 테이블
		String sql = "SELECT POST_SEQ.NEXTVAL FROM DUAL";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();

		long getSequence = rs.getLong(1);

		con.close();

		return getSequence;
	}

	// [14-1] 게시글 개수 조회
	public long getPostCount() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT COUNT(*) FROM POST";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();

		long result = rs.getLong(1);

		con.close();

		return result;
	}

	// [14-2] 말머리와 제목으로 게시물 개수 조회
	public long getPostCount(String post_sub, String post_title) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT COUNT(*) FROM POST WHERE POST_SUB = ? AND INSTR(POST_TITLE,?) > 0";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_sub);
		ps.setString(2, post_title);

		ResultSet rs = ps.executeQuery();

		rs.next();

		long result = rs.getLong(1);

		con.close();

		return result;
	}

	// [14-3] 게시판 별 게시물 개수 조회
	public long getPostCount(String post_sub) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT COUNT(*) FROM POST WHERE POST_SUB = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, post_sub);

		ResultSet rs = ps.executeQuery();

		rs.next();

		long result = rs.getLong(1);

		con.close();

		return result;
	}

	// [14-4] 작성자 닉네임으로 게시물 개수 조회
	public long getNickPostCount(String post_title) throws Exception {
		Connection con = getConnection();
		
		String sql = "SELECT COUNT(*) FROM POST WHERE POST_ID = (SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, post_title);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		long result = rs.getLong(1);
		
		con.close();
		
		return result;
	}
}
