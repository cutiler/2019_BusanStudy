package tree;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> scores = new TreeSet<>();
		scores.add(87);
		
		scores.add(new Integer(90));
		scores.add(75);
		scores.add(80);
		
		
		for(int i : scores) {
			System.out.println(i);			
		}
		
		System.out.println("======================================");
		
		int score = 0;		
		score = scores.first();
		System.out.println("first : "+score);
		
		score = scores.last();
		System.out.println("last : "+ score);
		
		score = scores.lower(87);
		System.out.println("87보다 낮은 수 (바로 아래 수) : "+score);
		
		score = scores.higher(87);
		System.out.println("87보다 높은 수 (바로 높은 수) : "+score);
		
		score = scores.floor(85);
		System.out.println("85이거나 그 아래의 수 : "+score);
		
	}

}
