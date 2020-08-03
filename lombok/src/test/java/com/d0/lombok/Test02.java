package com.d0.lombok;

import org.junit.Test;

import com.d0.lombok.entity.StudentDTO;

public class Test02 {
	
	@Test
	public void test() {
		
		// Bulider
		StudentDTO sdto = StudentDTO.builder().name("김철수").age(52).score(30).when("2020-01-01 12:00:00").build();
		
		// Getter
		System.out.println("getter > 이름 : " + sdto.getName());
		System.out.println("getter > 나이 : " + sdto.getAge());
		System.out.println("getter > 점수 : " + sdto.getScore());
		System.out.println("getter > 날짜 : " + sdto.getWhen());
		
		// AllArgsConstructor
		StudentDTO sdto2 = new StudentDTO("김퍼피", 44, 30, "2020-01-01 12:00:00");
		
		// Setter
		sdto2.setName("심또익");
		
		// ToString
		System.out.println(sdto2);
	}

}
