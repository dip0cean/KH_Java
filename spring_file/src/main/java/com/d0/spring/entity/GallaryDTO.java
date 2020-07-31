package com.d0.spring.entity;

import com.d0.spring.vo.GallaryVO;

public class GallaryDTO {
	private long no;
	private String title;
	private String explain;
	private String fname;
	private long fsize;
	private String ftype;
	private String when;

	public GallaryDTO(GallaryVO gallaryVO) {
		this.setNo(gallaryVO.getNo());
		this.setTitle(gallaryVO.getTitle());
		this.setExplain(gallaryVO.getExplain());
		this.setFname(gallaryVO.getFname());
		this.setFsize(gallaryVO.getFsize());
		this.setFtype(gallaryVO.getFtype());
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

	public GallaryDTO() {
		super();
	}

}
