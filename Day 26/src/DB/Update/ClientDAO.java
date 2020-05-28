package DB.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClientDAO {

	// [1] 드라이버 실행 및 호스트 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con;
	}

	// [2] 비밀번호 변경
	public void editPw(ClientDTO cdto) throws Exception {
		Connection con = getConnection();

		String sql = "UPDATE CLIENT SET CLIENT_PW = ? WHERE CLIENT_NO = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getClient_pw());
		ps.setInt(2, cdto.getClient_no());
		
		//ps.executeUpdate() > 결과가 궁금하지 않다면 실행하지 않아도 된다.
		ps.execute();

		con.close();

	}
}
