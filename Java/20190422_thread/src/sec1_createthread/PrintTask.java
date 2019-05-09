package sec1_createthread;

public class PrintTask implements Runnable{

	@Override
	public void run() {
	
		for(int i=0; i < 5; i++) {
			try {
				System.out.println("띵");
				Thread.sleep(500);
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
		
	}
	
	

}
