package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

@WebServlet("/ajaxLoadManagerReimbursementsView")
public class AjaxLoadManagerReimbursementsViewServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxLoadManagerReimbursementsViewServlet -GET");
		
		HttpSession session = req.getSession();
		ErsUser clientUser = (ErsUser) session.getAttribute("user");
		
		if (clientUser != null && clientUser.getRole() == ErsUserRole.MANAGER) {
			req.getRequestDispatcher("features/manager/view_reimbursements/reimbursements_view.html").forward(req, resp);
		}
		else if (clientUser != null) {
			req.getRequestDispatcher("features/dashboard/dashboard_employee.html").forward(req,  resp);
		}
	}

}
