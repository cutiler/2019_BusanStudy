package sec8_threadgroup;

public class WorkThread extends Thread{
	
	public WorkThread(ThreadGroup group, String threadName) {
		super(group, threadName);
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
				System.out.println(getName()+" interrupted!");
				break;
			}
			
		}
		System.out.println(getName()+"종료");
	}

}
