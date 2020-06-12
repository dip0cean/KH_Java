package homepage.beans.dto;

import java.sql.ResultSet;

public class MemberDTO {
	private String member_id;
	private String member_pw;
	private String member_nick;
	private String member_post;
	private String member_base_addr;
	private String member_extra_addr;
	private String member_birth;
	private String member_phone;
	private String member_intro;
	private String access_auth;
	private String access_join;

	public String getAccess_auth() {
		return access_auth;
	}

	public void setAccess_auth(String access_auth) {
		this.access_auth = access_auth;
	}

	public String getAccess_join() {
		return access_join;
	}

	public void setAccess_join(String access_join) {
		this.access_join = access_join;
	}

	public String getAccess_login() {
		return access_login;
	}

	public void setAccess_login(String access_login) {
		this.access_login = access_login;
	}

	private String access_login;

	public MemberDTO() {
		super();
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getMember_post() {
		return member_post;
	}

	public void setMember_post(String member_post) {
		this.member_post = member_post;
	}

	public String getMember_base_addr() {
		return member_base_addr;
	}

	public void setMember_base_addr(String member_base_addr) {
		this.member_base_addr = member_base_addr;
	}

	public String getMember_extra_addr() {
		return member_extra_addr;
	}

	public void setMember_extra_addr(String member_extra_addr) {
		this.member_extra_addr = member_extra_addr;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public String getMember_birthday() {
		return member_birth.substring(0, 10);
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_intro() {
		return member_intro;
	}

	public void setMember_intro(String member_intro) {
		this.member_intro = member_intro;
	}

	public void setMember(ResultSet rs) throws Exception {
		this.member_id = rs.getString("MEMBER_ID");
		this.member_pw = rs.getString("MEMBER_PW");
		this.member_nick = rs.getString("MEMBER_NICK");
		this.member_post = rs.getString("MEMBER_POST");
		this.member_base_addr = rs.getString("MEMBER_BASE_ADDR");
		this.member_extra_addr = rs.getString("MEMBER_EXTRA_ADDR");
		this.member_birth = rs.getString("MEMBER_BIRTH");
		this.member_phone = rs.getString("MEMBER_PHONE");
		this.member_intro = rs.getString("MEMBER_INTRO");
	}

	public void setMember_Access(ResultSet rs) throws Exception {
		this.access_auth = rs.getString("ACCESS_AUTH");
		this.access_join = rs.getString("ACCESS_JOIN");
		this.access_login = rs.getString("ACCESS_LOGIN");
	}

	public MemberDTO(ResultSet rs) throws Exception {
		this.setMember_id(rs.getString("MEMBER_ID"));
		this.setMember_pw(rs.getString("MEMBER_PW"));
		this.setMember_nick(rs.getString("MEMBER_NICK"));
		this.setMember_post(rs.getString("MEMBER_POST"));
		this.setMember_base_addr(rs.getString("MEMBER_BASE_ADDR"));
		this.setMember_extra_addr(rs.getString("MEMBER_EXTRA_ADDR"));
		this.setMember_birth(rs.getString("MEMBER_BIRTH"));
		this.setMember_phone(rs.getString("MEMBER_PHONE"));
		this.setMember_intro(rs.getString("MEMBER_INTRO"));
	}

}
