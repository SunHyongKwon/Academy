package chap07.exam02;

public class KumhoTire extends Tire{
	//필드

	//생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accmulatedRotation;
		if(accmulatedRotation<maxRotation) {
			System.out.println("KumhoTire 수명 : " + (maxRotation - accmulatedRotation)+"회");
			return true;
		}
		else {
			System.out.println("수명을 다하셨습니다.");
			System.out.println("--- KumhoTire : " + location + "---");
			return false;
		}
	}
}