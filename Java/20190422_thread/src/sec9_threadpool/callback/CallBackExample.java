package sec9_threadpool.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallBackExample {
	
	private ExecutorService service;
	
	public CallBackExample() {
		service = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
	}
	
	private CompletionHandler<Integer, Void> callBack =
			new CompletionHandler<Integer, Void>(){

				@Override
				public void completed(Integer i, Void v) {
				
					System.out.println("completed 실행 : " + i);
					
				}

				@Override
				public void failed(Throwable t, Void v) {
					System.out.println("failed 실행 : "+t.toString());
					
				}	
		
	};
	
	public void doWork(String x, String y) {
		Runnable task = new Runnable() {

			@Override
			public void run() {
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					Thread.sleep(2000);
					callBack.completed(result,null);
				}catch(Exception e) {
					callBack.failed(e, null);
				}				
			}
		};
		service.submit(task);
	}
	
	public void finish() {
		service.shutdown();
	}

	public static void main(String[] args) {
		
		System.out.println("main 시작");
		CallBackExample callBack = new CallBackExample();
		callBack.doWork("3", "3");
		callBack.doWork("3", "삼");
		callBack.finish();
		System.out.println("main 종료");
		
		
	}
	
	
}
