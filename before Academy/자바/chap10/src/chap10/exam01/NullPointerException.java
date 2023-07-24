package chap10.exam01;

public class NullPointerException {

	public static void main(String[] args) {
		String string = null;
		try {
		System.out.println(string.toString());
		} catch(Exception e) {
			System.out.println("알수없는 오류가 발생하였습니다요.");
		}
	}

}
