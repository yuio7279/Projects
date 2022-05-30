package com.posproject.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;

import com.posproject.dao.UserDAO;
import com.posproject.main.Start;
import com.posproject.pannelMgr.AdminTopPannel;
import com.posproject.pannelMgr.TopPannel;

public class Gaip extends JFrame {
	TopPannel top = new TopPannel();
	AdminTopPannel topAdmin = new AdminTopPannel();
	UserDAO uDao = new UserDAO();
	JTextField idTf;
	JTextField pwTf;
	Container c;
	JFrame main;

	public Gaip() {

		setBackground(Color.white);
		setTitle("포스 매니저");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		c = getContentPane();
		JPanel add_pn = new JPanel();
		addPanel(add_pn);
		add(add_pn);
		setVisible(true);


	}

	// 회원용 가입패널
	public JPanel addPanel(JPanel panel) {
		setLayout(null);
		this.setBackground(Color.white);
		Font font = new Font("SansSerif", Font.BOLD, 20);
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		idTf = new JTextField(40);
		pwTf = new JTextField(40);

		JButton gaip = new JButton("가입완료");
		JButton back = new JButton("돌아가기");

		id.setFont(font);
		pw.setFont(font);
		gaip.setFont(font);
		back.setFont(font);

		id.setBounds(240, 190, 100, 100);
		pw.setBounds(240, 220, 100, 100);
		idTf.setBounds(350, 225, 250, 30);
		pwTf.setBounds(350, 255, 250, 30);
		gaip.setBounds(260, 370, 150, 50);
		back.setBounds(420, 370, 150, 50);

		// 이벤트리스너 연결 //

		gaip.addActionListener((e) -> {

			if (uDao.gaipProcess(idTf.getText(), pwTf.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "회원 가입이 완료 되었습니다.");
				new Start();
				dispose();		//화면안보이게하는 메서드, 자원까지 반납
			}
		}); // 회원가입액션

		back.addActionListener((e) -> {
			new Start();
			dispose();
		});
		// 애드

		add(id);
		add(pw);
		add(idTf);
		add(pwTf);
		add(gaip);
		add(back);

		JLabel imsi = new JLabel("SIGN UP");
		imsi.setFont(font);
		imsi.setBounds(300, 120, 500, 50);
		add(imsi);
		JLabel imsi_img = new JLabel(new ImageIcon("./resource/image/referral.png"));
		imsi_img.setBounds(240,120,50,50);
		add(imsi_img);
		return panel;
	}
}