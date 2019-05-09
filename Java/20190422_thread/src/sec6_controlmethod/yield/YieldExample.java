package sec6_controlmethod.yield;

class ThreadA extends Thread{
	boolean stop = true;
	boolean work = true;
	
	@Override
	public void run() {
		while(stop) {
			try {
				sleep(500);
				if(work) {
					System.out.println("Thread A 작업");
				}else {
					// 우선순위가 동일한 다른 스레드에게 실행을 양보
					// yield();
					Thread.yield();
				}
				
			} catch (InterruptedException e) {}
		}
		System.out.println("ThreadA 작업완료");
	}
}

class ThreadB extends Thread{
	boolean stop = true;
	boolean work = true;
	
	@Override
	public void run() {
		while(stop) {
			try {
				sleep(500);
				if(work) {
					System.out.println("Thread B 작업");
				}else {
					// 우선순위가 동일한 다른 스레드에게 실행을 양보
					// yield();
					Thread.yield();
				}
			} catch (InterruptedException e) {}
		}
		System.out.println("ThreadB 작업완료");
	}
}



public class YieldExample {
	
	public static void main(String[] args) throws Exception{
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		Thread.sleep(2000);
		
		threadA.work = false;
		
		Thread.sleep(3000);
		
		threadA.work = true;
		
		Thread.sleep(2000);
		
		threadA.stop = false;
		threadB.stop = false;
		
		
		
	}

}
