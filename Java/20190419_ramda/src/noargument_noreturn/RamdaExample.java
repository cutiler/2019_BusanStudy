package noargument_noreturn;

public class RamdaExample {
	
	public static void main(String[] args) {
		
		MyInterface myInterface = new MyInterface() {

			@Override
			public void method() {
				System.out.println("myInterFace method 실행");
				
			}
			
		};
		
		myInterface.method();
		
		
		
		myInterface = ()->System.out.println("Ramda 표현식");
		myInterface.method();
		
		myInterface = ()->{
			String str = "Mthod call";
			System.out.println(str);
		};
		myInterface.method();
		
	}
	

}
