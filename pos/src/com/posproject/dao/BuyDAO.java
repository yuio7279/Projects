package com.posproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.posproject.dto.Buy;

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
			}conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTotalBuyPrice(String id) {		//계정별 총 구매 액

		sql = "select sum(buyPrice) from buytbl where buyUser = ?  group by buyUser";
		long price = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				price = rs.getLong("sum(buyPrice)");
			}conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}

		return String.valueOf(price);
	}

	public Long getTotalBuyPrice() {		//전체 내역 총 구매 액

		sql = "select sum(buyPrice) from buytbl";
		long price = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				price = rs.getLong("sum(buyPrice)");
			}conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}

		return price;
	}

	public double[] get5BestSell() {			//판매 상위 5품목의 수량
		double[] stock = {0,0,0,0,0};
		int i=0;
		sql = "select buyProduct, sum(buystock) from buytbl group by buyProduct order by sum(buystock) desc limit 5;"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getDouble("sum(buyStock)") == 0)
				{
					stock[i] = 0;
					i++;
				}
				else {
				stock[i] = rs.getDouble("sum(buyStock)");
						i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
		return stock;
	}

	public String[] get5BestSell_p() {			//판매 상위 5품목의 상품명
		String[] products = {"X","X","X","X","X"};
		int i=0;
		sql = "select buyProduct, sum(buystock) from buytbl group by buyProduct order by sum(buystock) desc limit 5;"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("buyProduct").equals(null))
				{
					products[i] = "X";
					i++;
				}
				else {
				products[i] = rs.getString("buyProduct");
						i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
		return products;
	}
}