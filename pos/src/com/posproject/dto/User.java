package com.posproject.dto;

public class User {

	String userID;
	String userPass;
	String admin;
	String rank;

	public User(String userID, String userPass, String admin, String rank) {
		super();
		this.userID = userID;
		this.userPass = userPass;
		this.admin = admin;
		this.rank = rank;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}