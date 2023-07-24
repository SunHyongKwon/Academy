package chap11.exam15_sort;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		int[] scores = {98,97,99};
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		String[] name = {"ghdrlf","alsdk","rnbsdk"};
		Arrays.sort(name);
		System.out.println(Arrays.toString(name));
		
		Member m1 = new Member("mike");
		Member m2 = new Member("sun");
		Member m3 = new Member("hyong");
		Member[] m4 = {m1,m2,m3};
		Arrays.sort(m4);
		for(Member member : m4) {
			System.out.println(member.name);
		}
		
	}

}
