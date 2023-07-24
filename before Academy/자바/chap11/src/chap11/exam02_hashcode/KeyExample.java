package chap11.exam02_hashcode;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		hashMap.put(new Key(1), "honggildong");
		Key key = new Key(1);
		
		String value = hashMap.get(new Key(1));
		System.out.println(value);
		System.out.println(key);
	}

}
