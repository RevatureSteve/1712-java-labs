package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

@WebServlet("/ajaxReimbursements")
public class AjaxReimbursementsServlet extends HttpServlet {
	
	public AjaxReimbursementsServlet() {
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxReimbursementsServlet -GET");
		
		ErsUser clientUser = (ErsUser) req.getSession().getAttribute("user");
		if (clientUser.getRole() == ErsUserRole.EMPLOYEE) {
			req.getRequestDispatcher("features/employee/view_reimbursements/reimbursements_view.html").forward(req, resp);
		}
		else if (clientUser.getRole() == ErsUserRole.MANAGER) {
			req.getRequestDispatcher("features/dashboard/dashboard_manager.html").forward(req, resp);
		}
	}

}
