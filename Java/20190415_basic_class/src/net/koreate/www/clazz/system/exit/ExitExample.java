package net.koreate.www.clazz.system.exit;

import javax.security.sasl.SaslException;

public class ExitExample {
	
	public static void main(String[] args) {
		
		// System.exit(정수);
		
		System.out.println("Main Start");	
		
		System.setSecurityManager(new SecurityManager() {
			
			@Override
			public void checkExit(int status) {
				if(status != 5) {
					throw new SecurityException();
				}
			}
			
		} );
		
		for(int i =0; i<=10;i++) {
			System.out.println("i : "+i);
			
			try {
				System.exit(i);
			}catch(SecurityException e) {
				e.printStackTrace();
			}
			
		}
		
		System.exit(0);
		
		System.out.println("Main 종료");
		
	}

}
