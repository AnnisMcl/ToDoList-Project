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
 * Servlet implementation class CreateTaskServlet
 */
@WebServlet(urlPatterns = "/CreateTask")
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/CreateTask.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String id = (String) request.getParameter("Titre");
		 String descriptif = (String) request.getParameter("Descriptif");
		 
		 Task task = new Task(id,descriptif);
		 
		 String errorString = null;
		 
		 if(id == null ) {
			 errorString = "Titre invalide !";
		 }
		 
		 if (errorString == null) {
	            try {
	            	 Connection conn = MySQLConnUtils.getMySQLConnection();
	            	 DBManager.AddTask(conn, id, descriptif);
	            } catch (SQLException e) {
	                e.printStackTrace();
	                errorString = e.getMessage();
	            } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		 
		 request.setAttribute("errorString", errorString);
	     request.setAttribute("task", task);
		 
	     if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/CreateTask.jsp");
	            dispatcher.forward(request, response);
	        }
	     else {
	            response.sendRedirect(request.getContextPath() + "/GetList");
	        }
		 
	     
		
	}

}
