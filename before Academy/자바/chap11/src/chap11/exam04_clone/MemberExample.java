package chap11.exam04_clone;

public class MemberExample {

	public static void main(String[] args) {
		Member member = new Member("blue","honggildong","12345",25,true);
		System.out.println(member.id);
		System.out.println(member.name);
		System.out.println(member.password);
		System.out.println(member.age);
		System.out.println(member.adult);
		System.out.println("----------------------");
		Member cloned = member.getMember();
		Member copy = member;
		
		cloned.password = "6859";
		System.out.println(cloned.id);
		System.out.println(cloned.name);
		System.out.println(cloned.password);
		System.out.println(cloned.age);
		System.out.println(cloned.adult);
		System.out.println("----------------------");

		copy.id = "red";
		copy.age = 17;
		copy.adult = false;
		System.out.println(member.id);
		System.out.println(member.name);
		System.out.println(member.password);
		System.out.println(member.age);
		System.out.println(member.adult);
		System.out.println("----------------------");
		System.out.println(cloned.id);
		System.out.println(cloned.name);
		System.out.println(cloned.password);
		System.out.println(cloned.age);
		System.out.println(cloned.adult);
		System.out.println("----------------------");
		System.out.println(copy.id);
		System.out.println(copy.name);
		System.out.println(copy.password);
		System.out.println(copy.age);
		System.out.println(copy.adult);
		
		
	}

}
