package sec6_controlmethod.join;

public class JoinExample {
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		SumThread sum = new SumThread();
		sum.start();
		
		try {
			sum.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 종료");
		
	}

}
