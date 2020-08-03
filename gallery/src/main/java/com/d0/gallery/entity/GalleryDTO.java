package com.d0.gallery.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GalleryDTO {
	private long no;
	private String title;
	private String explain;
	private String fname;
	private long fsize;
	private String ftype;
	private String when;

	public GalleryDTO() {
		super();
	}
	
	public void setting(MultipartFile file) {
		this.setFname(file.getOriginalFilename());
		this.setFsize(file.getSize());
		this.setFtype(file.getContentType());
	}


}
