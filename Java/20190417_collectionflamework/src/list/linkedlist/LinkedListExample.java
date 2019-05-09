package list.linkedlist;

import java.util.*;

class Board{
	String subject;
	String context;
	String writer;

	public Board(String subject, String context, String writer) {
		super();
		this.subject = subject;
		this.context = context;
		this.writer = writer;
	}
		
}

public class LinkedListExample {
	
	
	public static void main(String[] args) {
		
		List<Board> array = new ArrayList<>();
		List<Board> linked = new LinkedList<>();
		
		long startTime = 0;
		long endTime = 0;
		int size = 100000;
		
		
		System.out.println("[ 추가 작업 ]");
		startTime = System.nanoTime();
		for(int i=0;i<size;i++) {
			array.add(0,new Board("제목"+i,"내용"+i,"글쓴이"+i));
			
		}
		endTime = System.nanoTime();
		System.out.println("array  추가시간 : "+(endTime - startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int i=0;i<size;i++) {
			linked.add(0,new Board("제목"+i,"내용"+i,"글쓴이"+i));
			
		}
		endTime = System.nanoTime();
		System.out.println("linked 추가시간 : "+(endTime - startTime)+"ns");
		
		System.out.println("[ 검색 작업 ]");
		startTime = System.nanoTime();
		for(int i=0;i<size;i++) {
			array.get(i);
			
		}
		endTime = System.nanoTime();
		System.out.println("array  검색시간 : "+(endTime - startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int i=0;i<size;i++) {
			linked.get(i);
			
		}
		endTime = System.nanoTime();
		System.out.println("linked 검색시간 : "+(endTime - startTime)+"ns");
		
		
		
		
	}

}
