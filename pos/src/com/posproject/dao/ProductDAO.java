package com.posproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.posproject.dto.Product;

public class ProductDAO {

	DAO dao;
	Connection conn;
	String sql;
	private ArrayList<Product> list = new ArrayList<>();

	public ArrayList<Product> getProductTbl() {
		sql = "select * from product";

		dao = new DAO();
		conn = dao.accessDb();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString(1), rs.getInt(2), rs.getInt(3)));
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getCountProductTbl() {
		int products = 0;

		dao = new DAO();
		conn = dao.accessDb();
		sql = "select count(productName) from product where stock !=0 ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				products = rs.getInt("count(productName)");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public int getCountSoldOut() {
		int products = 0;

		dao = new DAO();
		conn = dao.accessDb();
		sql = "select count(productName) from product where stock = 0";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				products = rs.getInt("count(productName)");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public int addProcess(String productName, int stock, int price) {
		sql = "INSERT INTO product (`productName`, `stock`, `price`) VALUES (?, ?, ?)";

		dao = new DAO();
		conn = dao.accessDb();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			pstmt.setInt(2, stock);
			pstmt.setDouble(3, price);
			if (pstmt.executeUpdate() == 1) {
				return 1; // 물건 추가 성공시 1을 리턴하여 내부 텍스트값을 비우기위함
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0; // 물건 추가 실패시
	}

	public int updateProcess(String productName, int stock, int price) { // 등록되어있는 상품명을 찾아 재고량, 가격을 수정하는 메서드

		sql = "UPDATE product SET stock = ?, price = ? WHERE productName = ?";

		dao = new DAO();
		conn = dao.accessDb();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setDouble(2, price);
			pstmt.setString(3, productName);
			if (pstmt.executeUpdate() == 1) {
				return 1; // 물건 추가 성공시 1을 리턴하여 내부 텍스트값을 비우기위함
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0; // 물건 추가 실패시
	}

	public int removeProcess(String productName) {
		sql = "DELETE FROM product where `productName`= ?";

		dao = new DAO();
		conn = dao.accessDb();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			if (pstmt.executeUpdate() == 1) {
				return 1; // 물건 삭제 성공시 1을 리턴하여 내부 텍스트값을 비우기위함
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0; // 물건 삭제 실패시
	}

	public void refund(int id, int stock, String product) {
		int sto = 0;

		dao = new DAO();
		conn = dao.accessDb();
		sql = "UPDATE buytbl SET `buyStock` = '0',`buyPrice` = '0' WHERE (`buyNo` = ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() == 1) {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sql = "SELECT * FROM product where productName = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				sto = rs.getInt(2);
				sto = sto + stock;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sql = "UPDATE product SET `stock` = ? WHERE (`productName` = ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sto);
			pstmt.setString(2, product);
			if (pstmt.executeUpdate() == 1) {
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getManyBuyProduct(String id) { // 계정별 가장 많이 구매한 상품
		sql = "SELECT buyProduct, buyStock FROM buytbl WHERE buyStock = (SELECT max(buyStock) FROM buytbl WHERE buyUser = ?)";

		dao = new DAO();
		conn = dao.accessDb();
		String product = "";
		int stock = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product = rs.getString("buyProduct");
				stock = rs.getInt("buyStock");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (stock == 0) {
			return product = "";
		}
		return product;
	}

	public String allManyBuyProduct() { // 전체내역 중 가장 많이 구매한 상품
		sql = "select buyProduct, sum(buystock) from buytbl group by buyProduct order by sum(buystock) desc limit 1;";

		dao = new DAO();
		conn = dao.accessDb();
		String product = "";
		int stock = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product = rs.getString("buyProduct");
				stock = rs.getInt("sum(buystock)");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (stock == 0) {
			return product = "";
		}
		return product;
	}

	public int allCountManyBuyProduct() { // 전체내역 중 가장 많이 구매한 상품의 수
		sql = "select buyProduct, sum(buystock) from buytbl group by buyProduct order by sum(buystock) desc limit 1;";

		dao = new DAO();
		conn = dao.accessDb();
		int stock = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				stock = rs.getInt("sum(buystock)");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
}
