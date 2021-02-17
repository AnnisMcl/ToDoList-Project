package com.Annis.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager{
	
	public static UserAccount findUser(Connection conn,// 
			String userName, String password) throws SQLException{
		String sql="SELECT * FROM users WHERE id = '"+ userName+ "' AND mdp = '" + password + "';";
		
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		if(rs.next()) {
			String username = rs.getString("id");
	        String mdp = rs.getString("mdp");
	        String statut = rs.getString("statut");
			UserAccount user = new UserAccount(username,mdp,statut);
			return user;
		}
		else {
			return null;//Quand on vérifiera la connexion -> si user == null -> mdp incorrect
		}
			
			
	}
	
	public static UserAccount justFindUser(Connection conn, String userName)throws SQLException{
String sql="SELECT * FROM users WHERE id = '"+ userName+ "';";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		if(rs.next()) {
			String username = rs.getString("id");
	        String mdp = rs.getString("mdp");
	        String statut = rs.getString("statut");
			UserAccount user = new UserAccount(username,mdp,statut);
			return user;
		}
		else {
			return null;//Quand on vérifiera la connexion -> si user == null -> mdp incorrect
		}
	}
	
	public static List<Task> queryList(Connection conn) throws SQLException{
		
		String sql = "SELECT * FROM tasks;";
		Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Task> list = new ArrayList<Task>();
        System.out.println("tonyl e bossss");
        while(rs.next()) {
        	list.add(new Task(rs.getString("id"), rs.getString("descriptif")));
        	System.out.println(rs.getString("id"));
        	//System.out.println(rs.getString("descriptif"));
        }
        return list;
	}
	
	public static void  AddTask(Connection conn,String id, String descriptif) throws SQLException {

        String sql = "INSERT INTO tasks VALUES ('"+id+"','"+descriptif+"');";
        Statement stm = conn.createStatement();
        int numberOfRow = stm.executeUpdate(sql);


    }
    public static void DelTask(Connection conn,String id) throws SQLException {

        String sql = "DELETE FROM tasks WHERE id='" + id +"';";
        Statement stm = conn.createStatement();
        int numberOfRow = stm.executeUpdate(sql);


    }
    public static void EditTask(Connection conn, String id, String descriptif) throws SQLException {

        String sql = "UPDATE tasks SET descriptif ='"+descriptif+"' WHERE id='"+ id +"';";
        Statement stm = conn.createStatement();
        int numberOfRow = stm.executeUpdate(sql);


    }
    
    public static Task findTask(Connection conn, String id) throws SQLException {
    	
    	String sql = "SELECT * FROM tasks WHERE id='" + id +"';";
    	Statement stm = conn.createStatement();
    	ResultSet rs = stm.executeQuery(sql);
    	
    	if(rs.next()) {
			String titre = rs.getString("id");
	        String descriptif = rs.getString("descriptif");
	        Task task = new Task(titre, descriptif);
			return task;
		}
		else {
			return null;
		}
    }


}
