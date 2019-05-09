package net.koreate.www.generic.generic_mothod;

public class GenericMethodExample {
	
	public static void main(String[] args) {
		
		Box<String> box1 = Util.<String>boxing("사과");
		Box<String> box2 = Util.boxing("오렌지");
		String s = box2.getType();
		
		Box<Integer> box3 = Util.<Integer>boxing(100);
		int i = box3.getType();
				
		
	}
	

}
