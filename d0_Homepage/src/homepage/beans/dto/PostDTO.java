package homepage.beans.dto;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostDTO {

	private long post_no;
	private String post_id;
	private String post_sub;
	private String post_title;
	private String post_content;
	private String post_date;
	private long post_hits;
	private long super_no;
	private long group_no;
	private long depth;

	public long getSuper_no() {
		return super_no;
	}

	public void setSuper_no(long super_no) {
		this.super_no = super_no;
	}

	public long getGroup_no() {
		return group_no;
	}

	public void setGroup_no(long group_no) {
		this.group_no = group_no;
	}

	public long getDepth() {
		return depth;
	}

	public void setDepth(long depth) {
		this.depth = depth;
	}

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

	public String getPost_date2() {
		return post_date.substring(0, 10);
	}

	public String getPost_time() {
		return post_date.substring(11, 16);
	}

	public String getPost_autotime() {

		// Date d = new Date();
		// SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		// String today = f.format(d);

		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		if (getPost_date2().equals(today)) {

			return getPost_time();

		} else {

			return getPost_date2();

		}

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
		this.setSuper_no(rs.getLong("super_no"));
		this.setGroup_no(rs.getLong("group_no"));
		this.setDepth(rs.getLong("depth"));
	}

}
