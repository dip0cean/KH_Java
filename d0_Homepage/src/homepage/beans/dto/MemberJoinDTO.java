package homepage.beans.dto;

import java.sql.ResultSet;

public class MemberJoinDTO {
	private String join;
	private long count;

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public MemberJoinDTO() {
		super();
	}
	
	public MemberJoinDTO(ResultSet rs) throws Exception {
		this.setJoin(rs.getString("join"));
		this.setCount(rs.getLong("count"));
	}

}
