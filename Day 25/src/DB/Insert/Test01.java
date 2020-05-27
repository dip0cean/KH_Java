package DB.Insert;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DB.Beans.StudentDAO;

public class Test01 {

	public static void main(String[] args) throws Exception {
//		목표 : StudentDAO 를 이용하여 데이터를 DB(Student Table) 에 저장

		String student_name = "이소룡";
		int student_score = 95;

		StudentDAO sdao = new StudentDAO();
		Connection con = sdao.getConnection();

		String sql = "INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, ?, ? ,SYSDATE)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student_name);
		ps.setInt(2, student_score);
		ps.execute();

		con.close();

	}

}
