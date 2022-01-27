package com.springbook.biz.notice;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NoticeServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext	container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 NoticeServiceImpl 객체를 Lookup한다.
		NoticeService noticeService = (NoticeService) container.getBean("noticeService");

		// 3. 공지 등록 기능 테스트
		NoticeVO vo = new NoticeVO();
//		vo.setSeq(100);	// 예외낼때 사용
		vo.setTitle("임시 제목");
		vo.setContent("임시 내용......................................");
		noticeService.insertNotice(vo);
		
		// 4. 공지 목록 검색 기능 테스트
		List<NoticeVO> noticeList = noticeService.getNoticeList(vo);
		for(NoticeVO notice : noticeList) {
			System.out.println("---> " + notice.toString());;
		}
		
		// 5. Spring 컨테이너 종료
		container.close();
	}
	
}
