package com.springbook.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.member.MemberVO;

// DAO(Data Access Object)
@Repository("memberDAO")
public class MemberDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들
	private final String MEMBER_INSERT = "insert into member(id, password, name, phone, email, zipcode, adress1, adress2) values(?,?,?,?,?,?,?,?)";
	private final String MEMBER_UPDATE = "update member set password=?, name=?, phone=?, email=?, zipcode=?, adress1=?, adress2=? where id=?";
	private final String MEMBER_DELETE = "delete member where id=?";
	private final String MEMBER_GET = "select * from member where id=? and password=?";
	private final String MEMBER_LIST = "select * from member";
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public void insertMember(MemberVO vo) {
		System.out.println("===> JDBC로 insertMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getPhone());
			stmt.setString(5, vo.getEmail());
			stmt.setString(6, vo.getZipcode());
			stmt.setString(7, vo.getAdress1());
			stmt.setString(8, vo.getAdress2());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 수정
	public void updateMember(MemberVO vo) {
		System.out.println("===> JDBC로 updateMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getPhone());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getZipcode());
			stmt.setString(6, vo.getAdress1());
			stmt.setString(7, vo.getAdress2());
			stmt.setString(8, vo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 삭제
	public void deleteMember(MemberVO vo) {
		System.out.println("===> JDBC로 deleteMember() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_DELETE);
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 로그인
	public MemberVO getMember(MemberVO vo) {
		MemberVO member = null;
		try {
			System.out.println("===> JDBC로 getMember() 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setZipcode(rs.getString("ZIPCODE"));
				member.setAdress1(rs.getString("ADRESS1"));
				member.setAdress2(rs.getString("ADRESS2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return member;
	}

	// 회원 상세 조회
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("===> JDBC로 getMemberList() 기능 처리");
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setZipcode(rs.getString("ZIPCODE"));
				member.setAdress1(rs.getString("ADRESS1"));
				member.setAdress2(rs.getString("ADRESS2"));
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return memberList;
	}
}
