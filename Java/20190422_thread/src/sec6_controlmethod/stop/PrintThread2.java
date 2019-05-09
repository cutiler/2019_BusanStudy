package sec6_controlmethod.stop;

public class PrintThread2 extends Thread {
	
	@Override
	public void run() {
		
		/*
		  try { while(true) { System.out.println("실행중"); sleep(1); }
		  }catch(InterruptedException e) {}
		 */
		
		while(true) {
			System.out.println("실행중2");
			if(Thread.interrupted()) {
				break;
			}
			
		}
		
		System.out.println("자원정리");
		System.out.println("실행종료");
	}

}
