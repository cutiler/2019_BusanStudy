package net.koreate.www.generic.generic_mothod2;

public class Util {
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean ValueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && ValueCompare;
		
	}

}
