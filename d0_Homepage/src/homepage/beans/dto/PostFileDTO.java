package homepage.beans.dto;

import java.sql.ResultSet;

public class PostFileDTO {
	private long post_file_no;
	private long post_no;
	private String post_file_name;
	private String post_file_type;
	private long post_file_size;

	public PostFileDTO() {
		super();

	}

	public PostFileDTO(ResultSet rs) throws Exception {
		this.setPost_file_no(rs.getLong("post_file_no"));
		this.setPost_no(rs.getLong("post_no"));
		this.setPost_file_name(rs.getString("post_file_name"));
		this.setPost_file_type(rs.getString("post_file_type"));
		this.setPost_file_size(rs.getLong("post_file_size"));
	}

	public long getPost_file_no() {
		return post_file_no;
	}

	public void setPost_file_no(long post_file_no) {
		this.post_file_no = post_file_no;
	}

	public long getPost_no() {
		return post_no;
	}

	public void setPost_no(long post_no) {
		this.post_no = post_no;
	}

	public String getPost_file_name() {
		return post_file_name;
	}

	public void setPost_file_name(String post_file_name) {
		this.post_file_name = post_file_name;
	}

	public long getPost_file_size() {
		return post_file_size;
	}

	public void setPost_file_size(long post_file_size) {
		this.post_file_size = post_file_size;
	}

	public String getPost_file_type() {
		return post_file_type;
	}

	public void setPost_file_type(String post_file_type) {
		this.post_file_type = post_file_type;
	}

}
