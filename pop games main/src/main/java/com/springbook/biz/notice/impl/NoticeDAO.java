package com.springbook.biz.notice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.notice.NoticeVO;

// DAO(Data Access Object)
@Repository("boardDAO")
public class NoticeDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
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
		System.out.println("===> JDBC로 insertNotice() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(NOTICE_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 공지 수정
	public void updateNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 updateNotice() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(NOTICE_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3,vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 공지 삭제
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 deleteNotice() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(NOTICE_DELETE);
			stmt.setInt(1,vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 공지 상세 조회
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 getNotice() 기능 처리");
		NoticeVO notice = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(NOTICE_GET);
			stmt.setInt(1,vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				notice = new NoticeVO();
				notice.setSeq(rs.getInt("SEQ"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setContent(rs.getString("CONTENT"));
				notice.setRegDate(rs.getDate("REGDATE"));
				notice.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return notice;
	}

	// 공지 목록 조회
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("===> JDBC로 getNoticeList() 기능 처리");
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(NOTICE_LIST_T);
			} else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(NOTICE_LIST_C);
			}
			stmt.setString(1, vo.getSearchKeyword());
			System.out.println("검색 내용 : " + stmt);
//			stmt = conn.prepareStatement(NOTICE_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				NoticeVO notice = new NoticeVO();
				notice = new NoticeVO();
				notice.setSeq(rs.getInt("SEQ"));
				notice.setTitle(rs.getString("TITLE"));
				notice.setContent(rs.getString("CONTENT"));
				notice.setRegDate(rs.getDate("REGDATE"));
				notice.setCnt(rs.getInt("CNT"));
				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return noticeList;
	}
}
