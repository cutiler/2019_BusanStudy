package sec1_createthread;

import java.awt.Toolkit;

public class BeepExample {
	
	public static void main(String[] args) {
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		tool.beep();
		
		for(int i=0;i<5;i++) {
			try {
				tool.beep();
				// 현재 사용중인 thread를 대기상태로 만듬.
				// 1000/1 초 == 0.5초
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println("띵");
				// 현재 사용중인 thread를 대기상태로 만듬.
				// 1000/1 초 == 0.5초
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		System.out.println("main 종료");
		
	}

}
