package sec7_daemon;

import java.util.Map;
import java.util.Set;

public class ThreadInfoExample {
	
	public static void main(String[] args) {
		
		AutoSaveThread auto = new AutoSaveThread();
		auto.setName("AutoSaveThread");
		
		auto.setDaemon(true);
		auto.start();
		
		Thread t = new Thread(()->{
			
			for(int i=0;i<1000000;i++) {
				
			}
			
		});
		
		t.start();
		
		Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			System.out.println("Name "+thread.getName()+ ((thread.isDaemon())? "(데몬) " : "(주)"));
			System.out.println("\t 소속그룹 : " + thread.getThreadGroup().getName());
			System.out.println();
		}
		
	}

}
