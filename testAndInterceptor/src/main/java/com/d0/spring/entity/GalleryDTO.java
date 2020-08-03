package com.d0.spring.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GalleryDTO {
	private long no;
	private String title;
	private String explain;
	private String fname;
	private long fsize;
	private String ftype;
	private String when;

	public void setting(MultipartFile file) {
		this.setFname(file.getOriginalFilename());
		this.setFtype(file.getContentType());
		this.setFsize(file.getSize());
	}
}
