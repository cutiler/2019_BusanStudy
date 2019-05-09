package bod.com.cutiler.www;

public class ManosAcc {

int rscStonePrice = 100;
	
	int[] price = new int[6];// { 885, 3400, 10400, 39300, 133000, 220000};
	int[] proPrice = new int[6];
	int[] ManosStoneValue = new int[5];
	
				
	double[] probability = new double[5];//{0.75, 0.45, 0.30, 0.15, 0.10};
	
	int[] probabilityvalue = new int[6];
	
	// 생성자
	
	public ManosAcc() {
		
		
		  price[0] = 885; price[1] = 3400; price[2] = 10400; price[3] = 39300;
		  price[4] = 133000; price[5] = 220000;
		 		
		probability[0] = 0.75;
		probability[1] = 0.45;
		probability[2] = 0.30;
		probability[3] = 0.15;
		probability[4] = 0.10;
		for(int i=0; i < 6; i++) {
			proPrice[i] = 0;
			probabilityvalue[i] = 0;
			if (i != 5) {ManosStoneValue[i] = 0;}
			
		}		
		
	}
	
	public ManosAcc(int[] prival, double[] proval) {
		
		for(int i = 0; i < 6; i++) {
			proPrice[i] = 0;
			probabilityvalue[i] = 0;
			price[i] = prival[i];
			
			if (i != 5) {
				ManosStoneValue[i] = 0;
				probability[i] = proval[i];
				}
			
			
		}
	}
	
	
	// 강화 기대값 계산.
	public int CalculateProbabilityValue() {
		
		double provalue;
		int provaluei;
		
		//System.out.println("전단계 악세가격에 곱할값 * 100");
		// 차후 계산하면 100을 나누어주어야함.
		for (int i = 0; i < 5; i++) {
			provalue = (1 / probability[i]);
			provalue = Math.round(provalue*100);			
			provaluei = (int)provalue;
			probabilityvalue[i+1] = provaluei;
		}
		
		return 0;
	}
	
	
	// 강화 가격 계산.
	public int CalculateManosAccValue() {
		
		for(int manos_i = 0; manos_i < 6; manos_i++) {
			
			if (manos_i == 0) {
				proPrice[manos_i] = price[manos_i];
			}
			else {
				
				// 계산의 편의를 위해 100 곱해준걸 다시 나누어줌.
				proPrice[manos_i] = ( (price[manos_i - 1] * probabilityvalue[manos_i]) / 100);
								
				ManosStoneValue[manos_i - 1] = rscStonePrice * ( 10 + manos_i - 1);
										
				proPrice[manos_i] += ManosStoneValue[manos_i - 1];
	
			}	
		}
				
		return 0;
	}
	
	public void DisplayManosValue(int checkValue) {
		
		int count = 3;
		int countval = 0;
		
		
		if( checkValue / 1000 == 0){
			System.out.print("           "+checkValue+"만");
			
		}
		else 
		{
			countval = checkValue / 1000;
			if (countval / 10 != 0) {
				count--;
				if (countval / 100 != 0) {
					count--;
				}
				if (countval / 1000 != 0) {
					count--;
				}
			}
				
			//System.out.print(count);
			
			for (int i = 0; i < count; i++) {
				System.out.print("  ");					
			}
			
			System.out.print(checkValue / 1000+"억 ");
			if(checkValue % 1000 != 0) System.out.print(checkValue % 1000+"만 |");
			else System.out.print("          |");
			
		}	
	}
	
	public void ConvertProb(int val) {
		
		System.out.print("|");
		if(val == 0) System.out.print("노강 |");
		else if(val == 1) System.out.print(" 장  |");
		else if(val == 2) System.out.print(" 광  |");
		else if(val == 3) System.out.print(" 고  |");
		else if(val == 4) System.out.print(" 유  |");
		else if(val == 5) System.out.print(" 동  |");
		else System.out.print("에러");
		
		
		
	}
	
	
}
