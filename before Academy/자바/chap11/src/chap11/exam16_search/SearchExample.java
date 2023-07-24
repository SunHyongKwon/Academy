package chap11.exam16_search;

import java.util.Arrays;

public class SearchExample {

	public static void main(String[] args) {
		int[] scores = {97,98,99};
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println(index);

	}

}
