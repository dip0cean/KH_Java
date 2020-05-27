package DB.Beans;

public class Test02 {

	public static void main(String[] args) throws Exception {
//		목표 : 연결을 StudentDAO 를 이용하여 진행 (궁극적으로 모든 DB작업을 StudentDAO 를 이용하여 처리)

		StudentDAO sdao = new StudentDAO();
		int count = sdao.getCount();

		System.out.println(count);
	}

}
