package arguments;


interface MyInterface{
	void method(int x);
}


public class MyinterfaceExample {
	
	public static void main(String[] args) {
		
		MyInterface mi;
		
		mi = new MyInterface() {

			@Override
			public void method(int x) {
				int result = x*5;
				System.out.println("result : "+result);
				
			}
			
		};
		
		mi = (y)->{			
			int result = y*5;
			System.out.println("result : "+result);
		};
		
		mi.method(10);
		
	}

}
