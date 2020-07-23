package com.d0.spring_06.entity;

public class BoardDTO {
	private String nick;
	private String title;
	private String content;

	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
