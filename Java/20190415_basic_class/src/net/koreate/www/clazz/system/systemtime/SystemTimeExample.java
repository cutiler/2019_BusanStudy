package net.koreate.www.clazz.system.systemtime;

import java.util.Date;

public class SystemTimeExample {

	public static void main(String[] args) {
		
		long time1 = System.currentTimeMillis();
		
		long time2 = System.nanoTime();
		
		int sum = 0;
		
		for(int i = 0; i<100000;i++) {
			sum += i;
			
		}
		
		long time3 = System.currentTimeMillis();
		long time4 = System.nanoTime();
		
		System.out.println(sum);
		System.out.println("millis : "+(time3 - time1));
		System.out.println("millis second: "+(time3 - time1)/1000.0);
		System.out.println("nano : "+(time4 - time2));
		System.out.println("nano millis: "+(time4 - time2)/1000000.0);
		System.out.println("nano millis second: "+((time4 - time2)/1000000.0)/1000.0);

		Date date = new Date(0);
		System.out.println(date);
		date = new Date(System.currentTimeMillis());
		System.out.println(date);

	}

}

