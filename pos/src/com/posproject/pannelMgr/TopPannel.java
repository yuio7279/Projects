package com.posproject.pannelMgr;

import javax.swing.*;

import java.awt.*;

public class TopPannel extends JPanel {
	public TopPannel() {
		setLayout(new GridLayout(1, 3, 5, 5));
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton buy = new JButton("구매");
		JButton refund = new JButton("영수증");
		JButton logout = new JButton("로그아웃");
		JButton member = new JButton("회원정보");

		PannelBtnAction btn = new PannelBtnAction();

		buy.addActionListener(btn);
		refund.addActionListener(btn);
		logout.addActionListener(btn);
		member.addActionListener(btn);

		buy.setFont(font);
		refund.setFont(font);
		logout.setFont(font);
		member.setFont(font);

		add(buy);
		add(refund);
		add(member);
		add(logout);

	}
}
