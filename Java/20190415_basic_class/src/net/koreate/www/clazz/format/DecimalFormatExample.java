package net.koreate.www.clazz.format;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		
		double num = 1234567.849;
		
		DecimalFormat df = new DecimalFormat("0");
		String str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("0.0");
		str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("0000000000.00");
		str = df.format(num);
		System.out.println(str);
		
		df = new DecimalFormat("#,###,###,###.##");
		str = df.format(num);
		System.out.println(str);
		
		
		df = new DecimalFormat("\u00A4 #,###원");
		str = df.format(num);
		System.out.println(str);

	}

}
