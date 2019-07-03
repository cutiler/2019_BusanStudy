package net.koreate.test.service;

import net.koreate.test.vo.ValidationMemberVO;

public interface MemberService {
	//회원가입
	void memberJoin(ValidationMemberVO vo) throws Exception;
	
	// 아이디로 사용자 정보 확인
	boolean getMemberByID(String u_id) throws Exception;
	
	// 최종 방문일 수정
	void updateVisitDate(String u_id);
}
