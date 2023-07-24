package chap06.exam02;

public class EqualsExample {
	
	public static void main(String[] args) {
		Equals equal1 = new Equals();
		Equals equal2 = new Equals();
		
		System.out.println(equal1);
		System.out.println(equal2);
		System.out.println(equal1 == equal2);
		System.out.println(equal1.equals(equal2));
		System.out.println("\n"+"----------------------------------"+"\n");
		String a = "apple";
		String b = "apple";
		String c = new String("apple");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(c));
		
	}
	
	
}
