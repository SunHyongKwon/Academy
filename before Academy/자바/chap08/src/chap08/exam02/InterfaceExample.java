package chap08.exam02;

public class InterfaceExample {

	public static void main(String[] args) {
		Interface inf = new Interface() {
			public void method1() {
				System.out.println("hi");
			}
			public void method2() {
				System.out.println("bye");
			}
		};
		Interface inf2 = new Interface() {
			public void method1() {
				System.out.println("hi");
			}
			public void method2() {
				System.out.println("bye");
			}
		};
		
		DevelopmentCode dvc = new DevelopmentCode();
		dvc.developmentMenthod(new InterfaceSon());
		dvc.developmentMenthod(new InterfaceSon2());
		dvc.developmentMenthod(new InterfaceGrandSon());
	}
}

/* 익명 구현 객체를 만들게 되면 class가 추가적으로 생기는데 이 class의 이름은 해당 클래스$1로 생성되고 
 * 만약 개수가 늘어나게 되면 해당 클래스 이름$2,$3 이런식으로 늘어나게 된다. 
 */