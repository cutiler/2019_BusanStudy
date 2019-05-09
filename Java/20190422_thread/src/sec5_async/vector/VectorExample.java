package sec5_async.vector;

import java.util.Vector;

public class VectorExample {
	
	public static void main(String[] args) {
		
		//ArrayList<String> array = new ArrayList<>();
		Vector<String> array = new Vector<>();
		
		Thread t1 = new Thread(()->{
			for(int i=0; i<100; i++) {
				array.add("최기근");
			}
		});

		
		Thread t2 = new Thread(()->{
			for(int i=0; i<100; i++) {
				array.add("천재");
			}
		});
		
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(()->{
			while(true) {
				Thread.State state1 = t1.getState();
				Thread.State state2 = t2.getState();
				
				if(state1 == Thread.State.TERMINATED &&
					state2 == Thread.State.TERMINATED) {
					System.out.println("t1, t2 작업 종료");
					System.out.println("들어간개수 : " + array.size());
					for(String s : array) {
						System.out.println(s);
					}					
					break;
				}
			}
		});
		t3.start();
		
	
		
	}

}
