package net.koreate.www.object.clone;

import java.util.Arrays;

public class MemberExample {

	public static void main(String[] args) {

		Member original = new Member("홍길동",25,new int[] {100,100},new Car("아반떼"));
		
		Member cloned = original.getMember();
		
		cloned.score[0] = 70;
		cloned.car.model = "소나타";
		
		System.out.println("[복제 객체의 필드값]");
		System.out.println("name : "+ cloned.name);
		System.out.println("age : "+ cloned.age);
		System.out.println("score : "+ Arrays.toString(cloned.score));
		System.out.println("Car : "+ cloned.car.model);

				
		System.out.println("[원본 객체의 필드값]");
		System.out.println("name : "+ original.name);
		System.out.println("age : "+ original.age);
		System.out.println("score : "+ Arrays.toString(original.score));
		System.out.println("Car : "+ original.car.model);
		
		
		cloned.age = 7;
		cloned.name = "참조";
		System.out.println("=== 원본 ====");
		System.out.println("name : "+ original.name);
		System.out.println("age : "+ original.age);
		System.out.println("=== 복제 ===");
		System.out.println("name : "+ cloned.name);
		System.out.println("age : "+ cloned.age);

	
		
	}

}
