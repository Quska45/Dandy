/* **********************************************************************************
 * @source: ActionForward.java 
 * @description: Action 인터페이스에서 명령을 수행하고 결과값을 가지고 페이지를 forwarding 할 때 사용하는 클래스
 * **********************************************************************************
 * DATE				AUTHOR				DESCRIPTION
 * ---------------------------------------------------
 * 2018/03/23		고재선				최초작성
 * **********************************************************************************
 *
 */


package com.dandy.action;

public class ActionForward {
	// view page(결과 값을 어디로 넘길지 결정)
	private String path;
	
	// 페이지 이동 2가지 방법(sendRedirect, Froward)
	// true -> sendRedirect, false -> Forward
	private boolean isRedirect;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
