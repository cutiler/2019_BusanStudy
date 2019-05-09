package list.vector;

import java.util.*;

public class VectorExample {
	
	public static void main(String[] args) {
		
		int size = 1000000;
		long startTime = 0;
		long endTime = 0;
		
		List<String> vec = new Vector<String>();
		List<String> array = new ArrayList<String>();
		
		System.out.println("[데이터 추가 테스트]");
		startTime = System.nanoTime();
		for(int i=0; i< size; i++) {
			array.add(0, i+" ");
		}
		
		
		
		endTime = System.nanoTime();
		System.out.println("Array  추가 작업 시간 : "+(endTime - startTime)+"ns");

		
		startTime = System.nanoTime();
		for(int i=0; i< size; i++) {
			vec.add(0, i+" ");
		}
		
		endTime = System.nanoTime();
		System.out.println("Vector 추가 작업 시간 : "+(endTime - startTime)+"ns");
		
		System.out.println("[검색 작업시간 비교]");
		
		startTime = System.nanoTime();
		for(int i=0; i< size; i++) {
			array.get(i);
		}
		
		endTime = System.nanoTime();
		System.out.println("Array  검색 작업 시간 : "+(endTime - startTime)+"ns");

		
		startTime = System.nanoTime();
		for(int i=0; i< size; i++) {
			vec.get(i);
		}
		
		endTime = System.nanoTime();
		System.out.println("Vector 검색 작업 시간 : "+(endTime - startTime)+"ns");
		
		
		
	}

}
