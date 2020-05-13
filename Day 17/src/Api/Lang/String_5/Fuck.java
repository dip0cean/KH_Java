package Api.Lang.String_5;

public class Fuck {
	public static String filter(String a) {
//		욕설 대체 문자
		String star = "*";
//		욕설 리스트 배열		
		String[] data = new String[] { "신발끈", "개나리", "수박씨", "호루라기 ", "시베리아 ", " 십장생 ", " 조카", "주옥", "쌍쌍바", "씨발" };

		// 매개 변수 a 와 욕설 배열 비교
		for (int i = 0; i < data.length; i++) {

			if (data[i].length() == 2) {
				star = "**";
			} else if (data[i].length() == 3) {
				star = "***";
			} else if (data[i].length() == 4) {
				star = "****";
			}
			if (a.contains(data[i]) == true) {
				a = a.replace(data[i], star);
			}
		}
		return a;
	}
}
