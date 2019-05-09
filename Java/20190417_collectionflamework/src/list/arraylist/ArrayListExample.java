package list.arraylist;

import java.util.*;

public class ArrayListExample {
	
	public static void main(String[] args) {
		
		ArrayList array = new ArrayList();
		
		array.add("문자열");
		array.add(100);
		
		String str = (String)array.get(0);
		System.out.println(str);
		
		ArrayList<String> strs = new ArrayList<>(5);
		int strsSize = strs.size();
		System.out.println(strsSize);
		
		strs.add("Java");
		strs.add("JDBC");
		System.out.println(strs.size());
		
		strs.add("DATABASE");
		strs.add("SERVLET/JSP");
		
		System.out.println(strs.get(3));
		strs.add(2,"ORACLE");
		for(String s : strs) {
			System.out.println(s);
		}
		
		strs.set(3, "HTML");
		strs.add("JDBC");
		strs.add("JDBC");
		strs.add("JDBC");
		strs.add("JDBC");
		strs.remove("JDBC");
		strs.remove(0);
		
		
		Iterator<String> iterator = strs.iterator();
		// hasNext();
		// next();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}		
		
		System.out.println("======================");
		ListIterator<String> listIterator = strs.listIterator();
		
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println("======================");
		while(listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		System.out.println("======================");
		
		for(int i=0; i<strs.size(); i++) {
			System.out.println(strs.get(i));
		}
		System.out.println("======================");
		
		for(String s : strs) {
			System.out.println(s);
		}
		
		
		System.out.println(strs.isEmpty());
		
		strs.clear();
		
		System.out.println("청소끝");
		System.out.println(strs.isEmpty());
		
		
	}

}
