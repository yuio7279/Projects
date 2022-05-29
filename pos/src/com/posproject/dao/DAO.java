package com.posproject.dao;

import java.sql.*;
import java.util.ArrayList;

import com.posproject.dto.Buy;
import com.posproject.dto.Product;
import com.posproject.dto.User;

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
			e.printStackTrace();
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
