package sec9_threadpool.blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultCallableExample {
	
	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		System.out.println("[ 작업 처리 요청 ]");
		
		Callable<Integer> call = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=0; i <= 10; i++) {
					sum += i;
				}
				Thread.sleep(2000);
				return sum;
			}
		};
		
		Future<Integer> future = exe.submit(call);
		try {
			System.out.println("blocking");
			int sum = future.get();
			System.out.println("[처리결과  ]"+sum);
			System.out.println("[작업 처리 완료]");
		} catch(Exception e) {
			System.out.println("[실행예외발생]"+e.getMessage());
		}
		exe.shutdown();
		System.out.println("main thead 종료");
		
		
	}

}
