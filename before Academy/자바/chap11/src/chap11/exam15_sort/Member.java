package chap11.exam15_sort;

public class Member implements Comparable <Member>{
	String name;
	
	Member(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
}
