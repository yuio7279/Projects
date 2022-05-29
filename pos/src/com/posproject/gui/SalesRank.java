package com.posproject.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.posproject.dao.BuyDAO;
import com.posproject.dao.ProductDAO;
import com.posproject.dao.UserDAO;
import com.posproject.main.Start;
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
		if(u_valid.rankManager(LoginUser.id)==1) {
			JOptionPane.showMessageDialog(null, "등급이 변경되었습니다. 해당등급에 따른 할인율을 적용받습니다.");
		}
		setLayout(null);
		addPanel(this);
	}

	public JPanel addPanel(JPanel panel) {

		Font font = new Font("바탕체", Font.BOLD, 20);

		JPanel info_pn = new JPanel();
		info_pn.setBorder(new TitledBorder(null, "회원정보", TitledBorder.LEADING, TitledBorder.TOP, font, null));
		JPanel info_pn2 = new JPanel();
		info_pn2.setBorder(new TitledBorder(null, "구매정보", TitledBorder.LEADING, TitledBorder.TOP, font, null));
		info_pn.setLayout(null);
		info_pn2.setLayout(null);

		// --회원정보
		JLabel info_pn_id = new JLabel("회원 ID : ");
		JLabel info_pn_id2 = new JLabel(LoginUser.id);

		JLabel info_pn_rank = new JLabel("회원 등급 : ");
		JLabel info_pn_rank2 = new JLabel("[ " + u_valid.displayRank(LoginUser.id) + " ] 등급");
		u_valid.checkColorRank(info_pn_rank2, uDao.getRank(LoginUser.id));
		JLabel info_pn_rank3 = new JLabel("적용된 할인율 : " + u_valid.getDiscountMsg(LoginUser.id));
		info_pn_rank3.setForeground(Color.DARK_GRAY);

		// 구매정보
		JLabel info_pn2_many = new JLabel("가장 많이 구매했던 상품 : ");
		JLabel info_pn2_many2 = new JLabel(pDao.getManyBuyProduct(LoginUser.id));

		JLabel info_pn2_tp = new JLabel("총 구매 액 : ");
		JLabel info_pn2_tp2 = new JLabel(bDao.getTotalBuyPrice(LoginUser.id) + "원");

		info_pn_id.setBounds(50, 60, 150, 30);
		info_pn_id2.setBounds(250, 60, 300, 30);

		info_pn_rank.setBounds(50, 120, 150, 30);
		info_pn_rank2.setBounds(250, 120, 100, 30);
		info_pn_rank3.setBounds(350, 120, 500, 30);

		info_pn2_many.setBounds(50, 60, 150, 30);
		info_pn2_many2.setBounds(250, 60, 300, 30);

		info_pn2_tp.setBounds(50, 120, 150, 30);
		info_pn2_tp2.setBounds(250, 120, 300, 30);

		info_pn.add(info_pn_id);
		info_pn.add(info_pn_id2);
		info_pn.add(info_pn_rank);
		info_pn.add(info_pn_rank2);
		info_pn.add(info_pn_rank3);

		info_pn2.add(info_pn2_many);
		info_pn2.add(info_pn2_many2);
		info_pn2.add(info_pn2_tp);
		info_pn2.add(info_pn2_tp2);

		JButton removeBtn = new JButton("차트로 보기");
		removeBtn.addActionListener((e) -> {
				Chart chart = new Chart();
				
			}
		);

		info_pn.setFont(font);
		info_pn2.setFont(font);
		info_pn.setBounds(20, 30, 730, 200);
		info_pn2.setBounds(20, 250, 730, 200);
		removeBtn.setBounds(650, 490, 100, 25);

		panel.add(info_pn);
		panel.add(info_pn2);
		panel.add(removeBtn);

//		panel.add(add_pn, BorderLayout.NORTH);

		return panel;
	}

}
