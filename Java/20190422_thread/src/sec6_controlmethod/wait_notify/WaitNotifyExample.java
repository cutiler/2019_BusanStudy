package sec6_controlmethod.wait_notify;

public class WaitNotifyExample {
	
	public static void main(String[] args) {
		// synchronized 블럭 내부에서만 사용가능.
		
		WriteObject obj = new WriteObject();
		ThreadA a = new ThreadA(obj);
		ThreadB b = new ThreadB(obj);
		
		a.start();
		b.start();
		
	}

}
