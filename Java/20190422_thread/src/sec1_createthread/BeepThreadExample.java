package sec1_createthread;

public class BeepThreadExample {
	
	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		/*
		 * Runnable run = new Runnable() {
		 * 
		 * @Override public void run() { // 실제 스레드가 실행되는 메소드 for(int i=0; i < 5; i++) {
		 * try { System.out.println("띵"); Thread.sleep(500); } catch
		 * (InterruptedException e) { } } } };
		 * 
		 * Thread thread = new Thread(run); thread.start();
		 * 
		 * Toolkit tool = Toolkit.getDefaultToolkit(); for(int i=0; i < 5; i++) { try {
		 * tool.beep(); Thread.sleep(500); } catch (InterruptedException e) { } }
		 */
		
		PrintTask task = new PrintTask();
		Thread thread1 = new Thread(task);
		thread1.start();
		
		BeepThread t = new BeepThread();
		t.start();
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				 for(int i=0; i < 5; i++) {
					  try { 
						  System.out.println("띵2"); 
						  Thread.sleep(500); 
						  } catch  (InterruptedException e) {
							  	e.printStackTrace();
						  } 
				}				
			}
		});

		thread2.start();		
		
		
		System.out.println("main 종료");
	}

}
