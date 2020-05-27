package DB.Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	// [1] 드라이버 실행 및 연결
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDY", "STUDY");

		return con;
	}

	// [2] 등록 기능
	public void regist(ProductDTO pdto) throws Exception {
		Connection con = this.getConnection();

		String sql = "INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, ?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pdto.getName());
		ps.setString(2, pdto.getType());
		ps.setInt(3, pdto.getPrice());
		ps.setString(4, pdto.getMade());
		ps.setString(5, pdto.getExpire());
		ps.execute();

		con.close();

		System.out.println("데이터를 저장하였습니다.");
	}

	// [3] 총 물건 개수 기능
	public int getCount() throws Exception {
		Connection con = this.getConnection();

		String sql = "SELECT COUNT(*) FROM PRODUCT";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		rs.next();

		int count = rs.getInt(1);

		con.close();

		return count;
	}

	// [4] 상품 목록 조회 기능
	// 준비물 > X
	// 이름 > getList
	// 결과 > 상품 목록
	// rs 는 con.close() 까지만 사용 가능하며 연결은 가급적 빨리 종료하는 것이 좋다. (성능상)
	// - rs에 있는 데이터를 제 3의 저장소를 만들어서 복제하고 연결을 종료한 뒤 복제된 저장소를 반환
	// - 복제할 데이터 저장소는 어떻게 설계할 것인가?
	// - 데이터 개수를 알 수 없다. (배열 안됨)
	// - 순서가 중요한가 ? 예
	// - List 안에는 뭐가 있는가 > ProductDTO
	public List<ProductDTO>

			getList() throws Exception {

		Connection con = this.getConnection();

		String sql = "SELECT * FROM PRODUCT ORDER BY NO";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<ProductDTO> list = new ArrayList<ProductDTO>();

		while (rs.next()) {

			ProductDTO pdto = new ProductDTO(); // 데이터 1개를 복사할 객체를 생성

			pdto.setNo(rs.getInt("no"));
			pdto.setName(rs.getString("name"));
			pdto.setType(rs.getString("type"));
			pdto.setPrice(rs.getInt("price"));
			pdto.setMade(rs.getString("made"));
			pdto.setExpire(rs.getString("expire"));

			list.add(pdto); // 준비된 저장소에 옮겨담은 데이터 객체를 추가한다.

		}

		con.close();

		// 연결이 종료된 후 복제한 저장소를 반환
		return list;

	}
}
