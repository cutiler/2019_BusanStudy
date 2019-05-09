package net.koreate.www.interfacetest;

public interface RemoteControl {

	public final static int MAX_VALUE = 10;
	int MIN_VALUE = 0;
	
	public abstract void turnOn();
	public abstract void turnOff();
	void setValue(int value);
	
}
