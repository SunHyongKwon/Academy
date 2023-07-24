package chap09.exam01;

public class AExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A.a_method2();
		A.C.method2();
		
		A a = new A();
		A.C c = new A.C();
		a.a_method1();
		c.method1();
		//c.a_method1(); 사용할 수 없다. 
		
	}

}
