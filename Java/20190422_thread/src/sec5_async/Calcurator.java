package sec5_async;

public class Calcurator {
	
	private int memory;
	
	public int getMemory() {
		return this.memory;
	}
	
	//public synchronized void setMemory(int memory) {		
	public void setMemory(int memory) {
		
		synchronized(this) {
		
			this.memory = memory;
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		
			System.out.println(Thread.currentThread().getName()+" : "+this.memory);
		}
	}
			

}
