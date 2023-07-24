package chap08.exam02;

public class InterfaceGrandSon extends InterfaceSon{

	@Override
	public void method1() {
		System.out.println("Im a interfacegrandson");
	}

	@Override
	public void method2() {
		super.method2();
	}
	
}
