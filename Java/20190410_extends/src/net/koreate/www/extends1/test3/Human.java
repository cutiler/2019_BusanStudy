package net.koreate.www.extends1.test3;

public class Human {
	
	String name;
	int age;
	int weight;
	int height;
	
	
	Human(){super();}


	public Human(String name, int age, int weight, int height) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	
	public String toString() {
		return "Human [name=" + this.name + 
				", age=" + this.age + 
				", weight=" + this.weight + 
				", height=" + this.height + "]";
		}	

}
