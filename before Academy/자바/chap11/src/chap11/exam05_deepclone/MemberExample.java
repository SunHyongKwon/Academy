package chap11.exam05_deepclone;

public class MemberExample {

	public static void main(String[] args) {
		Member member = new Member("hong",25,new int[]{90,90},new Car("K8"));
		Member copy = member;
		Member cloned = member.getMember();
		
		cloned.scores[1] = 100;
		cloned.car.model = "sonata";
		
		System.out.println(cloned.name);
		System.out.println(cloned.age);
		for(int i=0;i<cloned.scores.length;i++) {
			System.out.print(cloned.scores[i] + " ");
		}
		System.out.println();
		System.out.println(cloned.car.model);
		System.out.println("----------------------");
		System.out.println(member.name);
		System.out.println(member.age);
		for(int i=0;i<member.scores.length;i++) {
			System.out.print(member.scores[i] + " ");
		}
		System.out.println();
		System.out.println(member.car.model);
		System.out.println("----------------------");
		
		copy.scores[1] = 60;
		copy.car.model = "grandeur";
		
		System.out.println(member.name);
		System.out.println(member.age);
		for(int i=0;i<member.scores.length;i++) {
			System.out.print(member.scores[i] + " ");
		}
		System.out.println();
		System.out.println(member.car.model);
		System.out.println("----------------------");
		System.out.println(copy.name);
		System.out.println(copy.age);
		for(int i=0;i<copy.scores.length;i++) {
			System.out.print(copy.scores[i] + " ");
		}
		System.out.println();
		System.out.println(copy.car.model);
	}

}
