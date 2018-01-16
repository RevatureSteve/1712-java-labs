package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

@WebServlet("/ajaxLoadFooter")
public class AjaxLoadFooterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxLoadFooterServlet -GET");

		ErsUser clientUser = (ErsUser) req.getSession().getAttribute("user");
		if (clientUser == null) return;
		if (clientUser.getRole() == ErsUserRole.EMPLOYEE) {
			req.getRequestDispatcher("features/footer/footer_employee.html").forward(req, resp);
		}
		else if (clientUser.getRole() == ErsUserRole.MANAGER) {
			req.getRequestDispatcher("features/footer/footer_manager.html").forward(req, resp);
		}
	}

}
