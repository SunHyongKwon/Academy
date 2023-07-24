package chap11.exam14_array;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
		int[][] original= {{1,2},{3,4}};
		
		//얕은 복사후 비교
		System.out.println("[얕은 복제후 비교]");
		int[][] clone1 = Arrays.copyOf(original, original.length);
		System.out.println(original.equals(clone1));
		System.out.println(Arrays.equals(original, clone1));
		System.out.println(Arrays.deepEquals(original, clone1));
		
		//깊은 복사후 비
		System.out.println("[깊은 복제후 비교]");
		int[][] clone2 = Arrays.copyOf(original, original.length);
		clone2[0] = Arrays.copyOf(original[0], original[0].length);
		clone2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println(original.equals(clone2));
		System.out.println(Arrays.equals(original, clone2));
		System.out.println(Arrays.deepEquals(original, clone2));
		
	}

}
