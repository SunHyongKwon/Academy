package chap07.exam01;

public class HankookTire extends Tire{
	//필드
	
	//생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accmulatedRotation;
		if(accmulatedRotation<maxRotation) {
			System.out.println("HankookTire 수명 : " + (maxRotation - accmulatedRotation)+"회");
			return true;
		}
		else {
			System.out.println("수명을 다하셨습니다.");
			System.out.println("--- HankookTire : " + location + "---");
			return false;
		}
	}
}
