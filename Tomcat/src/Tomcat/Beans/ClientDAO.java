package Tomcat.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClientDAO {

	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con;
	}

	public void regist(ClientDTO cdto) throws Exception {
		Connection con = getConnection();

		String sql = "INSERT INTO CLIENT VALUES(CLIENT_SEQ.NEXTVAL,?,?,'일반회원',SYSDATE,1000)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, cdto.getClient_id());
		ps.setString(2, cdto.getClient_pw());
		ps.execute();

		con.close();
	}
}
