package homepage.beans.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyDTO {
	private long reply_no;
	private long post_no;
	private String reply_id;
	private String reply_content;
	private String reply_date;

	public long getReply_no() {
		return reply_no;
	}

	public void setReply_no(long reply_no) {
		this.reply_no = reply_no;
	}

	public long getPost_no() {
		return post_no;
	}

	public void setPost_no(long post_no) {
		this.post_no = post_no;
	}

	public String getReply_id() {
		return reply_id;
	}

	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_date() {
		return reply_date;
	}

	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}

	public ReplyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReplyDTO(ResultSet rs) throws SQLException {
		this.setReply_no(rs.getLong("reply_no"));
		this.setPost_no(rs.getLong("Post_no"));
		this.setReply_id(rs.getString("reply_id"));
		this.setReply_content(rs.getString("reply_content"));
		this.setReply_date(rs.getString("reply_date"));
	}

}
