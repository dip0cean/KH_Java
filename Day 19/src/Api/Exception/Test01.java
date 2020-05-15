package Api.Exception;

public class Test01 {
	public static void main(String[] args) {
//		예외 전가
		try {
			int v = Robot.div(10, 0);
			System.out.println(v);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
