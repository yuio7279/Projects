package com.posproject.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.posproject.dao.BuyDAO;
import com.posproject.dao.ProductDAO;
import com.posproject.dao.UserDAO;
import com.posproject.process.LoginUser;
import com.posproject.valid.Valid_buy;
import com.posproject.valid.Valid_user;

public class SalesRank extends JPanel {
	JScrollPane scroll;
	JTextField[] jtf;
	ProductDAO pDao = new ProductDAO();
	BuyDAO bDao = new BuyDAO();
	UserDAO uDao = new UserDAO();
	Valid_buy valid = new Valid_buy();
	Valid_user u_valid = new Valid_user();

	public SalesRank() {
		if (u_valid.rankManager(LoginUser.id) == 1) {
			JOptionPane.showMessageDialog(null, "등급이 변경되었습니다. 해당등급에 따른 할인율을 적용받습니다.");
		}
		setLayout(null);
		addPanel(this);
	}

	public JPanel addPanel(JPanel panel) {

		Font font = new Font("SansSerif", Font.BOLD, 20);
		Font font2 = new Font("SansSerif", Font.PLAIN, 15);

		JPanel info_pn = new JPanel();
		info_pn.setBorder(new TitledBorder(null, "사용통계", TitledBorder.LEADING, TitledBorder.TOP, font, null));

		info_pn.setLayout(null);

		JLabel info_pn_id = new JLabel("회원 수 : ");
		JLabel info_pn_id2 = new JLabel(String.valueOf(uDao.getCountMember())+"명");

		JLabel info_pn_dis = new JLabel("진열된 상품 수 : ");
		JLabel info_pn_dis2 = new JLabel(String.valueOf(pDao.getCountProductTbl())+"개");

		JLabel info_pn_sold = new JLabel("품절된 상품 수 : ");
		JLabel info_pn_sold2 = new JLabel(String.valueOf(pDao.getCountSoldOut())+"개");

		JLabel info_pn_many = new JLabel("가장 많이 팔린 상품 수 : ");
		JLabel info_pn_many2 = new JLabel(String.valueOf(pDao.allCountManyBuyProduct())+"개");
		JLabel info_pn_many3 = new JLabel("[ " + pDao.allManyBuyProduct() + " ]");

		JLabel info_pn_tt = new JLabel("총 매출 액 : ");
		JLabel info_pn_tt2 = new JLabel(String.valueOf(bDao.getTotalBuyPrice())+"원");

		info_pn_id.setBounds(50, 60, 150, 30);
		info_pn_id2.setBounds(250, 60, 300, 30);
		info_pn_dis.setBounds(50, 120, 150, 30);
		info_pn_dis2.setBounds(250, 120, 100, 30);
		info_pn_sold.setBounds(50, 180, 500, 30);
		info_pn_sold2.setBounds(250, 180, 500, 30);
		info_pn_many.setBounds(50, 240, 250, 30);
		info_pn_many2.setBounds(250, 240, 300, 30);
		info_pn_many3.setBounds(350, 240, 300, 30);
		info_pn_tt.setBounds(50, 300, 150, 30);
		info_pn_tt2.setBounds(250, 300, 300, 30);

		info_pn_id.setFont(font2);
		info_pn_id2.setFont(font2);
		info_pn_dis.setFont(font2);
		info_pn_dis2.setFont(font2);
		info_pn_sold.setFont(font2);
		info_pn_sold2.setFont(font2);
		info_pn_many.setFont(font2);
		info_pn_many2.setFont(font2);
		info_pn_many3.setFont(font2);
		info_pn_tt.setFont(font2);
		info_pn_tt2.setFont(font2);

		info_pn.add(info_pn_id);
		info_pn.add(info_pn_id2);
		info_pn.add(info_pn_dis);
		info_pn.add(info_pn_dis2);
		info_pn.add(info_pn_sold);
		info_pn.add(info_pn_sold2);
		info_pn.add(info_pn_many);
		info_pn.add(info_pn_many2);
		info_pn.add(info_pn_many3);
		info_pn.add(info_pn_tt);
		info_pn.add(info_pn_tt2);

		JButton chartBtn = new JButton("매출 순위 차트");
		chartBtn.addActionListener((e) -> {
			new Charts();

		});

		info_pn.setFont(font);
		info_pn.setBounds(20, 30, 730, 400);
		chartBtn.setBounds(650, 490, 100, 25);

		panel.add(info_pn);
		panel.add(chartBtn);

		return panel;
	}

}