package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

@WebServlet("/ajaxDashboard")
public class AjaxDashboardServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1505624419274702790L;

	public AjaxDashboardServlet() {
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxDashboard -GET");
		
		String path = "";
		ErsUser user = (ErsUser) req.getSession().getAttribute("user");
		if (user == null) {
			resp.sendRedirect("login.html");
			return;
		}
		if (user.getRole() == ErsUserRole.EMPLOYEE) path = "features/dashboard/dashboard_employee.html";
		else if (user.getRole() == ErsUserRole.MANAGER) path = "features/dashboard/dashboard_manager.html";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
