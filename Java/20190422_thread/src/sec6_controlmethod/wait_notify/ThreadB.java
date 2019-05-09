package sec6_controlmethod.wait_notify;

public class ThreadB extends Thread{
	
	public WriteObject obj;
	
	public ThreadB(WriteObject obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		for(int i=0; i <10; i++) {
			obj.methodB();
		}
	}
}
