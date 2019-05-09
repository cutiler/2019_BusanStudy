package net.koreate.www.extends1.test3;

public class HumanExample {
	
	public static void main(String[] args) {
		
		Human h = new Human("홍길동",19,70,180);
		System.out.println( h.toString() );
		
		Human t = new Teacher("이순신",600,89,190,"ES-314","무술","3학년");
		
		Human s = new Student("오성",15,60,150,"3반","ASD","3학년");
		
		System.out.println(t.toString());
		System.out.println(s.toString());
		
		Teacher t1 = (Teacher)t;
		t1.teach();
		((Teacher)t).teach();
		
		if(s instanceof Teacher) {
			Teacher t2 = (Teacher)s;
			System.out.println("Teacher 타입");
		}else System.out.println("Teacher 타입이 아닙니다.");
		
	}

}
