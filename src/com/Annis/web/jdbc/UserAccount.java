package com.Annis.web.jdbc;

public class UserAccount {
	
	private String userName;
	private String password;
	private String statut;
	
	public UserAccount() {
		
	}
		
	
	
	public UserAccount(String UserName, String Password, String Statut) {
		this.setUserName(UserName);
		this.setPassword(Password);
		this.setStatut(Statut);
	
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
}
