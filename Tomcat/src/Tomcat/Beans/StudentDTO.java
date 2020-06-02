package Tomcat.Beans;

public class StudentDTO {
	private int student_no;
	private String student_name;
	private int student_score;
	private String student_create;

	public StudentDTO() {
		super();
	}

	public int getStudent_no() {
		return student_no;
	}

	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_score() {
		return student_score;
	}

	public void setStudent_score(int student_score) {
		this.student_score = student_score;
	}

	public String getStudent_create() {
		return student_create;
	}

	public void setStudent_create(String student_create) {
		this.student_create = student_create;
	}

}
