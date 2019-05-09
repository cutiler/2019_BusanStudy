package map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
	
	public static void main(String[] args) {
		
		// key String, value Integer
		Map<String,Integer> map = new HashMap();
		map.put("최기근", 100);
		map.put("박준현",80);
		map.put("김태민", 50);
		map.put("최기근", 90);
		
		
		System.out.println(map.size());
		System.out.println(map.get("최기근"));
		
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entry = entrySet.iterator();
		while(entry.hasNext()) {
			Map.Entry<String, Integer> ent = entry.next();
			if(ent.getKey().equals("김태민")) {
				entry.remove();
				ent = null;
			}			
			if(ent != null) {
			
				System.out.println("key : "+ent.getKey());
				System.out.println("value : "+ent.getValue());
			}
		}
		
		System.out.println("=============================================");
		Set<String> key = map.keySet();
		Iterator<String> keyIterator = key.iterator();
		while(keyIterator.hasNext()) {
			String k = keyIterator.next();
			int value = map.get(k);
			System.out.println("key : "+ k + "\t value : "+ value);
		}
		
		map.remove("박준현");

		System.out.println("=============================================");
		
		Set<String> keySet = map.keySet();
		for(String s : keySet) {
			System.out.println("key : "+s+"\t value : "+map.get(s));
		}		
		
		
		
		
		
		
		
		
		
	}

}
