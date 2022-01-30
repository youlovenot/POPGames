package com.springbook.view.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.notice.NoticeVO;
import com.springbook.biz.notice.impl.NoticeDAO;
import com.springbook.view.controller.Controller;

public class InsertNoticeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");
		
		// 1. 사용자 입력 정보 추출
//		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContent(content);
		
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDAO.insertNotice(vo);
		
		// 3. 화면 네비게이션
		return "getNoticeList.do";
	}

}
