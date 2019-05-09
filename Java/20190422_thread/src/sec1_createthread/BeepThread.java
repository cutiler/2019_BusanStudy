package sec1_createthread;

import java.awt.Toolkit;

public class BeepThread extends Thread{

	@Override
	public void run() {
	
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		for(int i=0; i < 5; i++) {
			try {
				tool.beep();
				Thread.sleep(500);
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
		
	}
	
	

}
