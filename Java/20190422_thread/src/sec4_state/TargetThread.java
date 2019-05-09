package sec4_state;

public class TargetThread extends Thread{

	@Override
	public void run() {
		for(long i=0; i < 10000000000L; i++) {}			
			try {Thread.sleep(1500);} catch (InterruptedException e) {}
		for(long i=0; i < 10000000000L; i++) {}			
		
	}
	
	
}
