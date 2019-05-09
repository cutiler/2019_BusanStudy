package oracle.base;

// VO value object
// 데이터 저장 목적으로 생성되는 class
public class StudentVO {
	
	private int stu_no;
	private String stu_name;
	private String stu_dept;
	private int stu_grade;
	private char stu_class;
	private char stu_gender;
	private double stu_height;
	private double stu_weight;
	
	
	
	public StudentVO(int stu_no, String stu_name, String stu_dept, int stu_grade, char stu_class, char stu_gender,
			double stu_height, double stu_weight) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_dept = stu_dept;
		this.stu_grade = stu_grade;
		this.stu_class = stu_class;
		this.stu_gender = stu_gender;
		this.stu_height = stu_height;
		this.stu_weight = stu_weight;
	}
	public int getStu_no() {
		return stu_no;
	}
	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_dept() {
		return stu_dept;
	}
	public void setStu_dept(String stu_dept) {
		this.stu_dept = stu_dept;
	}
	public int getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(int stu_grade) {
		this.stu_grade = stu_grade;
	}
	public char getStu_class() {
		return stu_class;
	}
	public void setStu_class(char stu_class) {
		this.stu_class = stu_class;
	}
	public char getStu_gender() {
		return stu_gender;
	}
	public void setStu_gender(char stu_gender) {
		this.stu_gender = stu_gender;
	}
	public double getStu_height() {
		return stu_height;
	}
	public void setStu_height(double stu_height) {
		this.stu_height = stu_height;
	}
	public double getStu_weight() {
		return stu_weight;
	}
	public void setStu_weight(double stu_weight) {
		this.stu_weight = stu_weight;
	}
	
	@Override
	public String toString() {
		return "StudentVO [stu_no=" + stu_no + ", stu_name=" + stu_name + ", stu_dept=" + stu_dept + ", stu_grade="
				+ stu_grade + ", stu_class=" + stu_class + ", stu_gender=" + stu_gender + ", stu_height=" + stu_height
				+ ", stu_weight=" + stu_weight + "]";
	}
	
	

}
