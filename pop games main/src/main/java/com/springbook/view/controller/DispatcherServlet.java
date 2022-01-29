package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.member.MemberVO;
import com.springbook.biz.member.impl.MemberDAO;
import com.springbook.biz.notice.NoticeVO;
import com.springbook.biz.notice.impl.NoticeDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 클라이언트의 요청 path에 따라 적절히 분기처리 한다.
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB 연동 처리
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPassword(password);
			
			MemberDAO memberDAO = new MemberDAO();
			MemberVO member = memberDAO.getMember(vo);

			// 3. 화면 네비게이션
			if(member != null){
				response.sendRedirect("getNoticeList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");

			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
			HttpSession session = request.getSession();
			session.invalidate();
			// 2. 세션 종료 후, 메인 화면으로 이동한다.
			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/insertNotice.do")) {
			System.out.println("공지 등록 처리");
			
			// 1. 사용자 입력 정보 추출
//			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			NoticeVO vo = new NoticeVO();
			vo.setTitle(title);
			vo.setContent(content);
			
			NoticeDAO noticeDAO = new NoticeDAO();
			noticeDAO.insertNotice(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getNoticeList.do");
			
		} else if (path.equals("/updateNotice.do")) {
			System.out.println("공지 수정 처리");
			
			// 1. 사용자 입력 정보 추출
//			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			NoticeVO vo = new NoticeVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			NoticeDAO noticeDAO = new NoticeDAO();
			noticeDAO.updateNotice(vo);

			// 3. 화면 네비게이션
			response.sendRedirect("getNoticeList.do");
			
		} else if (path.equals("/deleteNotice.do")) {
			System.out.println("공지 삭제 처리");

			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			NoticeVO vo = new NoticeVO();
			vo.setSeq(Integer.parseInt(seq));
			NoticeDAO noticeDAO = new NoticeDAO();
			noticeDAO.deleteNotice(vo);

			// 3. 화면 네비게이션
			response.sendRedirect("getNoticeList.do");
			
		} else if (path.equals("/getNotice.do")) {
			System.out.println("공지 상세 조회 처리");
			
			// 1. 검색할 게시글 번호 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			NoticeVO vo = new NoticeVO();
			vo.setSeq(Integer.parseInt(seq));
			
			NoticeDAO noticeDAO = new NoticeDAO();
			NoticeVO notice = noticeDAO.getNotice(vo);
			
			// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("notice", notice);
			response.sendRedirect("getNotice.jsp");
			
		} else if (path.equals("/getNoticeList.do")) {
			System.out.println("공지 목록 검색 처리");
			
			// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
			// 2. DB 연동 처리
			NoticeVO vo = new NoticeVO();
			NoticeDAO noticeDAO = new NoticeDAO();
			List<NoticeVO> noticeList = noticeDAO.getNoticeList(vo);
			
			// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("noticeList", noticeList);
			response.sendRedirect("getNoticeList.jsp");
			
		}
	}

}
