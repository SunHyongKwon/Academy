package chap09.exam04;

public class Button {
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	//중첩 인터페이스 선언
	interface OnClickListener{
		void onClick();
	}
}
