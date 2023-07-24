package chap06.exam01;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class PrintAnnotationExample {

	public static void main(String[] args)  {
		Method[] method = Service.class.getDeclaredMethods();
		boolean a = method[0].isAnnotationPresent(PrintAnnotation.class);
		System.out.println(a);
		System.out.println("\n"+"--------------------------------------------------"+"\n");
		//isAnnotationPresent 메소드 
		
		Annotation b = method[0].getAnnotation(PrintAnnotation.class);
		System.out.println(b);
		System.out.println("\n"+"--------------------------------------------------"+"\n");
		//getAnnotation 메소드
		//값을 받는 변수 타입이 Annotation 이여도 되고, 찾고자 하는 AnnotationName 타입 이여도 된다. 
		
		Annotation[] c = method[0].getAnnotations();
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i]);
		}
		System.out.println("\n"+"--------------------------------------------------"+"\n");
		//getAnnotations 메소드
		//Annotation[] 타입으로 받아야 된다. 
		
		Annotation[] d = method[0].getDeclaredAnnotations();
		for(Annotation d_1:d) {
			System.out.println(d_1);
		}
		System.out.println("\n"+"--------------------------------------------------"+"\n");
		//getDeclaredAnnotations 메소드
		
		for(Method method1 : method) {
			Annotation[] print = method1.getAnnotations();
			for(Annotation print1:print) {
				System.out.println(print1);
			}
		}
	}
}
