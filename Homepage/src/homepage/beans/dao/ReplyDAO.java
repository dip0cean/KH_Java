package homepage.beans.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	
	// 연결 정보 빌려쓰기
	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
}
