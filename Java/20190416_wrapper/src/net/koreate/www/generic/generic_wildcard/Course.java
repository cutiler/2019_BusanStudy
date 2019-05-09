package net.koreate.www.generic.generic_wildcard;

public class Course<T> {
	
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		// 배열은 타입을 몰라서 공간확보가 불가능, 그래서 오브젝 타입으로
		// 생성하고 T타입으로 변환.
		students = (T[])(new Object[capacity]);
	}
	
	public String getName() {
		return this.name;
	}
	
	public T[] getStudents() {
		return this.students;		
	}
	
	public void add(T t) {
		
		for(int i=0;i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
			
		}
		
	}
		
	
	

}
