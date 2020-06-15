package homepage.beans.dto;

import java.sql.ResultSet;

public class PostDTO {

	private long post_no;
	private String post_id;
	private String post_sub;
	private String post_title;
	private String post_content;
	private String post_date;
	private long post_hits;

	public PostDTO() {
		super();
	}

	public long getPost_no() {
		return post_no;
	}

	public void setPost_no(long post_no) {
		this.post_no = post_no;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getPost_sub() {
		return post_sub;
	}

	public void setPost_sub(String post_sub) {
		this.post_sub = post_sub;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public long getPost_hits() {
		return post_hits;
	}

	public void setPost_hits(long post_hits) {
		this.post_hits = post_hits;
	}
	
	public PostDTO(ResultSet rs) throws Exception {
		this.setPost_no(rs.getLong("post_no"));
		this.setPost_id(rs.getString("post_id"));
		this.setPost_sub(rs.getString("post_sub"));
		this.setPost_title(rs.getString("post_title"));
		this.setPost_content(rs.getString("post_content"));
		this.setPost_date(rs.getString("post_date"));
		this.setPost_hits(rs.getLong("post_hits"));
	}

}
