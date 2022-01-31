package com.springbook.view.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.notice.NoticeVO;
import com.springbook.biz.notice.impl.NoticeDAO;

@Controller
public class NoticeController {
	// 글 등록
	@RequestMapping(value="/test/insertNotice.do")
	public String insertNotice(NoticeVO vo, NoticeDAO noticeDAO) {
		noticeDAO.insertNotice(vo);
		return "redirect:getNoticeList.do";
	}
	
	// 글 수정
	@RequestMapping("/test/updateNotice.do")
	public String updateNotice(NoticeVO vo, NoticeDAO noticeDAO) {
		noticeDAO.updateNotice(vo);
		return "redirect:getNoticeList.do";
	}
	
	// 글 삭제
	@RequestMapping("/test/deleteNotice.do")
	public String deleteNotice(NoticeVO vo, NoticeDAO noticeDAO) {
		noticeDAO.deleteNotice(vo);
		return "redirect:getNoticeList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/test/getNotice.do")
	public String getNotice(NoticeVO vo, NoticeDAO noticeDAO, Model model) {
		model.addAttribute("notice", noticeDAO.getNotice(vo));		// Model 정보 저장
		return "getNotice.jsp";		// View 이름 리턴
	}
	
	//글 목록 검색
	@RequestMapping("/test/getNoticeList.do")
	public String getNoticeList(
			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			NoticeDAO noticeDAO, Model model) {
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);
		// Model 정보 저장
//		model.addAttribute("noticeList", noticeDAO.getNoticeList(vo));
		return "getNoticeList.jsp";		// View 이름 리턴
	}
}
