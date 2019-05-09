package sec6_controlmethod.wait_notify1;

public class WaitNotifyExample {
	
	public static void main(String[] args) {
		
		DataBox dataBox = new DataBox();
		ProducerThread pThread = new ProducerThread(dataBox);
		ConsumerThread cThread = new ConsumerThread(dataBox);
		pThread.start();
		cThread.start();
		
	}


}
