package net.koreate.www.object.equals;

public class MemberExample {

	public static void main(String[] args) {
		
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if(obj1 == obj2) {
			System.out.println("obj1 과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1 과 obj2는 동등  하지 않습니다.");
		}
		
		if(obj1.equals(obj2)) {
			
			System.out.println("obj1 과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1 과 obj2는 동등  하지 않습니다.");
		}
		
		if(obj1.equals(obj3)) {
			
			System.out.println("obj1 과 obj3는 동등합니다.");
		} else {
			System.out.println("obj1 과 obj3는 동등  하지 않습니다.");
		}
		
		Integer i = new Integer(10);
		Integer j = new Integer(10);
		
		if(i == j) {
			System.out.println("i 과 j는 동등합니다.");
		} else {
			System.out.println("i 과 j는 동등  하지 않습니다.");
		}
		
		if(i.equals(j)) {
			
			System.out.println("i 과 j는 동등합니다.");
		} else {
			System.out.println("i 과 j는 동등  하지 않습니다.");
		}
		
	}
}
