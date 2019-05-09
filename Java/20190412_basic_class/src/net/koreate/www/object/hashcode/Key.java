package net.koreate.www.object.hashcode;

public class Key {
	
	public int number;
	
	public Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Key) {
			Key k = (Key)obj;
			if(this.number == k.number) {
				return true;
			}
			
		}		
		return false;
	}

	@Override
	public int hashCode() {
						
		return this.number;
	}
	
	
	
	
	

}
