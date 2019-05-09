package sec4_state;

public class ThreadStateExample {
	
	public static void main(String[] args) {
		
		StatePrintThread spt = new StatePrintThread(new TargetThread());
		spt.start();
		
	}

}
