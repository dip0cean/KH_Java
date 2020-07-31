package com.d0.spring.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadVO {
	private String uploader;
	private List<MultipartFile> f;

	public UploadVO() {
		super();
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public List<MultipartFile> getF() {
		return f;
	}

	public void setF(List<MultipartFile> f) {
		this.f = f;
	}
	
	public boolean isFileExist() {
		// 파일이 없을 때
		if(f == null) {
			return false;
		}
		// 파일이 0 보다 클 때
		if(f.size() < 0) {
			return false;
		}
		// 파일이 비어있을 때
		if(f.get(0).isEmpty()) {
			return false;
		}
		
		return true;
	}

}
