package com.posproject.valid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.posproject.dao.DAO;

public class Valid_buy {

	public int buyCheck(String buyCnt) {
		int r = -1;

		if (!Pattern.matches("^[0-9]{1,20}$", buyCnt)) {
			JOptionPane.showMessageDialog(null, "올바른 구매 개수를 입력하세요");
			return r;
		}
		return -r;
	}

	public int addCheck(String product, String stock, String price) {
		int r = -1;

		if (!Pattern.matches("^[a-zA-Z0-9가-힣]{1,50}$", product)) {
			JOptionPane.showMessageDialog(null, "올바른 상품명을 입력하세요");
			return r;
		}

		if (!Pattern.matches("^[0-9]{1,50}$", stock)) {
			JOptionPane.showMessageDialog(null, "올바른 재고량을 입력하세요");
			return r;
		}
		if (!Pattern.matches("^[0-9]{1,50}$", price)) {
			JOptionPane.showMessageDialog(null, "올바른 가격을 입력하세요");
			return r;
		}
		return -r;
	}

	public int validProduct(String productName) {
		int r = -1;
		try {
			Connection conn = new DAO().accessDb();
			String sql = "select productName from product where productName = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // data가 존재한다면 -1리턴
				return r;
			}

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -r; // 데이터가 없다면 1리턴
	}
}
