package chap09.exam02;

class A {
	A(){
		System.out.println("A constructor is made");
	}
	
	class B{
		B(){
			System.out.println("B counstructor is made");
		}
		int field1;
		//static int field2;
		void method1(){}
		//static void method2(){}
	}

	static class C{
		C(){
			System.out.println("C constructor is made");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method1() {
		class D {
			D(){
				System.out.println("D constructor is made");
			}
			int field1;
			//static int field2;
			void method1() {}
			//static void method2() {}
		}
		D d = new D();
		d.field1 = 5;
		d.method1();
	}

}
