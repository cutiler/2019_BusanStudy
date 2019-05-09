package tree.comparator;

import java.util.*;

public class ComparatorExample {
	
	public static void main(String[] args) {
		
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if(i1 > i2) {
					return -1;
				}else if(i1 == i2){
					return 0;
				} else {
					return 1;
				}			
			}			
			
		};
		
		int i = Integer.compare(10, 20);
		System.out.println(i);
		int i1 = com.compare(10, 20);
		System.out.println(i1);
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(50);
		treeSet.add(70);
		treeSet.add(100);
		treeSet.add(10);
		
		System.out.println(treeSet);
		
		TreeSet<Integer> treeSet1 = new TreeSet<>(com);
		treeSet1.add(50);
		treeSet1.add(70);
		treeSet1.add(100);
		treeSet1.add(10);
		
		System.out.println(treeSet1);
		
		// Fruit
		TreeSet<Fruit> fruitSet = new TreeSet<>(new Comparator<Fruit>() {

				@Override
				public int compare(Fruit o1, Fruit o2) {
					if(o1.getPrice() > o2.getPrice()) {
						return -1;
					}else if(o1.getPrice() == o2.getPrice()) {
						return 0;
					}else {
						return 1;
					}
				}
			
			
			}
		);
		fruitSet.add(new Fruit("포도",3000));
		fruitSet.add(new Fruit("딸기",1500));
		fruitSet.add(new Fruit("수박",10000));
		
		System.out.println(fruitSet);
		
		// implements
		TreeSet<Fruit> fruitSet1 = new TreeSet<>( new AscendingFruit() );
		fruitSet1.add(new Fruit("바나나",2000));
		fruitSet1.add(new Fruit("오렌지",3000));
		fruitSet1.add(new Fruit("사과",1000));
		
		System.out.println(fruitSet1);
		
	
		
	}

}

