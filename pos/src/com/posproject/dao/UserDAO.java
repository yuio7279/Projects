package com.posproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.posproject.dto.User;
import com.posproject.valid.Valid_gaip;

public class UserDAO {

	String sql;
	String userId;
	DAO dao;
	Valid_gaip valid = new Valid_gaip();
	Connection conn;

	private ArrayList<User> u_List = new ArrayList<>();

	public int login(String id, String pw) {
		sql = "SELECT * FROM user where id = ?";
		dao = new DAO();
		conn = dao.accessDb();
		int isAdmin = -1;
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (pw.equals(rs.getString(2))) {
					userId = rs.getString(1);
					isAdmin = rs.getInt(3);
					return isAdmin;
				}
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
		return isAdmin;
	}

	public int getCountMember() {
		int members = 0;
		dao = new DAO();
		conn = dao.accessDb();
		sql = "select count(id) from user";
		try {
			conn = dao.accessDb();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				members = rs.getInt("count(id)");
			}

			conn.close();
			pstmt.close();
		} catch (SQLException e) {
		} catch (NullPointerException e) {
		}
		return members;
	}

	public int getRank(String id) {
		sql = "select * from user where id = ?";
		dao = new DAO();
		conn = dao.accessDb();
		int rank = -1;
		try {
			conn = dao.accessDb();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				rank = rs.getInt(4);
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
		} catch (NullPointerException e) {
		}
		return rank;
	}

	public ArrayList<User> getUserTbl() {
		sql = "select * from user";
		dao = new DAO();
		conn = dao.accessDb();
		try {
			conn = dao.accessDb();
			Connection conn = dao.accessDb();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				u_List.add(
						new User(rs.getString("id"), rs.getString("pw"), rs.getString("admin"), rs.getString("rank")));
			}
			conn.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u_List;
	}

	// ???????????? ????????? ???????????? ?????? ????????? //
	public int removeUserProcess(String UserID) {
		sql = "DELETE FROM user where id = ?";
		dao = new DAO();
		conn = dao.accessDb();
		try {
			conn = dao.accessDb();
			Connection conn = dao.accessDb();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserID);
			if (pstmt.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "?????? ?????? ??????.");
				return 1; // ?????? ?????? ????????? 1??? ???????????? ?????? ??????????????? ???????????????
			}

			else {
				JOptionPane.showMessageDialog(null, "????????? ????????? ???????????????..");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; // ?????? ?????? ?????????
	}

	// ?????? ???
	public int rankUP(String id, int rank) {
		sql = "UPDATE user SET `rank` = ? WHERE id = ?";
		dao = new DAO();
		conn = dao.accessDb();
		try {
			conn = dao.accessDb();
			rank = rank + 1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rank);
			pstmt.setString(2, id);
			if (pstmt.executeUpdate() == 1) {
				return rank;
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rank;
	}

	// ?????? ??????
	public int rankDown(String id, int rank) {
		sql = "UPDATE user SET `rank` = ? WHERE id = ?";
		dao = new DAO();
		conn = dao.accessDb();
		try {
			conn = dao.accessDb();
			rank = rank - 1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rank); // ??????????????? ???????????? ???????????????.
			pstmt.setString(2, id);
			if (pstmt.executeUpdate() == 1) {
				return rank;
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rank;
	}

	// ????????????
	public int gaipProcess(String id, String password) {
		sql = "INSERT INTO user VALUES (?, ?, 0, 1)";
		dao = new DAO();
		conn = dao.accessDb();
		try {
			conn = dao.accessDb();
			if (valid.gaipCheck(id, password) == 1) {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				if (pstmt.executeUpdate() == 1) {
					return 1;
				}
				conn.close();
				pstmt.close();
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}