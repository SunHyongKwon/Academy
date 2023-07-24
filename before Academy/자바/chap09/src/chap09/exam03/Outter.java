package chap09.exam03;

public class Outter {
	int field1 = 5;
	void method1(int field1) {
		this.field1 = field1;
	}
	
	class Nested {
		int field1 = 10;
		void method1(int field1) {
			this.field1 = field1;
		}
		void method2(int field1) {
			Outter.this.field1 = field1; 
		}
	}
}
