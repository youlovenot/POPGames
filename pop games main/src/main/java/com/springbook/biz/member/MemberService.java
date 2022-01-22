package com.springbook.biz.member;

import java.util.List;

public interface MemberService {

	// CRUD 기능의 메소드 구현
	// 회원 등록
	void insertMember(MemberVO vo);

	// 회원 수정
	void updateMember(MemberVO vo);

	// 회원 탈퇴
	void deleteMember(MemberVO vo);

	// 회원 조회
	MemberVO getMember(MemberVO vo);

	// 회원 목록 조회
	List<MemberVO> getMemberList(MemberVO vo);
	
}
