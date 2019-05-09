package sec8_threadgroup;

public class ThreadGroupExample {
	
	public static void main(String[] args) {
		
		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		
		Thread workThreadA = new WorkThread(myGroup,"workTheadA");
		Thread workThreadB = new WorkThread(myGroup,"workTheadB");
		
		Thread t = new Thread(myGroup,new Runnable() {
			@Override
			public void run() {
				while(true) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("t Thread interrupted!");
						break;
					}
					
				}
				System.out.println("t 스레드 종료");
			}
		});
		
		
		workThreadA.start();
		workThreadB.start();
		t.start();
		
		System.out.println("[main 스레드 그룹의 list 정보 출력]");
		
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		group.list();
		System.out.println();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		System.out.println("[my group 스레드 그룹의 interrupt() 호출]");
		myGroup.interrupt();
		
		
		
	}

}
