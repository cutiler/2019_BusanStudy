package net.koreate.www.clazz.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		System.out.println(sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy년MM월dd일");
		String now = sdf.format(date);
		System.out.println(now);

		
		Date date1 = new Date(System.currentTimeMillis());
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now = sdf.format(date1);
		System.out.println(now);
		
		Date date2 = new Date(151515151106L);
		sdf = new SimpleDateFormat("yyyy.MM.dd E요일 HH:mm:ss");
		now = sdf.format(date2);
		System.out.println(now);
		
		
		Date startDate = new Date(0);
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now = sdf.format(startDate);
		System.out.println(now);
		
		Date maxDate = new Date((long)Integer.MAX_VALUE*(long)1000);
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now = sdf.format(maxDate);
		System.out.println(now);
		
		
		
	}	
	
	

}
