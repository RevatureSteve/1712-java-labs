package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LogoutServlet -POST");
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.removeAttribute("allReimbursements");
		session.removeAttribute("employees");
		session.removeAttribute("reimbursements");
		session.invalidate();
		resp.sendRedirect("test.html");
//		req.getRequestDispatcher("login.html").forward(req, resp);
	}
}
