package com.d0.lombok.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@ToString  (exclude = "a")  // ToString + exclude > 제외
 * @Setter @Getter // Setter + Getter
 */
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 데이터를 받는 생성자
@Builder // 객체를 생성해주는 빌더 패턴 적용

@Data // (@Setter / @Getter / @ToString / @Equiers)
public class MenuDTO {

	private String a;
	private String b;

}
