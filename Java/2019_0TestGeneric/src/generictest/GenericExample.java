package generictest;

public class GenericExample {

	public static void main(String[] args) {
		
		Child ctest = new Child();
		Util util = new Util();
		Pair<String, Integer> p = new Pair<>(); 
		util.utilCall(p);
		
		
	}
	
	
}
