package com.posproject.valid;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.posproject.dao.BuyDAO;
import com.posproject.dao.UserDAO;
import com.posproject.dto.User;

public class Valid_user {
	UserDAO uDao = new UserDAO();
	BuyDAO bDao = new BuyDAO();

	public String getDiscountMsg(String id) {
		String msg = "";
		int rank = uDao.getRank(id);

		switch (rank) {
		case 1:
			msg = "0%  ( 총 구매액이 높을 수록 등급이 올라갑니다. )";
			break;
		case 2:
			msg = "20%  ( 총 구매액이 높을 수록 등급이 올라갑니다. )";
			break;
		case 3:
			msg = "30% 최고등급입니다!";
			break;
		}
		return msg;
	}

	public String displayRank(String id) {
		int rank = uDao.getRank(id);
		String dis_rank = "";

		switch (rank) {
		case 1:
			dis_rank = "일반";
			break;
		case 2:
			dis_rank = "우수";
			break;
		case 3:
			dis_rank = "VIP";
			break;
		case 0:
			dis_rank = "관리자";
			break;

		}
		return dis_rank;
	}

	public JLabel checkColorRank(JLabel label, int id) {

		switch (id) {
		case 1:
			label.setForeground(Color.BLUE);
			break;
		case 2:
			label.setForeground(Color.ORANGE);
			break;
		case 3:
			label.setForeground(Color.RED);
			break;
		}
		return label;
	}

	public void changeUserRank(User data, String rank, String admin) { // 모든 회원의 등급을 변환

		switch (rank) {
		case "0": {
			data.setRank("SUPER");
			break;
		} // 관리자 계정 DB에는 0으로 출력
		case "1": {
			data.setRank("일반");
			break;
		} // 일반 0%할인 1
		case "2": {
			data.setRank("우수");
			break;
		} // 우수 20%할인 2
		case "3": {
			data.setRank("VIP");
			break;
		} // VIP 30%할인 3
		}
		if (admin.equals("1")) {
			data.setAdmin("관리자");
		} else {
			data.setAdmin("일반계정");
		}
	}

	public int check_Remove(ArrayList<User> list, String userID) { // 계정을 지울 수 있는지 여부
		int r = -1;

		for (User data : list) {
			if (data.getUserID().equals(userID)) // 해당 ID존재여부
			{
				if (data.getAdmin().equals("관리자")) // 관리자계정 여부
				{
					JOptionPane.showMessageDialog(null, "관리자계정은 삭제할 수 없습니다.");
					return r;
				} else {
					int real = JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "Confirm", JOptionPane.YES_NO_OPTION);
					if (real == JOptionPane.NO_OPTION) {
						return r;
					} else if (real == JOptionPane.YES_OPTION) {
						if (uDao.removeUserProcess(userID) == 1) {
							return -r; // 삭제완료
						}
					}
				}
			}
		}
		return r;
	}

	public int rankManager(String id) {

		int rank = uDao.getRank(id);
		long total = Long.parseLong(bDao.getTotalBuyPrice(id));
		if (rank == 1) { // 일반등급
			if (total > 1000000) // 100만 초과시 우수등급
			{
				if(total > 5000000)
				{
					rank = uDao.rankUP(id, rank);
					uDao.rankUP(id, rank);
					return 1;
				}
				uDao.rankUP(id, rank);
				return 1;
			}
		}
		if (rank == 2) {

			if (total > 5000000) { // 500만 초과시 vip
				uDao.rankUP(id, rank);
				return 1;
			} else if (1000000 <= total && total <= 5000000) {
				// 그냥두기
			} else if (1000000 > total) { // 100만 미만시 일반등급
				uDao.rankDown(id, rank);
				return 1;
			}
		}
		if (rank == 3) { // 500만 미만시 우수
			if (total <= 5000000) {
				if(total <= 1000000)
				{
					rank = uDao.rankDown(id, rank);
					uDao.rankDown(id, rank);
					return 1;
				}
				else {
				uDao.rankDown(id, rank);
				return 1;
				}
			}
		}
		return -1;
	}

}