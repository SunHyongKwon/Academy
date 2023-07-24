package confused.aboutstatic;

public final class MyStatic {
	//필드
	public static int intStatic;
	public static final String stringStatic = "bye";
	public int intNonStatic;
	public String stringNonStatic;
	
	//메소드
	public static void staticMethod() {
		System.out.println("static method");
	}
	
	public void nonStaticMethod() {
		System.out.println("non static method");
	}
}
