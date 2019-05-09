package net.koreate.www.generic.generic_type_extends;

import net.koreate.www.generic.multitype.Tv;

public class ParentAndChildExample {
	
	public static void main(String[] args) {
		
		Child<String, String, String> child = new Child<>();
		child.setKind("TV");
		
		Storage<Tv> s = new StorageImpl<>(100);
		s.add(new Tv(), 0);
		Tv t = s.get(0);
		
	}

}
