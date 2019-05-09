package set;

import java.util.*;

public class HashSetExample {
	
	public static void main(String[] args) {
		
		Set<String> s1 = new HashSet<>();
		s1.add("A");
		s1.add("C");
		s1.add("B");
		s1.add("A");
		
		for(String s : s1) {
			System.out.println(s);
		}
		
		Set<String> s2 = new HashSet<>();
		s2.add("A");
		s2.add("D");
		
		System.out.println("s3");
		Set<String> s3 = new HashSet<>(s1);
		for(String s : s3) {
			System.out.println(s);
		}
		
		s3.addAll(s2);
		
		System.out.println("s3 addAll");		
		for(String s : s3) {
			System.out.println(s);
		}
		
		Set<String> s4 = new HashSet<>(s1);
		s4.retainAll(s2);
		System.out.println(s4.toString());
		
		
		Iterator<String> itr = s4.iterator();
		while(itr.hasNext()) {
			String  s= itr.next();
			System.out.println(s);
			if(s != null) {
				itr.remove();
			}
		}
		
		System.out.println(s4.size());
		
		
	}

}
