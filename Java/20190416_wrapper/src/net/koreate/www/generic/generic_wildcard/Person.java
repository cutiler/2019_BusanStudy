package net.koreate.www.generic.generic_wildcard;

// 일반인
public class Person {
	
	private String name;

	
	Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

}
