package com.posproject.pannelMgr;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.posproject.gui.Add;
import com.posproject.gui.Buy;
import com.posproject.gui.LogOut;
import com.posproject.gui.Refund;
import com.posproject.gui.Remove;
import com.posproject.gui.SalesRank;
import com.posproject.gui.UserManagement;
import com.posproject.main.Start;

public class AdminTopPannel extends JPanel {
	public AdminTopPannel() {

		setLayout(new GridLayout(1, 3, 5, 5));
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JButton addProduct = new JButton("물건추가");
		JButton delProduct = new JButton("물건삭제");
		JButton ranking = new JButton("매출순위");
		JButton logout = new JButton("로그아웃");
		JButton member = new JButton("회원관리");
		addProduct.setFont(font);
		delProduct.setFont(font);
		ranking.setFont(font);
		member.setFont(font);
		logout.setFont(font);

		PannelBtnAction btn = new PannelBtnAction();
		addProduct.addActionListener(btn);
		delProduct.addActionListener(btn);
		ranking.addActionListener(btn);
		logout.addActionListener(btn);
		member.addActionListener(btn);

		add(addProduct);
		add(delProduct);
		add(ranking);
		add(member);
		add(logout);

	}

}
