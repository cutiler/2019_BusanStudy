package net.koreate.www.interfacetest;

public class HPPrinter implements Printable{

	
	
	@Override
	public void print() {
		System.out.println("HP Printer 출력");
		
	}
	
	

	@Override
	public void colorPrint() {
		// TODO Auto-generated method stub
		System.out.println("HP color Print");
	}



	void HpPrint() {
		System.out.println("HP Printer 출력");
	}	
	
}
