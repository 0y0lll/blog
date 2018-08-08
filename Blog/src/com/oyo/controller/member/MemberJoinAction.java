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

public class MemberJoinAction implements Action {
	private static String naming = "MemberJoinAction : ";

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "gmail/emailSendAction.jsp";
	      HttpSession session = request.getSession();
	      MemberVO member = new MemberVO();
	      MemberDAO mdao = new MemberDAO();

	      String id = null;
	      String password = null;
	      String username = null;
	      String email = null;
	      String salt = SHA256.generateSalt();

	      if(session.getAttribute("id") != null) {
	         id = (String)session.getAttribute("id");
	      }

	      if(request.getParameter("id") != null) {
	         id = request.getParameter("id");
	      }

	      if(request.getParameter("password") != null ){
	         password = request.getParameter("password");
	         //패스워드를 SHA256으로 해쉬하기
	         password = SHA256.getEncrypt(password, salt);
	         System.out.println(password.length());
	      }

	      if(request.getParameter("username") != null ){
	         username = request.getParameter("username");
	      }

	      if(request.getParameter("email") != null ){
	         email = request.getParameter("email");
	      }

	      member.setId(id);
	      member.setPassword(password);
	      member.setUsername(username);
	      member.setEmail(email);
	      member.setSalt(salt);

	      int result = mdao.insert(member);

	      if(result == 1) {
	         session = request.getSession();
	         session.setAttribute("id", member.getId());
	         Script.moving(response, "회원가입 성공", url);
	      } else if(result == -1) {
	         Script.moving(response, "데이터베이스 에러");
	      }
	}
}
