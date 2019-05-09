package returns;

@FunctionalInterface
interface MyFuntionalIniterface{
	int method(int x, int y);
}


public class MyInterfaceExample {
	
	public static void main(String[] args) {
		
		MyFuntionalIniterface mi = null;
		
		mi = new MyFuntionalIniterface() {			
			@Override
			public int method(int x, int y) {
				return x+y;
			}
		};
		
		System.out.println(mi.method(10, 20));
		
		mi = (x,y)->{
			int result = x+y;
			return result;
		};
		
		int sum = mi.method(20, 30);
		
		System.out.println(sum);
		
	}

}
