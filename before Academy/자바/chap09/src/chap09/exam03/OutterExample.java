package chap09.exam03;

public class OutterExample {

	public static void main(String[] args) {
		Outter out = new Outter();
		Outter.Nested nest = out.new Nested();
		
		out.method1(6);
		System.out.println(out.field1);
		System.out.println(nest.field1);
		System.out.println("----------------------");
		nest.method1(7);
		System.out.println(out.field1);
		System.out.println(nest.field1);
		System.out.println("----------------------");
		nest.method2(8);
		System.out.println(out.field1);
		System.out.println(nest.field1);
		System.out.println("----------------------");

	}

}
//outter field1 : 5 , nest field1 : 10