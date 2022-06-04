package com.posproject.dao;

import java.sql.*;

import javax.swing.JOptionPane;

import com.posproject.main.Start;

public class DAO {

	Connection conn = accessDb();

	public Connection accessDb() {
		Connection conn = null;

		// Database 이름 posDB //
		String url = "jdbc:mysql://localhost/posDB";
		String id = "root";
		String pw = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
//			System.out.println("연결됨");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}