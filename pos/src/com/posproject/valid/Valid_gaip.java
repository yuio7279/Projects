package com.posproject.valid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.posproject.dao.DAO;

public class Valid_gaip {

	public int gaipCheck(String id, String password) {

		int r = -1;

		if (!Pattern.matches("^[a-zA-Z0-9가-힣]{1,20}$", id)) {
			JOptionPane.showMessageDialog(null, "아이디는 영문, 숫자, 한글로 입력해주세요");
			return r;
		}
		if (!Pattern.matches("^[a-zA-Z0-9]{1,20}$", password)) {
			JOptionPane.showMessageDialog(null, "비밀번호는 영문, 숫자로 입력해주세요");
			return r;
		}

		if (dupCheck(id) == -1) {
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
			return r;
		}

		return -r;
	}

	public int dupCheck(String id) {
		int r = -1;
		try {
			Connection conn = new DAO().accessDb();
			String sql = "select id from user where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // data가 존재한다면
				return r;
			}

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -r;
	}
}
