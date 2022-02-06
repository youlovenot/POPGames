package com.springbook.biz.notice.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springbook.biz.notice.NoticeVO;

// DAO(Data Access Object)
@Repository
public class NoticeDAOJPA {
	@PersistenceContext
	private EntityManager em;

	public void insertNotice(NoticeVO vo) {
		System.out.println("===> JPA로 insertNotice() 기능 처리");
		em.persist(vo);
	}
	
	public void updateNotice(NoticeVO vo) {
		System.out.println("===> JPA로 updateNotice() 기능 처리");
		em.merge(vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> JPA로 deleteNotice() 기능 처리");
		em.remove(em.find(NoticeVO.class, vo.getSeq()));
	}
	
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> JPA로 getNotice() 기능 처리");
		return (NoticeVO) em.find(NoticeVO.class, vo.getSeq());
	}
	
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("===> JPA로 getNoticeList() 기능 처리");
		return em.createQuery("from NoticeVO n order by n.seq desc").getResultList();
	}
}
