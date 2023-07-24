package chap11.exam10_getproperty;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");

		System.out.println(osName);
		
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = (String) System.getProperty(key);
			System.out.println(key + "]" + value);
		}

	}

}
