package chap07.prac06;

public class Child extends Parent{
	public String name;
	
	public Child() {
		this("홍길동");
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
	
	public Child(String name, String nation) {
		this.name = name;
		this.nation = nation;
		System.out.println("Child(String name, String nation)");
	}
}

/* super(nation)이 있을 경우
 * 6 - 7 - [11 - 12 - [17 - 18 - [(parent클래스)11 - 12 - 13] - 19 - 20] - 13 - 14] - 8 
 *
 *super(nation) 이 없을 경우
 * 6 - 7 - [11 - 12 - [17 - [(parent클래스)6 - 7 - [11 - 12 - 13] -8] -19 - 20] - 13 -14] - 8 
 * */ 
 