package sec06.exam01;

public class ThisWeekLotto {
 	public static void main(String[] args) {
 		for(int i=0;i<=5;i++) {
 			int a = (int)(Math.random()*45)+1;
 			System.out.println(i+1+"번째: "+a+"\n");
 		}
	}
} //중복 나오면 안되고 숫자 순서대로 나오게 하기