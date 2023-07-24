package forfun.drink;

import java.util.Scanner;

public class Drink {
	//필드
	private int minute =  5; //5분 나타내는 변수
	
	//생성자
	public Drink() {
		
	}
	public Drink(int minute) {
		this.minute = minute;
	}//시간 바꾸고 싶을 때를 위해
	
	//메소드
	public void drink() {
		int sum=0;
		for(int i=0;i<minute;i++) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("마시고 싶으면 눌러~~");
			char touch = sc.next().charAt(0); //위에 3문장은 나중에 터치를 받는 문장으로 바꾸면 될듯
			if(touch == 'd' || i == minute-1) {
				i = 0;
				sum++;
			}//터치하면
			else if(touch == 'e') {
				break;
			}//그만 마시고 싶으면
			System.out.println("다음 잔까지 남은 시간 : " + (minute-i-1));
		}
		System.out.println("오늘 얼마나 마셨는지 볼까??");
		System.out.println(sum+"잔이나 먹었네~~");
		System.out.println("다음에 또 마시고 싶으면 불러줘~~");
		
	}//어플이나 기계에 터치를 하면 다시 5분이 리셋되는 메소드
	
}
