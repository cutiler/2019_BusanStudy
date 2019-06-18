package net.koreate.lombok;

import java.util.ArrayList;

import org.junit.Test;

import lombok.extern.java.Log;

@Log
public class LombokTest {
	
	@Test
	public void testLombok() {
		UserVO user = new UserVO();
		user.setUid("id001");
		user.setUpw("pw0001");
		
		System.out.println(user.getUid()+" / "+user.getUpw());
		System.out.println(user);
		log.info(user.toString());
		log.warning(user.toString());
		
		ArrayList<String> list = new ArrayList<>();
		list.add("이순신");
		list.add("홍길동");
		UserVO user1 = UserVO.builder()
				.uid("id001")
				.upw("pw001")
				.uname("최기근")
				.friendList(list)
				.list("심사임당")
				.list("강감찬")
				.list("류성룡")
				.uno(1)
				.build();
		
		log.info(user1.toString());
	}

}
