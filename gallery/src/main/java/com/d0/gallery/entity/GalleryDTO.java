package com.d0.gallery.entity;

import org.springframework.web.multipart.MultipartFile;

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

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

}
