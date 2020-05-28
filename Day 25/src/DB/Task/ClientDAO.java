package DB.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
	// [1] 드라이버 실행 및 서버 연결
	public Connection getconConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con;
	}

	// [2] 데이터 추가
	public void regist(ClientDTO cdto) throws Exception {
		Connection con = this.getconConnection();
		String sql = "INSERT INTO CLIENT VALUES(CLIENT_SEQ.NEXTVAL,?,?,'일반회원',SYSDATE,1000)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getId());
		ps.setString(2, cdto.getPw());
		ps.execute();

		con.close();
		System.out.println("입력한 데이터를 성공적으로 저장하였습니다.");

	}

	// [3] 데이터 전체 조회
	public List<ClientDTO> getList() throws Exception {
		Connection con = this.getconConnection();

		String sql = "SELECT * FROM CLIENT ORDER BY CLIENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<ClientDTO> list = new ArrayList<ClientDTO>();

		while (rs.next()) {
			ClientDTO cdto = new ClientDTO();
			cdto.setNumber(rs.getInt("CLIENT_NO"));
			cdto.setId(rs.getString("CLIENT_ID"));
			cdto.setPw(rs.getString("CLIENT_PW"));
			cdto.setAuth(rs.getString("CLIENT_AUTH"));
			cdto.setJoin(rs.getString("CLIENT_JOIN"));
			cdto.setPoint(rs.getInt("CLIENT_POINT"));

			list.add(cdto);
		}
		con.close();

		return list;
	}

	// [4] 아이디 검색 조회
	public List<ClientDTO> getList(String id) throws Exception {
		Connection con = this.getconConnection();

		String sql = "SELECT * FROM CLIENT WHERE INSTR(CLIENT_ID, ?) > 0 ORDER BY CLIENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		List<ClientDTO> list = new ArrayList<ClientDTO>();

		while (rs.next()) {
			ClientDTO cdto = new ClientDTO();
			cdto.setNumber(rs.getInt("CLIENT_NO"));
			cdto.setId(rs.getString("CLIENT_ID"));
			cdto.setPw(rs.getString("CLIENT_PW"));
			cdto.setAuth(rs.getString("CLIENT_AUTH"));
			cdto.setJoin(rs.getString("CLIENT_JOIN"));
			cdto.setPoint(rs.getInt("CLIENT_POINT"));

			list.add(cdto);
		}
		con.close();

		return list;
	}

	// [5] 검색어 / 분류 조회
	public List<ClientDTO> getList(String keyword, String column) throws Exception {
		Connection con = this.getconConnection();
		String sql = "SELECT * FROM CLIENT WHERE INSTR(#1,?) > 0 ORDER BY #1 ASC";
		sql = sql.replace("#1", column);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);

		ResultSet rs = ps.executeQuery();

		List<ClientDTO> list = new ArrayList<ClientDTO>();

		while (rs.next()) {
			ClientDTO cdto = new ClientDTO();
			cdto.setNumber(rs.getInt("CLIENT_NO"));
			cdto.setId(rs.getString("CLIENT_ID"));
			cdto.setPw(rs.getString("CLIENT_PW"));
			cdto.setAuth(rs.getString("CLIENT_AUTH"));
			cdto.setJoin(rs.getString("CLIENT_JOIN"));
			cdto.setPoint(rs.getInt("CLIENT_POINT"));

			list.add(cdto);
		}
		con.close();
		return list;
	}

	// [6] 검색어 / 분류 / 시간 조회
	public List<ClientDTO> getList(String keyword, String column, int duration) throws Exception {
		Connection con = this.getconConnection();

		String sql = "SELECT * FROM CLIENT WHERE CLIENT_JOIN BETWEEN SYSDATE - ? AND SYSDATE AND INSTR(#1,?) > 0 ORDER BY #1 ASC";
		sql = sql.replace("#1", column);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, duration);
		ps.setString(2, keyword);
		ResultSet rs = ps.executeQuery();

		List<ClientDTO> list = new ArrayList<ClientDTO>();

		while (rs.next()) {
			ClientDTO cdto = new ClientDTO();
			cdto.setNumber(rs.getInt("CLIENT_NO"));
			cdto.setId(rs.getString("CLIENT_ID"));
			cdto.setPw(rs.getString("CLIENT_PW"));
			cdto.setAuth(rs.getString("CLIENT_AUTH"));
			cdto.setJoin(rs.getString("CLIENT_JOIN"));
			cdto.setPoint(rs.getInt("CLIENT_POINT"));

			list.add(cdto);
		}
		con.close();
		return list;
	}
}
