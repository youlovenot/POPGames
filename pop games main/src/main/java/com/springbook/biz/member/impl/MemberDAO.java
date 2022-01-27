package com.springbook.biz.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.member.MemberVO;

// DAO(Data Access Object)
@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	private final String MEMBER_INSERT = "insert into member(id, password, name, phone, email, zipcode, adress1, adress2, role) values(?,?,?,?,?,?,?,?,?)";
	private final String MEMBER_UPDATE = "update member set password=?, name=?, phone=?, email=?, zipcode=?, adress1=?, adress2=?, role=? where id=?";
	private final String MEMBER_DELETE = "delete member where id=?";
	private final String MEMBER_GET = "select * from member where id=? and password=?";
	private final String MEMBER_LIST = "select * from member";
	
	// CRUD 기능의 메소드 구현
	// 로그인
	public MemberVO getMember(MemberVO vo) {
		System.out.println("===> Spring JDBC로 getMember() 기능 처리");
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(MEMBER_GET, args, new MemberRowMapper());
	}
}

class MemberRowMapper implements RowMapper<MemberVO> {
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO member = new MemberVO();
		member.setId(rs.getString("ID"));
		member.setPassword(rs.getString("PASSWORD"));
		member.setName(rs.getString("NAME"));
		member.setPhone(rs.getString("PHONE"));
		member.setEmail(rs.getString("EMAIL"));
		member.setZipcode(rs.getString("ZIPCODE"));
		member.setAdress1(rs.getString("ADRESS1"));
		member.setAdress2(rs.getString("ADRESS2"));
		member.setRole(rs.getString("ROLE"));
		return member;
	}
}
