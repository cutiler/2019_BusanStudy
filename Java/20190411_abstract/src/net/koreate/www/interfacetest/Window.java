package net.koreate.www.interfacetest;

public class Window {
	
	HPPrinter hp = new HPPrinter();
	SamsungPrinter sp = new SamsungPrinter();
	LGPrinter lp = new LGPrinter();
	
	void print(Printable printer) {
		printer.print();
	}
	

}
