package net.koreate.www.object.equals;

public class Member extends Object{

	String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {

		if(o instanceof Member) {
			Member m = (Member)o;
			if(this.id.equals(m.id)) {
				return true;
			}
		}		
		
		return false;
	}
	
 
	
	
	
}
