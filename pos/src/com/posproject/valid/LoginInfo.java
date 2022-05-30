package com.posproject.valid;

import javax.swing.*;

import com.posproject.dao.DAO;
import com.posproject.dao.UserDAO;

public class LoginInfo extends JPanel {
	UserDAO uDao = new UserDAO();
	Valid_user u_valid = new Valid_user();

	// 로그인시 해당 계정이 관리자인지, 일반계정인지 판별
	public LoginInfo(int isAdmin, String id) {

		setSize(300, 50);
		if (isAdmin == 1) {
			JLabel welcome = new JLabel("환영합니다 관리자모드입니다.");
			welcome.setSize(200, 50);
			add(welcome);
		}

		else if (isAdmin == 0) {

			JLabel welcome = new JLabel(id + "님의 방문을 환영합니다.");
			JLabel welcome2 = new JLabel(id + "님은 [ " + u_valid.displayRank(id) + " ] 등급 입니다.");
			welcome.setSize(200, 50);
			welcome2.setSize(200, 50);
			add(welcome);
			add(welcome2);
		}
	}
} 