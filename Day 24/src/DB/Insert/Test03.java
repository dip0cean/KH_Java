package DB.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		다음 테이블을 구성하시고 사용자에게 정보를 입력받아 데이터를 추가하는 구문을 구현하세요.
//		(단, 데이터는 동적으로 설정될 수 있도록 구현하세용.)
		Scanner sc = new Scanner(System.in);
		System.out.print("호텔명 > ");
		String hotelName = sc.nextLine();
		System.out.print("위치 > ");
		String hotelReg = sc.nextLine();
		System.out.print("점수 > ");
		double hotelRate = sc.nextDouble();
		sc.close();

		// 드라이버 실행
		Class.forName("oracle.jdbc.OracleDriver");

		// 서버 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		// SQL 명령문 입력
		String sql = "INSERT INTO HOTEL VALUES(HOTEL_SEQ.NEXTVAL, ?, ?, ?)";

		// SQL 명령문 전송 객체에 저장
		PreparedStatement ps = con.prepareStatement(sql);

		// 입력값 보안
		ps.setString(1, hotelName);
		ps.setString(2, hotelReg);
		ps.setDouble(3, hotelRate);

		// 전송
		ps.execute();

		// 서버 연결 해제
		con.close();
		System.out.println("입력 결과 전송 완료");
	}

}
