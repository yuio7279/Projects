package com.posproject.dao;

import java.sql.*;

import javax.swing.JOptionPane;

import com.posproject.main.Start;

public class DAO {

	Connection conn = accessDb();

	public Connection accessDb() {
		Connection conn = null;

		// Database 이름 kwaje //
		String url = "jdbc:mysql://localhost/kwaje";
		String id = "root";
		String pw = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
//			System.out.println("연결됨");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Too many connections!");
			System.exit(0);
		} 
		return conn;
	}

	public void closeConn() {
		try {
			conn.close();
			System.out.println("DB접속 해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
