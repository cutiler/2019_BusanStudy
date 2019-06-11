package net.koreate.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.test.dao.MemberDAO;
import net.koreate.test.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MemberDAOTest {
	
	@Inject
	MemberDAO dao;
	
/*	@Test
	public void testInsertMember() {
		MemberVO member = new MemberVO();
		member.setUserid("user03");
		member.setUserpw("user03");
		member.setUsername("user03");
		dao.insertMember(member);
	}
	*/
	
	@Test
	public void readMember() {
		MemberVO member1 = dao.readMember("user01");
		System.out.println("readMember : "+member1);
		System.out.println("Member List");
		List<MemberVO> memberList = dao.readMemberList();
		for(MemberVO member : memberList) {
			System.out.println(member);
		}
		
		member1 = dao.reMemberWithPass("user02", "user02");
		
		System.out.println("reMemberWith : "+member1);
		
	}

}
