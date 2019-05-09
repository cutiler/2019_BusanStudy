package net.koreate.www.object.hashcode;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		
		Key key1 = new Key(1);
		Key key2 = new Key(2);
		Key key3 = new Key(1);
	
		
		boolean isEquals = key1.equals(key2);
		System.out.println("key1 : key2 = "+isEquals);
		
		isEquals = key1.equals(key3);
		System.out.println("key1 : key3 = "+isEquals);
		
		// 여기서 부터는 경고
		
		HashMap<Key,String> map = new HashMap<>();
		map.put(key1, "홍길동");
		map.put(key3, "최기근");
		
		// hashCode() 재정의해서 주소값이 아닌 Key.Number 값을 반환.
		
		String value1 = map.get(key1);
		String value3 = map.get(key3);
		
		System.out.println(value1);
		System.out.println(value3);
		
	}

}
