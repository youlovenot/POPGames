package com.springbook.biz.notice.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.notice.NoticeVO;

// DAO(Data Access Object)
@Repository
public class NoticeDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	private final String NOTICE_INSERT = "insert into notice(seq, title, content)" +
										"values((select coalesce(max(seq), 0)+1 from notice N),?,?)";
	private final String NOTICE_UPDATE = "update notice set title=?, content=? where seq=?";
	private final String NOTICE_DELETE = "delete from notice where seq=?";
	private final String NOTICE_GET = "select * from notice where seq=?";
//	private final String NOTICE_LIST = "select * from notice order by seq desc";
	private final String NOTICE_LIST_T = "select * from notice where title like '%'||?||'%' order by seq desc";
	private final String NOTICE_LIST_C = "select * from notice where content like '%'||?||'%' order by seq desc";
	
	// CRUD 기능의 메소드 구현
	// 공지 등록
	public void insertNotice(NoticeVO vo) {
		System.out.println("===> Spring JDBC로 insertNotice() 기능 처리");
		jdbcTemplate.update(NOTICE_INSERT, vo.getTitle(), vo.getContent());
	}
	
	// 공지 수정
	public void updateNotice(NoticeVO vo) {
		System.out.println("===> Spring JDBC로 updateNotice() 기능 처리");
		jdbcTemplate.update(NOTICE_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 공지 삭제
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> Spring JDBC로 deleteNotice() 기능 처리");
		jdbcTemplate.update(NOTICE_DELETE, vo.getSeq());
	}
	
	// 공지 상세 조회
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> Spring JDBC로 getNotice() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(NOTICE_GET, args, new NoticeRowMapper());
	}

	// 공지 목록 조회
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("===> Spring JDBC로 getNoticeList() 기능 처리");
		Object[] args = {vo.getSearchKeyword()};
		if (vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(NOTICE_LIST_T, args, new NoticeRowMapper());
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(NOTICE_LIST_C, args, new NoticeRowMapper());
		}
		return null;
	}
}

class NoticeRowMapper implements RowMapper<NoticeVO> {
	public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeVO notice = new NoticeVO();
		notice.setSeq(rs.getInt("SEQ"));
		notice.setTitle(rs.getString("TITLE"));
		notice.setContent(rs.getString("CONTENT"));
		notice.setRegDate(rs.getDate("REGDATE"));
		notice.setCnt(rs.getInt("CNT"));
		return notice;
	}
}