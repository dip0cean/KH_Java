package DB.Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentTest_01 {

	public static void main(String[] args) throws Exception {
//		목표 > Student 테이블 데이터의 정보를 수정하는 것
//		-	이름과 점수를 수정할 수 있다. > 번호는 절대로 수정하면 안되는데 그 이유는 기본키이다.
//		-	특별한 경우가 아니라면 기본키를 이용하여 한개씩만 수정하는 것이 원칙이다.

//		준비 > 수정할 데이터 + 기본키		
		int student_no = 11;
		String student_name = "이슬이";
		int student_score = 76;

//		처리 > 직접 작성 / DAO + DTO 사용	
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		String sql = "UPDATE STUDENT SET STUDENT_NAME = ? ,STUDENT_SCORE= ? WHERE STUDENT_NO = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student_name);
		ps.setInt(2, student_score);
		ps.setInt(3, student_no);

//		실행 명령이 뭘까 ?
//		INSERT > 추가된 것만 확인하면 되므로 ps.execute()
//		SELECT > 결과 집합을 얻어내야 하므로 ps.executeQuery()
//		UPDATE / DELETE
//		-	변경 결과 개수를 알아내야 하므로 ps.executeUpdate()
//		-	결과 알아낼 필요가 없으면 ps.execute()

		int result = ps.executeUpdate();

		con.close();
		if (result == 0) {
			System.out.println("수정할 사항이 없습니다.");
		} else {
			System.out.println("수정되었습니다.");
		}
	}

}
