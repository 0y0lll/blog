<%@page import="com.oyo.util.Script"%>
<%@page import="com.oyo.util.SHA256"%>
<%@page import="com.oyo.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String url = request.getContextPath() + "/index.jsp";
	MemberDAO mdao = new MemberDAO();
	String id = null;
	if (session.getAttribute("id") != null) {
		id = (String) session.getAttribute("id");
	}

	String code = request.getParameter("code");
	String email = mdao.select_email(id);
	String salt = mdao.select_salt(id);
	String emailHash = SHA256.getEncrypt(email, salt);

	System.out.println("email : " + email);
	System.out.println("code : " + code);
	System.out.println("emailHash : " + emailHash);

	boolean isTrue = emailHash.equals(code) ? true : false;

	if (isTrue) {
		int result = mdao.update_emailcheck(id);
		if (result == 1) {
			Script.moving(response, "인증에 성공하였습니다.", url);
		} else {
			Script.moving(response, "데이터베이스 오류");
		}
	} else {
		Script.moving(response, "인증에 실패하였습니다.");
	}
%>