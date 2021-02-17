package com.Annis.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet(urlPatterns = {"/GetList"})
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection conn = MyUtils.getStoredConnection(request);
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Task> list = null;
		String errorString = null;
		//System.out.println("ouioui");
		try {
			list = DBManager.queryList(conn);
			//System.out.println(list);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		request.setAttribute("List", list);
		request.setAttribute("errorString", errorString);

		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/List.jsp");
	      dispatcher.forward(request, response);
	       
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
