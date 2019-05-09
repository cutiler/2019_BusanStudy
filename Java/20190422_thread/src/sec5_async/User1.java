package sec5_async;

public class User1 extends Thread {
	
	private Calcurator calc;
	
	public void setCalcurator(Calcurator calc) {
		setName("User1");
		this.calc = calc;
	}
	
	@Override
	public void run() {		
		calc.setMemory(100);		
	}

}
