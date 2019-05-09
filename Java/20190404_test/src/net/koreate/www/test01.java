package net.koreate.www;

import java.util.Scanner;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius;
		double area;
		
		System.out.println("반지름을 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		
		radius = sc.nextDouble();
		area = 3.14 * (radius * radius);
		System.out.println(area);
		
		sc.close();
		
	}

}
