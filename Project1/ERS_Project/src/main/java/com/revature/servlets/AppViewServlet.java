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

@WebServlet("/ajaxAppView")
public class AppViewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		ERS_User_Roles roles = (ERS_User_Roles)AppService.appService.validateRole(clientUser);
		
		System.out.println("Get " + clientUser.toString());
		
		System.out.println(roles.getUr_role());
		
		if(roles != null) {
			if( roles.getUr_role().equals("Employee")) {
				request.getRequestDispatcher("features/appView/employeeview.html").forward(request, response);
			} else if( roles.getUr_role().equals("Manager")) {
				request.getRequestDispatcher("features/appView/managerview.html").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				//response.setContentType("application/json");
				out.println("<p>No view matches user role " + roles.getUr_role() + "</p>");
			}
		}else {
			PrintWriter out = response.getWriter();
			//response.setContentType("application/json");
			out.println("<p>No view matches user role " + roles.getUr_role() + "</p>");
			response.setStatus(403); //check for appropriate status code
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("features/imageSelect/imageselect.html").forward(request, response);
	}
	
	
}
