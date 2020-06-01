package Task;


public class Task03 {

	public static void main(String[] args) {

//		아무 글자나 하나 char 형태에 저장하고 문제를 푸세용
//		1) 저장한 값이 "한글이라면 true / 아니라면 false를 출력
//		2)	저장한 값이 "숫자" 라면 true / 아니라면 false를 출력

		char a = '가';

		boolean kor = ('ㄱ' <= a) && ('ㅣ' >= a) || ('가' <= a) && ('힣' >= a); // 한글이면 true / 아니면 false
		boolean num = 48 <= a && a <= 57; // 숫자면 true / 아니면 false

		System.out.println("char 타입 변수 a 는 한글인가 ? : " + kor);
		System.out.println("char 타입 변수 a 는 숫자인가 ? : " + num);

//		한글을 검사할 때 3가지 경우를 모두 고려해야 한다.
//		1) 'ㄱ' ~ 'ㅎ' -> 12593 ~ 12622
//		2) 'ㅏ' ~ 'ㅣ' ->12623 ~ 12643
//		3) '가' ~ '힣' -> 44032 ~ 55203
//		'ㄱ' 부터 'ㅣ' 까지는 연결되어 있기 때문에 같이 묶어 검사하면 되고, 
//		자음모음과 '가' 사이에는 다른 문자(한자 등)들이 들어가 있기 때문에 그 사이 또한 포함해서 검사하면 안된다.

	}

}
