package sec5_async;

public class MainThreadExample {
	
	public static void main(String[] args) {
		
		Calcurator calc = new Calcurator();
		
		User1 user1 = new User1();
		user1.setCalcurator(calc);
		
		User2 user2 = new User2();
		user2.setCalcurator(calc);
		
		user1.start();
		user2.start();
		
		
		
		
	}

}
