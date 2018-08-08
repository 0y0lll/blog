package com.oyo.action;

import com.oyo.controller.member.MemberAccountAction;
import com.oyo.controller.member.MemberJoinAction;
import com.oyo.controller.member.MemberLoginAction;
import com.oyo.controller.member.MemberLogoutAction;

public class ActionFactory {
	private static String naming = "ActionFactory : ";

	// 프로그램 시작시 static으로 띄워버리자
	private static ActionFactory instance = new ActionFactory();

	// 아무나 객체 만들지 못하게 private
	private ActionFactory() {

	}

	public static ActionFactory getInstance() {
		return instance;
	}

	// cmd를 받아 분기시킨다
	public Action getAction(String cmd) {

		// 회원가입
		if (cmd.equals("member_join")) {
			return new MemberJoinAction();
		}
		// 로그인
		else if (cmd.equals("member_login")) {
			return new MemberLoginAction();
		}
		// 로그아웃
		else if (cmd.equals("member_logout")) {
			return new MemberLogoutAction();
		}
		// 회원정보
		else if (cmd.equals("member_account")) {
			return new MemberAccountAction();
		}

		return null;
	}
}
