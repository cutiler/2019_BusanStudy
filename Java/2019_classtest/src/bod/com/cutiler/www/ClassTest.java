package bod.com.cutiler.www;


public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ManosAcc Manos = new ManosAcc();
		
		// 강화 기대값 계산.
		Manos.CalculateProbabilityValue();
						
		// 악세 직강값 계산.
		Manos.CalculateManosAccValue();
		
		// 가격 출력.
		System.out.println("==========================");
		System.out.println("I   I  정가가격     I      직강가격      I");
		for(int i = 0; i < 6; i++) {
			
			//System.out.print(i+"강 ");
			Manos.ConvertProb(i);
			Manos.DisplayManosValue(Manos.price[i]);
			System.out.print("        ");
			Manos.DisplayManosValue(Manos.proPrice[i]);
			
			System.out.println("");
		}	
		System.out.println("==========================");
	}

}
