package com.springbook.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.notice.NoticeService;
import com.springbook.biz.notice.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}

	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}

	public void deleteNotice(NoticeVO vo) {
		noticeDAO.deleteNotice(vo);
	}

	public NoticeVO getNotice(NoticeVO vo) {
		return noticeDAO.getNotice(vo);
	}

	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		return noticeDAO.getNoticeList(vo);
	}
}
