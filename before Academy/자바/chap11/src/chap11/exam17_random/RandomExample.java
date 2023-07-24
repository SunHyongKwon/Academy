package chap11.exam17_random;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		//select num
		int[] selectNumber = new int[6];
		Random random = new Random(	);
		System.out.print("select number : ");
		for(int i=0;i<selectNumber.length;i++) {
			selectNumber[i] = random.nextInt(45)+1;
			System.out.print(selectNumber[i] + " ");
		}
		
		System.out.println();
		
		int[] winningNumber = new int[6];
		random = new Random();
		System.out.print("winning number : ");
		for(int i=0;i<winningNumber.length;i++) {
			winningNumber[i] = random.nextInt(45)+1;
			System.out.print(winningNumber[i] + " ");
		}
		
		System.out.println();
		
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		if(result) {
			System.out.println("congratulation");
		}else {
			System.out.println("fail");
		}
	}

}
