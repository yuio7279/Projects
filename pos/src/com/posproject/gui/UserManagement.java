package com.posproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.posproject.dao.UserDAO;
import com.posproject.dto.User;
import com.posproject.main.Start;
import com.posproject.valid.Valid_user;

public class UserManagement extends JPanel {

	private ArrayList<User> list;
	JScrollPane scroll;
	private Vector<String> tableTitle;
	private DefaultTableModel model;
	private JTable table;
	JTextField[] jtf;
	UserDAO uDao = new UserDAO();
	Valid_user u_valid = new Valid_user();

	public UserManagement() {
		setLayout(new BorderLayout());
		addPanel(this);
		AddTblScroll show = new AddTblScroll();
		add(show, BorderLayout.CENTER);

	}
//	//	회원삭제버튼	//

	public JPanel addPanel(JPanel panel) {

		JPanel add_pn = new JPanel();
		JLabel name_la = new JLabel("삭제하실 회원ID : ");
		JTextField name_tx = new JTextField(12);

		add_pn.add(name_la);
		add_pn.add(name_tx);

		JButton removeBtn = new JButton("회원 삭제하기");
		add_pn.add(removeBtn);
		removeBtn.addActionListener((e) -> {
			list = uDao.getUserTbl();
			if (u_valid.check_Remove(list, name_tx.getText()) == 1) {
				name_tx.setText("");
			}
			JButton imsi = (JButton) e.getSource();
			Start imsi2 = (Start) imsi.getTopLevelAncestor();
			imsi2.viewScreen(new UserManagement());
		});

		panel.add(add_pn, BorderLayout.SOUTH);

		return panel;
	}

	class AddTblScroll extends JPanel {
		AddTblScroll() {
			setLayout(new GridLayout(1, 1));
			list = uDao.getUserTbl();
			setBackground(Color.BLACK);
			tableTitle = new Vector<String>();
			tableTitle.addElement("회원ID");
			tableTitle.add("비밀번호");
			tableTitle.add("계정권한");
			tableTitle.add("회원등급");
			model = new DefaultTableModel(tableTitle, 0);
			table = new JTable(model);

			table.getColumnModel().getColumn(3).setCellRenderer(null);

			table.getColumnModel().getColumn(3).setCellEditor(null);

			scroll = new JScrollPane(table);

			for (User data : list) {

				String rank = data.getRank();
				String admin = data.getAdmin();
				u_valid.changeUserRank(data, rank, admin);

				Vector<String> imsi = new Vector<String>();
				imsi.add(data.getUserID());
				imsi.add(data.getUserPass());
				imsi.add(data.getAdmin());
				imsi.add(data.getRank());
				model.addRow(imsi);
			}

			add(scroll);
		}
	}

}
