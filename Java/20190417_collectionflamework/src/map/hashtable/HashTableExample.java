package map.hashtable;

import java.util.*;


public class HashTableExample {
	
	public static void main(String[] args) {
		
		Map<String, List<String>> map = new Hashtable<>();
		
		ArrayList<String> array = new ArrayList<>();

		array.add("100");
		array.add("200");
		array.add("어렵다");
		
		Vector<String> array1 = new Vector<>();
		array1.add("300");
		array1.add("400");
		array1.add("쉽다");
		
		map.put("spring", array);
		map.put("java", array1);
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.print("key : "+key+"\t");
			List<String> list = map.get(key);
			System.out.print("values [ ");
			for(String s : list) {
				System.out.print(s+"  ");
			}
			System.out.println("]");
		}
		
	}

	
}
