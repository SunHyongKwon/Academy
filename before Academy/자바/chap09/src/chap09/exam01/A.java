package chap09.exam01;

class A {
	int a_field1;
	static int a_field2;
	void a_method1() {
		System.out.println("a void method");
	}
	static void a_method2() {
		System.out.println("a static void method");
	}
	static class C{
		int field1;
		static int field2;
		void method1() {
			System.out.println("c void method");
		}
		static void method2() {
			System.out.println("c static void method");
		}
	}
}
