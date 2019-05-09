package net.koreate.www.interfacetest;

public class RemoteControlExample {
	
	public static void main(String[] args) {
		
		int maxValue = RemoteControl.MAX_VALUE;
		int minValue = RemoteControl.MIN_VALUE;
		
		RemoteControl tvRemote = new TVRemoteControl();
		RemoteControl airRemote = new AirRemoteControl();
		
		airRemote.turnOn();
		airRemote.setValue(16);
		
		tvRemote.turnOn();
		tvRemote.setValue(174);
		
		airRemote.turnOff();
		tvRemote.turnOff();
		
		RemoteControl smartRemote = new SmartTVRemoteControl();
		smartRemote.turnOn();
		smartRemote.setValue(174);
		
		Searchable smartRemote2 = new SmartTVRemoteControl();
		smartRemote2.search("야구");
		
		if(smartRemote2 instanceof SmartTVRemoteControl) {
			System.out.println(" smartTVRemoteControl타입으로 변환가능");
			SmartTVRemoteControl src = (SmartTVRemoteControl)smartRemote2;
			src.turnOn();
			src.search("축구");
			src.setValue(20);
			src.turnOff();
			
		}
		
	}

}
