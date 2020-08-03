package com.d0.spring.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GalleryVO {
	private List<MultipartFile> f;
	
	public boolean isFileExcept() {
		if(this.f == null) return false;
		if(this.f.size() < 0) return false;
		if(this.f.isEmpty()) return false;
		
		return true;
	}
}
