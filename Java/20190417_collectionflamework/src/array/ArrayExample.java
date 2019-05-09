package array;

public class ArrayExample<E> {
	
	private int capacity = 10;
	
	private E[]  array;
	
	private int length=0;
	
	public ArrayExample() {
		array = (E[])(new Object[capacity]);
	}
	
	public ArrayExample(int capacity) {
		this.capacity = capacity;
		array = (E[])(new Object[this.capacity]);
		
	} //ArrayExample end
	
	public void add(E e) {
		E[] newArray = this.array;
		if(length  >= capacity) {
			newArray = (E[])(new Object[array.length+1]);
			System.arraycopy(array, 0, newArray, 0, array.length);
			newArray[array.length] = e;
			length++;
		}else {
			for(int i=0; i < newArray.length; i++) {
				if(newArray[i] == null) {
					newArray[i] = e;
					length++;
					break;
				}
			}
		}
		this.array = newArray;		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(E e: array) {
			sb.append(e);
		}
		sb.append("]");
		return sb.toString();
	}
	
	public int size() {
		return this.length;
	}
	
	public void remove(E e) {
		E[] newArray = this.array;
		for(int i=0; i<array.length; i++) {
			if(array[i].equals(e)) {
				newArray = (E[])(new Object[array.length-1]);
				
				for(int j=0; j < newArray.length; j++) {
					if(j < i) {
						newArray[j] = array[j];
					}else {
						newArray[j] = array[j+1];
					}
					
				}
				length--;
				break;
			}
			
		}
		this.array = newArray;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String[] strs = new String[5];
		strs[0] = "최기근";
		strs[1] = "홍길동";
		strs[2] = "이순신";
		strs[3] = "신사임당";
		strs[4] = "세종대왕";
		
		String[] strs2 = new String[strs.length+1];
		for(int i=0; i<strs.length; i++) {
			strs2[i] = strs[i];
			
		}		
		
		strs2[5] = "유관순";
		
		strs2[0] = null;
		for(String s: strs2) {
			System.out.println(s);
		}
	
		// ArrayExample
		ArrayExample<String> array = new ArrayExample<>(3);
		
		array.add("최기근");
		array.add("홍길동");
		array.add("유관순");
		array.add("이순신");
		array.add("최기근");
		
		System.out.println(array.size());
		System.out.println(array);
		
		array.remove("최기근");
		
		System.out.println(array.size());
		System.out.println(array);
		
		
		
		
		
		
	}

}
