package chap06.exam03;

public class Singleton {
	//정적 필드
	private static Singleton singleton = new Singleton();
	/* 자기 클래스 타입인 정적 필드를 선언하고 자신의 객체를 생성해 초기화 */
	
	//생성자 
	private Singleton() {
		
	}
	
	//정적 메소드 
	static Singleton getInstance() {
		return singleton;
	}
	/* 이 메소드는 5번 라인에서 만들어지 단 하나의 객체만 리턴하기 때문에 외부에서 이
	 * 메소드를 통해서 객체를 생성해도 모두 동일하다. */
	
	int sum(int num1,int num2) {
		return (num1+num2);
	}
}
