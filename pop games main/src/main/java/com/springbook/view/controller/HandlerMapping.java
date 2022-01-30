package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.member.LoginController;
import com.springbook.view.member.LogoutController;
import com.springbook.view.notice.DeleteNoticeController;
import com.springbook.view.notice.GetNoticeController;
import com.springbook.view.notice.GetNoticeListController;
import com.springbook.view.notice.InsertNoticeController;
import com.springbook.view.notice.UpdateNoticeController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getNoticeList.do", new GetNoticeListController());
		mappings.put("/getNotice.do", new GetNoticeController());
		mappings.put("/insertNotice.do", new InsertNoticeController());
		mappings.put("/updateNotice.do", new UpdateNoticeController());
		mappings.put("/deleteNotice.do", new DeleteNoticeController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
