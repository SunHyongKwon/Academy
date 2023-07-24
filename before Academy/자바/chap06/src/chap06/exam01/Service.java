package chap06.exam01;

@PrintAnnotation
public class Service {
	
	@PrintAnnotation
	@JustForMe
	public void method1(){
		System.out.println("실행내용1");
	}
	
	@PrintAnnotation("*")
	public void method2(){
		System.out.println("실행내용2");
	}
	
	@PrintAnnotation(value="#",num=20)
	public void method3(){
		System.out.println("실행내용3");
	}
}
