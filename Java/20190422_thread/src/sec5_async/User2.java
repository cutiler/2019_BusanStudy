package sec5_async;

public class User2 extends Thread{

	private Calcurator calc;
	
	public void setCalcurator(Calcurator calc) {
		setName("User2");
		this.calc = calc;
	}
	
	@Override
	public void run() {		
		calc.setMemory(50);		
	}


}
