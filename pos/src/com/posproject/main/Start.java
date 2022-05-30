package com.posproject.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.posproject.dao.UserDAO;
import com.posproject.gui.Gaip;
import com.posproject.pannelMgr.AdminTopPannel;
import com.posproject.pannelMgr.TopPannel;
import com.posproject.process.LoginUser;
import com.posproject.valid.LoginInfo;

public class Start extends JFrame {

	TopPannel top = new TopPannel();
	AdminTopPannel topAdmin = new AdminTopPannel();

	UserDAO uDao = new UserDAO();
	JTextField idTf;
	JTextField pwTf;
	public Container c = getContentPane();
	int isAdmin = -1;

	public Start() {
		setTitle("포스 매니저");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);


		c = getContentPane();
		viewScreen(new Login());
		setVisible(true);
	}

	// 실행시 맨 처음나오는 로그인화면 패널 //
	public class Login extends JPanel {
		public Login() {
			setLayout(null);

			setBackground(Color.white);
			Font font = new Font("SansSerif", Font.BOLD, 20);
			JLabel id = new JLabel("아이디");
			JLabel pw = new JLabel("비밀번호");
			idTf = new JTextField(40);
			pwTf = new JTextField(40);
			JButton login = new JButton("로그인");
			JButton gaip = new JButton("회원가입");
			JButton exit = new JButton("종료");

			id.setFont(font);
			pw.setFont(font);
			login.setFont(font);
			gaip.setFont(font);
			exit.setFont(font);

			id.setBounds(240, 190, 100, 100);
			pw.setBounds(240, 220, 100, 100);
			idTf.setBounds(350, 225, 250, 30);
			pwTf.setBounds(350, 255, 250, 30);
			login.setBounds(200, 370, 150, 50);
			gaip.setBounds(350, 370, 150, 50);
			exit.setBounds(500, 370, 150, 50);

			// 이벤트리스너 연결 //
			LoginButton loginBtn = new LoginButton();
			login.addActionListener(loginBtn);
			gaip.addActionListener(loginBtn);
			exit.addActionListener(loginBtn);

			// 애드

			add(id);
			add(pw);
			add(idTf);
			add(pwTf);
			add(login);
			add(gaip);
			add(exit);


			JLabel imsi = new JLabel("POS MANAGER");
			imsi.setFont(font);
			imsi.setBounds(300, 120, 500, 50);
			add(imsi);
			JLabel imsi_img = new JLabel(new ImageIcon("./resource/image/accountant.png"));

			imsi_img.setBounds(240,120,50,50);

			add(imsi_img);

		}
	}	

	public void viewScreen(JPanel p) { // 패널과 컨테이너 교체
		c.removeAll();
		c.add(p);
		if (isAdmin == 0) {
			c.add(top, BorderLayout.NORTH);
		} else if (isAdmin == 1) {
			c.add(topAdmin, BorderLayout.NORTH);
		}
		c.revalidate();
	}

	// 이벤트 처리
	class LoginButton implements ActionListener {
		String id, pw;

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton imsi = (JButton) e.getSource();
			if (imsi.getText().equals("종료")) {
				System.exit(0);
			} else if (imsi.getText().equals("로그인")) {
				id = idTf.getText();
				pw = pwTf.getText();

				isAdmin = uDao.login(id, pw);
				if (isAdmin == 0) {
					LoginUser.id = id;
					viewScreen(new LoginInfo(isAdmin, id));
				} else if (isAdmin == 1) {
					LoginUser.id = id;
					viewScreen(new LoginInfo(isAdmin, id));
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다.");
				}

			} else if (imsi.getText().equals("회원가입")) {
				new Gaip();
				setVisible(false);
			}
		}
	}

	public static void main(String[] args) {
		try {
			  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			new Start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}