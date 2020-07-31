package com.d0.spring.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GallaryVO {
	private long no;
	private String title;
	private String explain;
	private String fname;
	private long fsize;
	private String ftype;
	private String when;
	private List<MultipartFile> f;

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
