package nestedinterface;

//import nestedinterface.Button.OnClickListener;

public class ButtonExample {
	
	public static void main(String[] args) {
		
				
		Button button1 = new Button();
		button1.setOnClickListener(new CallListener());
		button1.onTouch();
		
		Button button2 = new Button();
		button2.setOnClickListener(new MessageListener());
		button2.onTouch();
		
		
		Button button  = new Button();
		Button.OnClickListener clickListener = new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("메시지 전송!");	
			}
		};
		button.setOnClickListener(clickListener);
		button.onTouch();
		
		
		Button button5  = new Button();
		button5.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("메시지 전송!");	
			}
		});
		button5.onTouch();
		
		
		
		Button button3 = new Button();
		button3.setOnClickListener(()->System.out.println("람다식으로 호출"));
		button3.onTouch();
		
		
		
		
		
		
		
		
		
	}

}
