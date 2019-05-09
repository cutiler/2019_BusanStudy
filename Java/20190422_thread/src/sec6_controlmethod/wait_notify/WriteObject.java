package sec6_controlmethod.wait_notify;

public class WriteObject {
	
	public synchronized void methodA() {
		System.out.println("methodA 사용");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {}
		
		
	}
	
	synchronized public void methodB() {
		System.out.println("methodB 사용");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {}
		
	}

}
