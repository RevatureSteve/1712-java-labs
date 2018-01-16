package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/registerEmployee")
public class RegisterEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("features/employees/addemployee.html").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ERS_Users newUser = new ERS_Users();
		
		newUser.setU_firstname((String)req.getParameter("fname"));
		newUser.setU_lastname((String)req.getParameter("lname"));
		newUser.setU_email((String)req.getParameter("email"));
		newUser.setU_username((String)req.getParameter("uname"));
		newUser.setU_password((String)req.getParameter("pword"));
		
		boolean success = AppService.appService.registerEmployee(newUser);
		
		if(success) {
			resp.sendRedirect("app.html");
		}
		else
		{
			resp.sendRedirect("app.html");
		}
	}
	
}
