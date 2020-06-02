package DB.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		목표 > SELECT 명령을 실행하여 데이터베이스 STUDENT에저장된 내용을 불러와 출력
//		목적 > 데이터베이스에 있는 데이터를 꺼내 오는 것이 목적이다.

//		준비할 데이터 X
//		처리
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");
		String sql = "SELECT * FROM STUDENT ORDER BY STUDENT_NO";
		PreparedStatement ps = con.prepareStatement(sql);

//		ps.execute(); 실행구문 > 결과를 확인할 수 없으므로 잘못된 실행 방법이다.(insert 용)
		ResultSet rs = ps.executeQuery(); // 실행 후 결과 집합을 가져오는 실행 명령(select 용)

//		ResultSet은 데이터 베이스를 조회한 "결과집합(표)" 이다.
//		-	ResultSet은 데이터의 개수를 알 수 없다. (즉, ResultSet은 데이터 개수를 확인하는 명령이 없다.)
//		-	ResultSet 은 연결이 유지되는 동안만 사용이 가능하다.
//		[1]	rs.next() > 남은 데이터가 있는지 이동하여 확인하는 명령 (커서 이동)
//		[2] rs.getString(), rs.getInt() > 현재 위치의 데이터를 꺼내는 명령
//		[3] rs.next() 가 false 가 나오면 더 이상 읽을 데이터가 없다는 듯으로 반복을 중지한다.		
		while (rs.next()) {
			System.out.print(rs.getInt("student_no") + "\t"); // student_no번째 칸에 있는 데이터를 int 형태로 꺼내라
			System.out.print(rs.getString("student_name") + "\t"); // student_name번째 칸에 있는 데이터를 String 형태로 꺼내라
			System.out.print(rs.getInt("student_score") + "\t"); // student_score번째 칸에 있는 데이터를 int 형태로 꺼내라
			System.out.print(rs.getString("student_create")); // student_create번째 칸에 있는 데이터를 String 형태로 꺼내라 }
			System.out.println();
		}

		con.close();
		System.out.println("성공!");

	}

}
