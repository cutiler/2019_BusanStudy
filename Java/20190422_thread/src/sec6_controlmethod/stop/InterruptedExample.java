package sec6_controlmethod.stop;

public class InterruptedExample {
	
	public static void main(String[] args) {
		
		PrintThread2 printThread = new PrintThread2();
		
		printThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		printThread.interrupt();
		
		
	}

}
