package sec6_controlmethod.wait_notify1;

public class DataBox {
	
	private String data;
	
	synchronized public String getData() {
	
		if(this.data == null) {	
			try {
				wait();
			} catch (InterruptedException e) {}
		}
			
		String value = this.data;
		System.out.println("Consumer 가 읽은 데이터 : " + value);
		data = null;
		notify();
		return value;		
	}
	
	public synchronized void setData(String data) {
	
		if(this.data != null) {	
			try {
				wait();
			} catch (InterruptedException e) {}
		}
			this.data = data;
			System.out.println("Producer 가 생성한 데이터 : "+ data);
			notify();
			
			
		
		
	}

}
