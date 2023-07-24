package chap06.exam03;

public class SingletonExample {

	public static void main(String[] args) {
		//Singleton singleton = new Singleton();
		Singleton singleton = Singleton.getInstance();
		int num = singleton.sum(10,20);
		System.out.println(num);
	}

}
