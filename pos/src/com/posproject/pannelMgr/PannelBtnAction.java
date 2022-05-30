package com.posproject.pannelMgr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.posproject.gui.Add;
import com.posproject.gui.Buy;
import com.posproject.gui.LogOut;
import com.posproject.gui.Member;
import com.posproject.gui.Refund;
import com.posproject.gui.Remove;
import com.posproject.gui.SalesRank;
import com.posproject.gui.UserManagement;
import com.posproject.main.Start;
import com.posproject.valid.Valid_user;

public class PannelBtnAction implements ActionListener {
	Valid_user u_valid = new Valid_user();

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton imsi = (JButton) e.getSource();
		Start imsi2 = (Start) imsi.getTopLevelAncestor();
		switch (e.getActionCommand()) {
		case "구매":
			imsi2.viewScreen(new Buy());
			break;
		case "영수증":
			imsi2.viewScreen(new Refund());
			break; // 영수증텝에서 환불가능

		case "로그아웃":
			imsi2.viewScreen(new LogOut());
			imsi2.setVisible(false);
			JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
			break;
		case "회원정보":
			imsi2.viewScreen(new Member());
			break;
		case "물건추가":
			imsi2.viewScreen(new Add());
			break;
		case "물건삭제":
			imsi2.viewScreen(new Remove());
			break;
		case "사용통계":
			imsi2.viewScreen(new SalesRank());
			break;
		case "회원관리":
			imsi2.viewScreen(new UserManagement());
			break;
		}
	}

}