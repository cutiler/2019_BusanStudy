package queue;

import java.util.LinkedList;
import java.util.Queue;

class Message{
	
	String command;
	String to;
	
	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
	
	
}

public class QueueExample {
	
	public static void main(String[] args) {
		
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("sendMail","최기근"));
		messageQueue.offer(new Message("sendSMS","김태희"));
		messageQueue.offer(new Message("sendKaKaoTalk","한국기술교육전문학교"));
		
		System.out.println(messageQueue.size());
		System.out.println(messageQueue.peek().command);
		System.out.println(messageQueue.size());
		
		while(!messageQueue.isEmpty()) {
			Message m = messageQueue.poll();
			
			switch(m.command) {
			
				case "sendMail":
					System.out.println(m.to+"님께 메일을 보냅니다.");
					break;
				case "sendSMS":
					System.out.println(m.to+"님께 문자를 보냅니다.");
					break;
				case "sendKaKaoTalk":
					System.out.println(m.to+"님께 Kakao 메세지를 보냅니다.");
					break;
			
			
			}
		}
		
	}

}
