package com.Annis.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Info_connexion
 */
@WebServlet("/Info_connexion")
public class Info_connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession Sconnexion = request.getSession();
		//Sconnexion.setAttribute("id", id);
		//Sconnexion.setAttribute("statut", mdp);		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("username");
		String mdp = req.getParameter("password");
		MySQLConnUtils mysqlconnect = new MySQLConnUtils();
		try {
			 Connection connexion = MySQLConnUtils.getMySQLConnection();
			 DBManager dbmanage = new DBManager();
			 UserAccount user = DBManager.findUser(connexion, id, mdp);
			 if(user != null) {
				 HttpSession Sconnexion = req.getSession();
				 Sconnexion.setAttribute("id", id);
				 Sconnexion.setAttribute("statut", user.getStatut());
			 }
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
