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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/infoConnexion.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
 
        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
       

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn;
			try {
				conn = MySQLConnUtils.getMySQLConnection();
				user = DBManager.findUser(conn, userName, password);
				 
                if (user == null) {
                    hasError = true;
                    errorString = "User Name or password invalid";
                	}
                } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
                } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
                }
        }
        // Au cas où il y a des erreurs,
        
        if (hasError) {
            user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
 
            // Enregistrer des données dans l'attribut de la demande avant de les transmettre.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward (Transmettre) vers la page /infoConnexion.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/infoConnexion.jsp");
 
            dispatcher.forward(request, response);
        }
        // S'il n'y a pas d'erreur.
        // Enregistre les informations de l'utilisateur dans Session.
       
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);         
            session.setAttribute("statut",MyUtils.getLoginedUser(session).getStatut());
            if (session.getAttribute("statut") == "professeur") {
            	session.setAttribute("condi",1);
            }
            else
            {
            	session.setAttribute("condi",0);
            }
            
            // Si l'utilisateur sélectionne la fonction "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, user);
            }
            // Si non, supprime Cookie
            else {
                MyUtils.deleteUserCookie(response);
            }
 
            
            response.sendRedirect(request.getContextPath() + "/GetList");
        }

	}
}
