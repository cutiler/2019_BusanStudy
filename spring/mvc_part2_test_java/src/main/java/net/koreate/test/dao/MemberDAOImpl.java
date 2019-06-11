package net.koreate.test.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.test.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "net.koreate.mappers.MemberMapper";
	

	@Override
	public void insertMember(MemberVO memberVO) {
		System.out.println(memberVO);
		session.insert(namespace+".insertMember",memberVO);
		System.out.println("삽입 완료");
	}

	@Override
	public MemberVO readMember(String userid) {
		MemberVO member = session.selectOne(namespace+".readMember",userid);
		return member;
	}

	@Override
	public MemberVO reMemberWithPass(String userid, String userpass) {
		/*
		 Map<String,String> memberInfo = new HashMap<>();
		 memberInfo.put("userid",userid);
		 memberInfo.pug("userpass",userpass);
		 MemberVO member = session.selectOne(namespace+".reMemberWithPass",memberInfo);		
		*/
		
		MemberVO member1 = new MemberVO();
		member1.setUserid(userid);
		member1.setUserpw(userpass);		
		
		MemberVO member = session.selectOne(namespace+".reMemberWithPass",member1);
		return member;
	}

	@Override
	public List<MemberVO> readMemberList() {
		List<MemberVO> memberList = session.selectList(namespace+".readMemberList");
		return memberList;
	}

}
