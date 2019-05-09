package net.koreate.www.object.finalize;

public class FinalizeExample {
	
	public static void main(String[] args) {
		
		Counter counter = null;
		
		for(int i=0; i < 50; i++) {
			counter = new Counter(i);
			counter = null;
			System.gc();
			
		}
		
	}

}
