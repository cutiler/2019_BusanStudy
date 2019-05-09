package net.koreate.www.classtest;

public class Calcurator {
	
	int x, y, result;
	
	int plus(int x, int y) {
		
		return x+y;
		
	}
	
	int minus(int i, int j) {
		x = i;
		y = j;
		result = x - y;
		return result;
		
	}
	
	int multiply(int x, int y) {
		this.x = x;
		this.y = y;
		this.result = x*y;
		return this.result;
		
	}
	
	double divide(int x, int y) {
		return (double)x/y;
		
	}
	
	void setX(int x) {
		this.x = x;
		
	}
	
	void setY(int y) {
		this.y = y;		
	}
	
	int plus() {
		return x+y;
	}
	int minus() {

		return x-y;
	}
	int multiply() {
		return x*y;
	}
	double divide() {
		return (double)x/y;		
	}
}
