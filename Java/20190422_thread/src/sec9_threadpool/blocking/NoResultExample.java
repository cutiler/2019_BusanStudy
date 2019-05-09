package sec9_threadpool.blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {
	
	public static void main(String[] args) {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService exe = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()				
				);
		System.out.println("작업 처리 요청");
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				int sum=0;
				for(int i=0; i <=10; i++) {
					sum += i;
				}
				//Integer.parseInt("aa");
				// 오류 발생시 Future 객체의 get()을 통해 결과 확인
				
				System.out.println("[처리결과]"+sum);
			}			
		};
		
		Future future = exe.submit(run);
		
		try {
			// 작업이 처리 되었는지만 확인 가능			
			future.get();
			System.out.println("작업 처리 완료");
		}catch(Exception e) {
			System.out.println("[실행에외발생]"+e.getMessage());
		}
		exe.shutdown();
		
	}

}
