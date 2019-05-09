package sec9_threadpool.excute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExample {
	
	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newFixedThreadPool(3);
		// execute Vs submit
		
		for(int i=0; i <10; i++) {
			Runnable run = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor tpe = (ThreadPoolExecutor)exe;
					int poolSize = tpe.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[ 총 스레드의 수 : "+poolSize+" ] 작업 스레드의 이름 : "+ threadName);
					int i = Integer.parseInt("삼");
				}
			};
			exe.execute(run);
			//exe.submit(run);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {	}
			
		}
		
		
		exe.shutdown();
		
	}

}
