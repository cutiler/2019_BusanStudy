package oracle.base;

public class StaticTest {
	
	
	private static int a = 10;
	int b = 20;
	
	static {
		System.out.println("StaticTest static method"+a);
	}
	
	{
		System.out.println("무명 method : "+b);
	}
	
	StaticTest(){
		System.out.println("Static Test 생성자 호출");
	}
	

	public static void main(String[] args) {
		new StaticTest();		
		
	}	
	
}
