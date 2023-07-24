package chap11.exam01_equals;

public class Member /*extends Object*/ {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)){
				return true;
			}
		}
		return false;
	}
	
}
