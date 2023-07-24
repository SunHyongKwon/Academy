package chap11.exam13_newinstance;

public class NewInstanceExample {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("chap11.exam13_newinstance.SendAction");
			Action action = (Action) clazz.newInstance();
			action.execute();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
