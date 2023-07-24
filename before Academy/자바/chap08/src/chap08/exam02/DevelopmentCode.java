package chap08.exam02;

public class DevelopmentCode {
	void developmentMenthod(Interface inf) {
		if(inf instanceof InterfaceSon) {
			System.out.println("나는 첫째 아들이다.");
		}else {
			System.out.println("나는 둘째 아들이다.");
		}
		inf.method1();
		inf.method2();
	}
}
