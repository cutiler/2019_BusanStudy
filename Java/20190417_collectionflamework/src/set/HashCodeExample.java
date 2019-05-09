package set;

import java.util.*;

public class HashCodeExample {
	
	public static void main(String[] args) {
		
		String name1 = "최기근";
		String name2 = "최기근";
		
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		
		Member member1 = new Member(name1, 20);
		Member member2 = new Member(name2, 20);
		
		System.out.println(member1.hashCode());
		System.out.println(member2.hashCode());
		
		Set<Member> set = new HashSet<>();
		set.add(member1);
		set.add(member2);
		
		System.out.println(" set 의 총 객체수 : "+set.size());
		
	}

	
}
