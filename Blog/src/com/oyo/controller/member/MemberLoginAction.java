package com.oyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oyo.action.Action;
import com.oyo.dao.MemberDAO;
import com.oyo.dto.MemberVO;
import com.oyo.util.SHA256;
import com.oyo.util.Script;

public class MemberLoginAction implements Action {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";

		HttpSession session = request.getSession();
		MemberVO member = new MemberVO();
		MemberDAO mdao = new MemberDAO();

		String id = null;
		String password = null;

		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}

		String salt = mdao.select_salt(id);

		if (request.getParameter("password") != null) {
			password = request.getParameter("password");
			password = SHA256.getEncrypt(password, salt);
		}

		int result = mdao.user_check(id, password);

		if (result == 1) {
			session.setAttribute("id", id);
			Script.moving(response, "로그인에 성공했습니다.", url);
		} else if (result == -1) {
			Script.moving(response, "아이디 또는 비밀번호를 확인하세요.");
		} else if (result == 2) {
			Script.moving(response, "가입 정보가 없습니다.");
		}

	}
}
