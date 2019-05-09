package net.koreate.www.classtest;

public class Human {
	
	String name;
	int age;
	int weight;
	Calcurator calc;
	
	public Human() {
		
	}
	public Human(String name) {
		System.out.println("이름을 전달 받는 생성자 : "+name);
		this.name = name;
	}
	public Human(int age) {
		System.out.println("나이를 전달 받는 생성자 : "+age);
		this.age = age;
	}
	public Human(String name, int weight) {
		System.out.println("이름과 몸무게를 전달 받는 생성자 : "+name+" "+weight);
		this.name = name;
		this.weight = weight;
	}
	
	public Human(int age, String name) {
		System.out.println("나이와 이름을 전달 받는 생성자"+age+" "+name);
		this.age = age;
		this.name = name;
		
	}
	
	public Human(String name, int age, int weight) {
		this(age,name);
		System.out.println("이름과 나이, 몸무게를 전달 받는 생성자"+name+" "+age+" "+weight);
		
		/*
		 * this.name = name; this.age = age;
		 */
		this.weight = weight;
		
	}
	
	public Human(String name, int age, int weight, Calcurator calc) {
		
		this(name,age,weight);
		
		/*
		 * this.name = name; this.age = age; this.age = weight;
		 */
		this.calc = calc;
		
	}
	
	void setCalcuratorc(Calcurator calc) {
		this.calc = calc;
		calc.setX(1000);
		
	}
	
	void setAge(int age) {
		this.age = age;
		age = 1000;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Human h = new Human();
		System.out.println(h);
		h.name = "최기근";
		h.age = 20;
		h.weight = 70;
		
		Human h1 = new Human();
		h1.name = "홍길동";
		h1.age = 500;
		h1.weight = 65;
		
		System.out.println(h == h1);
		
		Human h2 = h;
		
		System.out.println(h == h2);
		h2.name = "이순신";
		System.out.println(h.name);
		
		Human h3 = new Human(23);
		
		System.out.println(h3.age);
		System.out.println(h3.name);
		
		Calcurator calc = new Calcurator();
		int sum = calc.plus(10, 20);
		System.out.println("sum : "+sum);
		System.out.println("result : "+calc.result);
		int minus = calc.minus(20, 30);
		System.out.println("minus "+ minus);
		System.out.println("result : "+calc.result);
		int multiply = calc.multiply(10, 20);
		System.out.println("multyply "+ multiply);
		System.out.println("result : "+calc.result);
		double divide = calc.divide(20, 10);
		System.out.println("divide "+ divide);
		System.out.println("result : "+calc.result);
		
		Calcurator c2 = new Calcurator();
		c2.setX(10);
		c2.setY(20);
		System.out.println(c2.x+" + "+c2.y+" : "+ c2.plus());
		
		Human h5 = new Human("장영실",500,70,c2);
		boolean isEquals = h5.calc == c2;
		System.out.println(isEquals);
		
		Human h6 = new Human("이순신",25,90, new Calcurator());
		System.out.println(h6.calc);
		
		h6.setCalcuratorc(new Calcurator());
		h6.setCalcuratorc(c2);
		System.out.println(h6.calc.x);
		System.out.println(c2.x);
		int age = 10;
		
		h6.setAge(age);
		System.out.println(h6.age);
		
		
	}

}
