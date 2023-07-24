package chap11.exam12_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
	
	private static void printParameter(Class[] parameters) {
		for(int i=0; i<parameters.length;i++) {
			System.out.print(parameters[i].getName());
			if(i < (parameters.length-1)) {
				System.out.print(",");
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class clazz = Class.forName("chap11.exam12_reflection.Car");
		
		System.out.println(clazz.getName());
		System.out.println();
		
		Constructor[] constructors = clazz.getDeclaredConstructors();
		
		for(Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes();
			printParameter(parameters);
			System.out.println(")");
		}
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			System.out.println(field.getType().getSimpleName() + " " + field.getName());
		}
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.print(method.getReturnType().getSimpleName() + " ");
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameter(parameters);
			System.out.println(")");
		}
	}

}
