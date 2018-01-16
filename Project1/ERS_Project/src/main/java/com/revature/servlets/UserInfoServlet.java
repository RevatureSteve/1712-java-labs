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

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("-GET user info servlet");
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		ERS_User_Roles role = AppService.appService.validateRole(clientUser);
		
		PrintWriter out = resp.getWriter();
		//response.setContentType("application/json");
		//out.println("<p>No view matches user role " + roles.getUr_role() + "</p>");
		
		out.println("<div align=\"left\"><ul class=\"list-group\">"); 
		out.println("<li class=\"list-group-item\">First Name: " + clientUser.getU_firstname() + "</li>");
		out.println("<li class=\"list-group-item\">Last Name: " + clientUser.getU_lastname() + "</li>");
		out.println("<li class=\"list-group-item\">Email: " + clientUser.getU_email() + "</li>");
		out.println("<li class=\"list-group-item\">Role: " + role.getUr_role() + "</li>");
		out.println("</ul>");
		
		
		
		
		//out.println("<br/><br/><form method=\"GET\" action=\"changeInfo\"><input type=\"submit\" value=\"Update\"></input></form>");
		out.println("<br/><br/><button id=\"updateInfoButton\" class=\"btn btn-secondary\">Update</button></div>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
