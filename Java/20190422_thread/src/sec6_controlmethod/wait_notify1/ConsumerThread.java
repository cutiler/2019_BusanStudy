package sec6_controlmethod.wait_notify1;

public class ConsumerThread extends Thread{
	
	private DataBox dataBox;
	
	public ConsumerThread(DataBox box) {
		dataBox = box;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i <=3; i++) {
			String data = dataBox.getData();
		}
	}

}
