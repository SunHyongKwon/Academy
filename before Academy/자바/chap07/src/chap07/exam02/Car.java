package chap07.exam02;

//배열로 객체 관리하기
public class Car {
	//필드
	Tire[] tires = {
			new Tire("앞왼쪽",6),
			new Tire("앞오른쪽",5),
			new Tire("뒤왼쪽",8),
			new Tire("뒤오른쪽",11),
		};
	
	//메소드
	int run() {
		System.out.println("자동차가 달립니다.");
		for(int i=0;i<tires.length;i++) {
			if(tires[i].roll()==false) {
				stop();
				return (i+1);
			}
		}
		return 0;
	}
	
	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
	
}
