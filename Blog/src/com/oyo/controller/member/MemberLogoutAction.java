package com.oyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oyo.action.Action;
import com.oyo.util.Script;

public class MemberLogoutAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";

		HttpSession session = request.getSession();
		session.invalidate();

		Script.moving(response, "다음에 또 봐요!", url);
	}
}
