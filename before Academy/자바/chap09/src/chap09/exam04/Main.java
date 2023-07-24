package chap09.exam04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btn = new Button();
		btn.setOnClickListener(new PhoneButton());
		btn.touch();
	}

}
