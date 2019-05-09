package net.koreate.www.interfacetest;

public class PrintExample {
	
	public PrintExample() {
		super();
	}

	public static void main(String[] args) {
		
		Window window = new Window();
		window.print(new HPPrinter());
		window.print(new SamsungPrinter());
		window.print(new LGPrinter());

		Printable.copy("복사");	
		
	}

}
