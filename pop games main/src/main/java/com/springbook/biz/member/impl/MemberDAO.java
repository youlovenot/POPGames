package com.springbook.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.member.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember",vo);
	}
	
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember",vo);
	}
	
	public void deleteMember(MemberVO vo) {
		mybatis.delete("MemberDAO.deleteMember",vo);
	}
	
	public MemberVO getMember(MemberVO vo) {
		return (MemberVO)mybatis.selectOne("MemberDAO.getMember",vo);
	}
	
	public List<MemberVO> getMemberList(MemberVO vo) {
		return mybatis.selectList("MemberDAO.getMemberList",vo);
	}
}
