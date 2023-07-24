package chap08.exam01;

public interface RemoteControl {
	//상수
	final static int MAX_VOLUME = 10;
	int MIN_VOLUME = 10;
	//상수이므로 선언하면서 바로 초기화 해줘야된다.
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 메소드
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		}
		else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//정적 메소드 
	static void changeBattery() {
		System.out.println("배터리 교체해주세요~~");
	}
}
