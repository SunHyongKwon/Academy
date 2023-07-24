package chap09.exam02;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		b.field1=5;
		b.method1();
		
		A.C c = new A.C();
		c.field1=5;
		A.C.field2=6;
		c.method1();
		A.C.method2();
		
		a.method1();
	}

}