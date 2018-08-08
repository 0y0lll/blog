package com.oyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oyo.action.Action;
import com.oyo.dao.MemberDAO;
import com.oyo.dto.MemberVO;

public class MemberAccountAction implements Action {
	private static String naming = "MemberAccountAction : ";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/accountForm.jsp";
	      HttpSession session = request.getSession();
	      MemberVO member = new MemberVO();
	      MemberDAO mdao = new MemberDAO();

	      String id = session.getId();



	}
}
