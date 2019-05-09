package sec6_controlmethod.join;

public class SumThread extends Thread{
	
	private int sum;
	
	@Override
	public void run() {
		for(int i=0; i<=100;i++) {
			sum += i;
			System.out.println("sum : "+sum);
		}
	}

}
