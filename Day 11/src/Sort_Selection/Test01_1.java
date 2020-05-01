package Sort_Selection;

public class Test01_1 {

	public static void main(String[] args) {
//		배열의 정렬 > sort
//			- 데이터를 원하는 순서대로 변경하는 것
//			- 원하는 방식에 따라 오름차순(ascending) / 내림차순(descending) 으로 구분
//			- 여러가지 방식이 존재하고 있으며, 정렬에 대한 이해는 청소와 비슷하다고 생각하면 편함

		int[] data = new int[] { 3, 5, 2, 1, 4 };
		int length = data.length - 1;

//		selection - sort 방식으로 data 오름차순 정렬
//		-> 가장 작은 데이터를 찾아서 앞으로 옮긴다. -> (data.length-1) 번 반복
		
//		범위를 파악하고 반복문 구현		
		for(int i = 0; i < length; i++) {
			System.out.println(i + "  번 부터 " +  length + " 번까지 찾아요");
			
		}
		
	}

}
