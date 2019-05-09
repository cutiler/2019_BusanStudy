package sec5_async_hashtable;

import java.util.Hashtable;

public class HashtableSyncExample {
	
	public static void main(String[] args) {
		//HashMap<String,String> map = new HashMap<>();
		Hashtable<String,String> map = new Hashtable<>();
		
		for(int i=0; i<10000; i++) {
			map.put("key"+i,"value"+i);
		}
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000;i++) {
					if(i%2 == 1) {
						map.remove("key"+i);
					}
				}
			}
		});
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000;i++) {
					if(i%2 == 0) {
						map.remove("key"+i);
					}
				}
			}
		});
		
		t.start();
		t1.start();
		
		
		Thread t2 = new Thread(()->{
			while(true) {
				Thread.State state = t.getState();
				Thread.State state1 = t1.getState();
				
				if(state == Thread.State.TERMINATED &&
					state1 == Thread.State.TERMINATED) {
					System.out.println("t, t1 작업 종료");
					System.out.println("남은개수 : " + map.size());
					break;
				}
			}
		});
		t2.start();
	}

}
