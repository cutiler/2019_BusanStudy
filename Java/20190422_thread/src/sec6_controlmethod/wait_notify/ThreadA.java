package sec6_controlmethod.wait_notify;

public class ThreadA extends Thread{
	
	public WriteObject obj;
	
	public ThreadA(WriteObject obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		for(int i=0; i <10; i++) {
			obj.methodA();
		}
	}
	
	

}
