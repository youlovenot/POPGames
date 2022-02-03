package com.springbook.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.member.MemberVO;

// DAO(Data Access Object)
@Repository("memberDAO")
public class MemberDAO{
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들
	private final String MEMBER_GET = "select * from member where id=? and password=?";
	
	// CRUD 기능의 메소드 구현
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
			JDBCUtil.close(rs,stmt,conn);
		}
		return member;
	}
}
