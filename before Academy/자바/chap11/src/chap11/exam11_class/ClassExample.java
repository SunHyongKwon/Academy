package chap11.exam11_class;

public class ClassExample {

	public static void main(String[] args) {
		Car car = new Car();
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackageName());
		
		try {
			Class clazz2 = Class.forName("chap11.exam11_class.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackageName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
