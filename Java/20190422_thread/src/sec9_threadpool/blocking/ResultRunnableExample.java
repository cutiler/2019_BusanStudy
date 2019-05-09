package sec9_threadpool.blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Result{
	
	int value;
	
	synchronized void addValue(int value) {
		this.value += value;
	}
	
}

class Task implements Runnable{
	
	Result result;
	
	Task(Result result){
		this.result = result;		
	}
	
	@Override
	public void run() {
		int sum =0;
		for(int i=0; i <=10; i++) {
			sum += i;
		}
		result.addValue(sum);
	}
	
	
}


public class ResultRunnableExample {
	
	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		System.out.println("[작업 처리 요청]");
		
		Result result = new Result();
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		Future<Result> result1 = exe.submit(task1,result);
		Future<Result> result2 = exe.submit(task2,result);
		try {
			Result result3 = result1.get();
			System.out.println("[ 처리결과 ] "+result3.value);
			Result result4 = result2.get();
			System.out.println("[ 처리결과 ] "+result4.value);
			System.out.println("[ 작업 처리 완료 ]");
		} catch(Exception e) {
			System.out.println("실행 예외 발생"+e.getMessage());
		}
		
		exe.shutdown();
		
	}

}
