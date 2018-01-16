package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/changeInfo")
public class ChangeUserInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//super.doGet(req, resp);
				
				System.out.println("-GET user info change servlet");
				HttpSession session = req.getSession();
				ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
				ERS_User_Roles role = AppService.appService.validateRole(clientUser);
				
				PrintWriter out = resp.getWriter();
				//response.setContentType("application/json");
				//out.println("<p>No view matches user role " + roles.getUr_role() + "</p>");
				
				
				out.println("<br/><br/><form method=\"POST\" align=\"left\" action=\"changeInfo\"><br/>");
				out.println("First Name:");
				out.println("<input type=\"text\"   class=\"form-control\"  value=\"" + clientUser.getU_firstname() + "\" name = \"firstname\"><br/>");
				out.println("Last Name:");
				out.println("<input type=\"text\"   class=\"form-control\"  value=\"" + clientUser.getU_lastname() + "\" name = \"lastname\"><br/>");
				out.println("Email:");
				out.println("<input type=\"text\"   class=\"form-control\"  value=\"" + clientUser.getU_email() + "\" name = \"email\"><br/>");
				out.println("Password:");
				out.println("<input type=\"password\"   class=\"form-control\"  value=\"" + clientUser.getU_password() + "\" name = \"password\"><br/>");
				out.println("<input type=\"submit\" align = \"left\" value=\"Update\" class=\"btn btn-secondary\"></input></form><br/>");
				
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		System.out.println("LoginServlet -POST");
		//BankUser clientUser = new BankUser();
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		clientUser.setU_firstname(firstname);
		clientUser.setU_lastname(lastname);
		clientUser.setU_email(email);
		clientUser.setU_password(pass);
		
		clientUser = AppService.appService.validateUserUpdate(clientUser);
		
		if(clientUser != null)
		{
			session.setAttribute("user", clientUser);//user is a variable name the developer defines
			
			resp.sendRedirect("app.html");
		}
		else
		{
			req.getRequestDispatcher("userInfo").forward(req, resp);
			System.out.println("failed to update user");
		}
	}

}
