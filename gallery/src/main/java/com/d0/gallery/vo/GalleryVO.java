package com.d0.gallery.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVO {

	private List<MultipartFile> f;

	public GalleryVO() {
		super();
	}

	public List<MultipartFile> getF() {
		return f;
	}

	public void setF(List<MultipartFile> f) {
		this.f = f;
	}

	public boolean isFileExist() {
		if(this.f == null) return false;
		if(this.f.size() < 0) return false;
		if(this.f.isEmpty()) return false;
		
		return true;
	}
}
