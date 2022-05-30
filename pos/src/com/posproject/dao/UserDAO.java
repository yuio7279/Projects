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

	String sql = "";
	String userId = "";
	DAO dao = new DAO();
	Valid_gaip valid = new Valid_gaip();
	Connection conn = dao.accessDb();

	private ArrayList<User> u_List = new ArrayList<>();

	public int login(String id, String pw) {
		sql = "SELECT * FROM user where id = ?";
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
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
		return isAdmin;
	}

	public int getCountMember() {
		int members = 0;
		sql = "select count(id) from user";
		try {
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
		int rank = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				rank = rs.getInt(4);
			}

		} catch (SQLException e) {
		} catch (NullPointerException e) {
		}
		return rank;
	}

	public ArrayList<User> getUserTbl() {
		sql = "select * from user";
		try {
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

	// 회원관리 텝에서 회원삭제 버튼 클릭시 //
	public int removeUserProcess(String UserID) {
		sql = "DELETE FROM user where id = ?";
		try {
			Connection conn = dao.accessDb();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserID);
			if (pstmt.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "회원 삭제 완료.");
				return 1; // 회원 삭제 성공시 1을 리턴하여 내부 텍스트값을 비우기위함
			}

			else {
				JOptionPane.showMessageDialog(null, "계정을 지우지 못했습니다..");
			}
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; // 회원 삭제 실패시
	}

	// 등급 업
	public int rankUP(String id, int rank) {
		sql = "UPDATE user SET `rank` = ? WHERE id = ?";
		try {
			rank = rank + 1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rank);
			pstmt.setString(2, id);
			if (pstmt.executeUpdate() == 1) {
				return rank;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rank;
	}

	// 등급 다운
	public int rankDown(String id, int rank) {
		sql = "UPDATE user SET `rank` = ? WHERE id = ?";
		try {
			rank = rank - 1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rank); // 우수인경우 환불하면 일반이된다.
			pstmt.setString(2, id);
			if (pstmt.executeUpdate() == 1) {
				return rank;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rank;
	}

	// 회원가입
	public int gaipProcess(String id, String password) {
		sql = "INSERT INTO user VALUES (?, ?, 0, 1)";
		try {
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