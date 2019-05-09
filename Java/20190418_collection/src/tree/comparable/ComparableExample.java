package tree.comparable;

import java.util.TreeSet;

public class ComparableExample {
	
	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("최기근",25));
		set.add(new Person("이순신",300));
		set.add(new Person("박준현",31));
		set.add(new Person("김태민",21));
		
		System.out.println(set);
		
		TreeSet<String> stringSet = new TreeSet<>();
		stringSet.add("나각가");
		stringSet.add("가가가");
		stringSet.add("가나다");
		stringSet.add("가각가");
		
		System.out.println(stringSet);
		
		int a = Character.compare('가', '나');
		int b = Character.compare('ㄱ', 'ㄴ');
		int c = Character.compare('나', '가');
		int d = Character.compare('ㄴ', 'ㄱ');
		// 앞뒤 뺄셈 값.
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}

}
