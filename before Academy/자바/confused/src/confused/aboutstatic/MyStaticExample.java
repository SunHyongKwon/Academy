package confused.aboutstatic;

public class MyStaticExample {
	public static void main(String[] args) {
	MyStatic.staticMethod();
	MyStatic.intStatic = 7;
	String a = MyStatic.stringStatic;
	
	MyStatic mystatic = new MyStatic();
	mystatic.intNonStatic = 10;
	mystatic.stringNonStatic = "bye";
	mystatic.nonStaticMethod();
	}
}
