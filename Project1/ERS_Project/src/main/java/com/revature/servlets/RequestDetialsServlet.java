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

@WebServlet("/requestDetails")
public class RequestDetialsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		
		ERS_User_Roles role = AppService.appService.validateRole(clientUser);
		
		if(role.getUr_role().equals("Employee")) {
			
			req.getRequestDispatcher("features/rRequest/requestdetails.html").forward(req, resp);
			
		} else if (role.getUr_role().equals("Manager")) {
			
			req.getRequestDispatcher("features/rRequest/requestdetailsmanager.html").forward(req, resp);
			
		} else {
			PrintWriter out = resp.getWriter();
			out.println("No view associated with current user role.");
		}
		
		
	}
	
	
}
