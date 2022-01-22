package com.springbook.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	public MemberVO getMember(MemberVO vo) {
		return memberDAO.getMember(vo);
	}

	public List<MemberVO> getMemberList(MemberVO vo) {
		return memberDAO.getMemberList(vo);
	}
}
