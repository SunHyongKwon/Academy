package chap11.exam07_hash_hashcode;

import java.util.Objects;

public class HashCodeExample {
	
	public static void main(String[] args) {
		Student a = new Student(1,"sun");
		Student b = new Student(1,"sun");
		Student c = new Student(1,"hyong");
		System.out.println(a.hashCode());
		System.out.println(Objects.hashCode(b));
		System.out.println(Objects.hashCode(c));

	}
	static class Student{
		int sno;
		String name;
		Student(int sno, String name){
			this.sno = sno;
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(sno,name);
		}
	}
}
