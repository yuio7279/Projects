package com.posproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.posproject.dto.Buy;
import com.posproject.process.LoginUser;

public class BuyDAO {

	DAO dao = new DAO();
	UserDAO uDao = new UserDAO();
	Connection conn = dao.accessDb();
	String sql = "";
	String userId = "";
	private ArrayList<Buy> buyList = new ArrayList<>();

	public ArrayList<Buy> getBuyTbl(String id) {
		sql = "SELECT * FROM buytbl where buyUser = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				buyList.add(new Buy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
		}
		catch (NullPointerException e) {
		}
		return buyList;
	}

	public void buyProcess(String id, String product, int amount, Double price, int stock) {
		sql = "INSERT INTO buytbl (`buyUser`, `buyProduct`, `buyStock`, `buyPrice`) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, product);
			pstmt.setInt(3, amount);
			pstmt.setDouble(4, price);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("정상업로드");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "UPDATE product SET `stock` = ? WHERE (`productName` =?)";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setString(2, product);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("스톡처리도 정상");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTotalBuyPrice(String id) {

		sql = "select sum(buyPrice) from buytbl where buyUser = ?  group by buyUser";
		long price = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				price = rs.getLong("sum(buyPrice)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}

		return String.valueOf(price);
	}

}
