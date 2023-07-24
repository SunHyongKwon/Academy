package chap11.exam01_equals;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("same");
		}else {
			System.out.println("different");
		}
	}
}
