package chap07.prac05;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();
		child.setName("권순형");
		child.setStudentNo(12);
		
		System.out.println(child.name);
		
		Child child2 = new Child("권순성",13);
		child2.setName("권혁");
		child2.setStudentNo(1);
		child2.getStudentNo();
		child2.getName();
		
		System.out.println(child2.name);
	}
}