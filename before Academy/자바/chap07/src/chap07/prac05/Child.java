package chap07.prac05;

public class Child extends Parent{
	private int studentNo;
	
	public Child(String name, int studentNo) {
		this.name = name;
		this.studentNo = studentNo;
	}
	
	public Child() {
	}

	public void	setStudentNo(int studentNo) {
		this.studentNo = studentNo;
		System.out.println(this.studentNo);
	}
	
	public int getStudentNo() {
		System.out.println(studentNo);
		return this.studentNo;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
