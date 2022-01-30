package com.springbook.view.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.notice.NoticeVO;
import com.springbook.biz.notice.impl.NoticeDAO;
import com.springbook.view.controller.Controller;

public class GetNoticeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		// 1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		NoticeVO vo = new NoticeVO();
		vo.setSeq(Integer.parseInt(seq));
		
		NoticeDAO noticeDAO = new NoticeDAO();
		NoticeVO notice = noticeDAO.getNotice(vo);
		
		// 3. 검색 결과를 세션에 저장하고 상세 화면을 리턴
		HttpSession session = request.getSession();
		session.setAttribute("notice", notice);
		return "getNotice";
	}
	
}
