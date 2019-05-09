package sec6_controlmethod.wait_notify1;

public class ProducerThread extends Thread{
	
	private DataBox dataBox;
	
	public ProducerThread(DataBox box) {
		dataBox = box;
	}
	
	@Override
	public void run() {
	
		for(int i=0; i <=3; i++) {
			String data = "Data-"+i;
			dataBox.setData(data);
		}
	}

}
