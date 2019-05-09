package net.koreate.www.object.clone;

public class Member implements Cloneable{

	public String name;
	public int age;
	public int[] score;
	public Car car;
	
	public Member(String name, int age, int[] score, Car car) {
	
		this.name = name;
		this.age = age;
		this.score = score;
		this.car = car;
	}
	
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Member cloned = (Member)super.clone();
		int[] scores = new int[this.score.length];
		for(int i=0; i<score.length; i++) {
			score[i] = this.score[i];
		}
		
		cloned.score = scores;
		cloned.car = new Car(this.car.model);
		
		return cloned;
	}



	public Member getMember() {
		
		Member cloned = null;
		
		try {
			cloned = (Member)clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cloned;
		
	}
	
	
}
