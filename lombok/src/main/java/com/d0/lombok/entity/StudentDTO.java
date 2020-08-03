package com.d0.lombok.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
	private String name;
	private int age;
	private int score;
	private String when;
	
}
