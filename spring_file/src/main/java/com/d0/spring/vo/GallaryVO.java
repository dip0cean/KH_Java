package com.d0.spring.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GallaryVO {
	private List<MultipartFile> f;

	public List<MultipartFile> getF() {
		return f;
	}

	public void setF(List<MultipartFile> f) {
		this.f = f;
	}

	public GallaryVO() {
		super();
	}

	public boolean isFileExist() {
		if (f == null)
			return false;

		if (f.size() < 0)
			return false;

		if (f.get(0).isEmpty())
			return false;

		return true;
	}

}
