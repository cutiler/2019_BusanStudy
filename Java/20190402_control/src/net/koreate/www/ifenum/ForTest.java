package net.koreate.www.ifenum;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum;
//		int i;
		sum = 0;
		for(int i=1;i < 11;i++) {
			
			sum += i;			
		}
		System.out.println(sum);
		
		/*
		 * for(;;) {
		 * 
		 * }
		 */
//		System.out.println("메인종료");
		
		int j = 1;
		sum = 0;
		
		for(;;j++) {
			if(j>10)break;
			sum += j;
			
		}
		System.out.println("1~10의 합은 "+sum);
		
		int k = 1;
		sum = 0;
		for(;;) {
			if(k>10)break;
			sum += k;
			k++;
			
		}
		
		System.out.println("1~10의 합은 "+sum);
		int i=0;
		for(i = 1; i <= 9; i++) {
			for(j=2; j <=9; j++) {
				System.out.print(j+" * "+ i +" = "+ (i*j) +"\t");
				
			}
			System.out.println();
			
		}
		
		
		System.out.println("메인종료");

	}

}
