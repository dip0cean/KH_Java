package DB.Beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {

	public static void main(String[] args) throws Exception {
//		목표 : 연결을 StudentDAO 를 이용하여 진행 (궁극적으로 모든 DB작업을 StudentDAO 를 이용하여 처리)

		StudentDAO sdao = new StudentDAO();
		Connection con = sdao.getConnection();

		String sql = "SELECT COUNT(*) CNT FROM STUDENT";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("CNT");

		con.close();
		System.out.println(count);
		System.out.println("성공!");
	}

}
