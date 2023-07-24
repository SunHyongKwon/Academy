package chap05;

import java.util.Scanner;

public class ValueOf {
	public static void main(String[] args) {
		Week value = Week.MONDAY;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(">");
			String input = scanner.nextLine();
			Week a = Week.valueOf(input);
			System.out.println("value: "+ value + "\na: " +a);
		} 
		//valueOf 메서드
		
		Week[] days = Week.values();
		for(int i=0;i<days.length;i++) {
			System.out.println(days[i]);
		}
	}

}
