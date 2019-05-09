package sec3_priority;

public class PriorityExample {
	
	public static void main(String[] args) {
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() { }
		});
		t.setPriority(10);
		
		for(int i=1; i <= 10; i++) {
			
			Thread calc = new CalcThread("Thread-"+i);
			if(i==10){
				System.out.println(i+"번째 스레드");
				calc.setPriority(Thread.MAX_PRIORITY);				
			}
			calc.start();
		}
		
	}

}
