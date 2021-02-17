package com.Annis.web.jdbc;

import java.awt.desktop.SystemEventListener;
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
 * Servlet implementation class EditTaskServlet
 */
@WebServlet(urlPatterns = "/EditTask")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		  System.out.println("EditGet");
		 
        Task task = null;
 
        String errorString = null;
 
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
        	task = DBManager.findTask(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (errorString != null && task == null) {
            response.sendRedirect(request.getServletPath() + "/GetList");
            return;
        }
        
        request.setAttribute("errorString",errorString);
        request.setAttribute("task",task);
        
        
        	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditTask.jsp");
        	dispatcher.forward(request, response);
                   
        
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("Titre");
        String descriptif = (String) request.getParameter("Descriptif");
        System.out.println("EditPost");
        
        Task task = new Task(id, descriptif);
        
        String errorString = null;
        
        try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			DBManager.EditTask(conn, id, descriptif);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", task);
        
        
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/List.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/GetList");
        }
                     
	}

}
