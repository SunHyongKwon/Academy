package chap05;

public class ShallowAndDeepCopy {
	public static void main(String[] args) {
		String[] oldArray = {"kyong","hyong","hyukil"};
		String[] newArray = new String[5]; //새로운 배열과 복사할 배열 생
		System.out.println("--------------------------Shallow Copy--------------------------");
		for(int i=0;i<oldArray.length;i++) {
			newArray[i] = oldArray[i];
			System.out.println("newArray["+i+"]: "+newArray[i]);
			System.out.println(newArray[i] == oldArray[i]);
			System.out.println(newArray[i].equals(oldArray[i]));
			if(i==2) {
				break;
			}
			System.out.println("------------------------------------------------");
		}//얕은 복사
		System.out.println("---------------------------Deep Copy---------------------------");
		for(int i=0;i<oldArray.length;i++) {
			newArray[i] = new String(oldArray[i]);
			System.out.println("newArray["+i+"]: "+newArray[i]);
			System.out.println(newArray[i] == oldArray[i]);
			System.out.println(newArray[i].equals(oldArray[i]));
			System.out.println("------------------------------------------------");
		}//얕은 복사
	}
}
