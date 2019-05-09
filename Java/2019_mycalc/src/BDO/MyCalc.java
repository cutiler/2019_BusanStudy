package BDO;


public class MyCalc {

	public static void main(String[] args) {
		
		ManosAcc Manos = new ManosAcc();
		
		// 강화 기대값 계산.
		Manos.CalculateProbabilityValue();
						
		// 악세 직강값 계산.
		Manos.CalculateManosAccValue();
		
		// 가격 출력.
		System.out.println("          정가가격                       직강가격");
		for(int i = 0; i < 6; i++) {
			
			System.out.print(i+"강 ");
			
			Manos.DisplayManosValue(Manos.price[i]);
			System.out.print("        ");
			Manos.DisplayManosValue(Manos.proPrice[i]);
			
			System.out.println("");
		}
		
	}
	
}



class ManosAcc {
	int rscStonePrice = 100;
	
	int[] price = new int[] { 885, 3400, 10400, 39300, 133000, 220000};
	int[] proPrice = new int[6];
	int[] ManosStoneValue = new int[5];
	
				
	double[] probability = {0.75, 0.45, 0.30, 0.15, 0.10};
	
	int[] probabilityvalue = new int[6];
	
	
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
			
			System.out.print("            "+checkValue+"만");
			
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
			if(checkValue % 1000 != 0) System.out.print(checkValue % 1000+"만");
			else System.out.print("         ");
			
		}	
	}
}
