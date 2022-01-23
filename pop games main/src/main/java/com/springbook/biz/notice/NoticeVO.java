package com.springbook.biz.notice;

import java.util.Date;

// VO(Value Object)
public class NoticeVO {
	private int seq;
	private String title;
	private String content;
	private Date regDate;
	private int cnt;
	
	// Getter/Setter 메소드
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "UserVO [seq=" + seq + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}

}
