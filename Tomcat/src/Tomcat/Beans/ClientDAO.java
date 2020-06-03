package Tomcat.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

	// [1] 드라이버 실행 및 호스트 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con;
	}

	// [2] 회원 가입
	public void regist(ClientDTO cdto) throws Exception {
		Connection con = getConnection();

		String sql = "INSERT INTO CLIENT VALUES(CLIENT_SEQ.NEXTVAL,?,?,'일반회원',SYSDATE,1000)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, cdto.getClient_id());
		ps.setString(2, cdto.getClient_pw());
		ps.execute();

		con.close();
	}

	// [3] 전체 리스트
	public List<ClientDTO> getList() throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM CLIENT ORDER BY CLIENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<ClientDTO> list = new ArrayList<ClientDTO>();
		while (rs.next()) {
			ClientDTO cdto = new ClientDTO();
			cdto.setClient_no(rs.getInt("CLIENT_NO"));
			cdto.setClient_id(rs.getString("CLIENT_ID"));
			cdto.setClient_auth(rs.getString("CLIENT_AUTH"));
			cdto.setClient_point(rs.getInt("CLIENT_POINT"));

			list.add(cdto);
		}

		con.close();

		return list;
	}

	// [4] 검색 리스트
	public List<ClientDTO> getSearch(String search) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM CLIENT WHERE INSTR(CLIENT_ID,?) > 0 OR INSTR(CLIENT_AUTH,?) > 0ORDER BY CLIENT_NO ASC";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, search);
		ps.setString(2, search);

		ResultSet rs = ps.executeQuery();

		List<ClientDTO> list = new ArrayList<ClientDTO>();

		while (rs.next()) {
			ClientDTO cdto = new ClientDTO();
			cdto.setClient_no(rs.getInt("CLIENT_NO"));
			cdto.setClient_id(rs.getString("CLIENT_ID"));
			cdto.setClient_pw(rs.getString("CLIENT_PW"));
			cdto.setClient_auth(rs.getString("CLIENT_AUTH"));
			cdto.setClient_join(rs.getString("CLIENT_JOIN"));
			cdto.setClient_point(rs.getInt("CLIENT_POINT"));

			list.add(cdto);
		}

		con.close();

		return list;

	}

	public ClientDTO get(int client_no) throws Exception {
		Connection con = getConnection();

		String sql = "SELECT * FROM CLIENT WHERE CLIENT_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, client_no);

		ResultSet rs = ps.executeQuery();

		ClientDTO cdto;
		if (rs.next()) {
			cdto = new ClientDTO();
			cdto.setClient_no(rs.getInt("CLIENT_NO"));
			cdto.setClient_id(rs.getString("CLIENT_ID"));
			cdto.setClient_pw(rs.getString("CLIENT_PW"));
			cdto.setClient_auth(rs.getString("CLIENT_AUTH"));
			cdto.setClient_join(rs.getString("CLIENT_JOIN"));
			cdto.setClient_point(rs.getInt("CLIENT_POINT"));
		} else {
			cdto = null;
		}

		con.close();

		return cdto;

	}
}
