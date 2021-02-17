package com.Annis.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet(urlPatterns="/DeleteTask")
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		 
        String errorString = null;
        
        try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			DBManager.DelTask(conn, id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
        if (errorString != null) {

            request.setAttribute("errorString", errorString); 
            
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/DeleteTask.jsp");
            dispatcher.forward(request, response);
        }
        // S'il n'y a aucun problème.
        // Redirect (réorientez) vers la page de la liste des produits.
        else {
            response.sendRedirect(request.getContextPath() + "/GetList");
        }
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
