package Api.Lang.String;

public class Test01 {
	public static void main(String[] args) {
//		문자열 편집 2탄

//		-	문자열 자르기 : .subString()		
		String time = "2020-05-14 09:49:32.0";
		System.out.println(time);
		System.out.println(time.substring(0, 10)); // 문자열의 어느 구간(매개 변수 값들의 사이)을 출력
		System.out.println(time.substring(11)); // 매개변수 값부터 출력 문자열의 끝까지

//		-	분해 : .split()
		String colors = "빨 / 주 / 노 / 초 / 파 / 남 / 보";
		String[] data = colors.split(" / ");
		for (int i = 0; i < data.length; i++) {
			System.out.println("색상 : " + data[i]);
		}
		System.out.println("색상의 개수 : " + data.length);
	}
}
