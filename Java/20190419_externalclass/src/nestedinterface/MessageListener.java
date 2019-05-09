package nestedinterface;

public class MessageListener implements Button.OnClickListener{

	@Override
	public void onClick() {
		System.out.println("메세지를 전달 합니다!");
		
	}

	
}
