package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901784448217028279L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -GET"); 
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		
		//create a user from the users model 
		ERS_Users clientUser = new ERS_Users();
		
		//ERS_User_Roles roles = null;
		
		//get the parameters from the request
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//place the username and password in the 
		clientUser.setU_username(username);
		clientUser.setU_password(password);
		
		//Validate user through the service layer
		clientUser = AppService.appService.validateUser(clientUser);
		//roles = AppService.appService.validateRole(clientUser);
		
		//print to console serverside
		System.out.println("The user entered " + username + " & " + password);
		
		if(clientUser != null) {

			HttpSession session = req.getSession(); 
			
			session.setAttribute("user", clientUser);//user is a variable name the developer defines
			//clientUser.toString();
			//track role
			//session.setAttribute("role", roles);
//			req.getRequestDispatcher("app.html").forward(req, resp);
			resp.sendRedirect("app.html");
		}else{
			System.err.println("invalid credentials -sending user back to login.html");
			resp.sendRedirect("login.html");
		}
		
	}

}
