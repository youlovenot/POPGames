package com.springbook.view.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.notice.NoticeVO;
import com.springbook.biz.notice.impl.NoticeDAO;
import com.springbook.view.controller.Controller;

public class GetNoticeListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리
		NoticeVO vo = new NoticeVO();
		NoticeDAO noticeDAO = new NoticeDAO();
		List<NoticeVO> noticeList = noticeDAO.getNoticeList(vo);
		
		// 3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다.
		HttpSession session = request.getSession();
		session.setAttribute("noticeList", noticeList);
		return "getNoticeList";
	}

}
