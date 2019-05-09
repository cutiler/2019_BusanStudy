package sec2_threadname;


class ThreadA extends Thread{
	
	public ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for(int i=0; i < 2; i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	}
	
}

class ThreadB extends Thread{
	
	public void run() {
		for(int i=0; i < 2; i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	}
	
}

public class ThreadNameExample {
	
	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름: "+mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름: "+threadA.getName());
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		System.out.println("작업 스레드 이름: "+threadB.getName());
		threadB.start();
		
		Thread threadC = new ThreadB();
		threadC.setName("Thread-C");
		System.out.println("작업 스레드 이름: "+threadC.getName());
		threadC.start();
		
		
	}

}
