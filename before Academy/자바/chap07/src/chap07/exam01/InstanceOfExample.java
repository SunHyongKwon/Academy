package chap07.exam01;

public class InstanceOfExample {
	public static void main(String[] args) {
		Tire tire = new HankookTire("하이",10);
		if(tire instanceof HankookTire) {
			HankookTire hankooktire = (HankookTire) tire;
			System.out.println(hankooktire.location);
		}
		else {
			System.out.println("안된다 이놈아");
		}
	}
}
