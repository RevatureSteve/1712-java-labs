package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2604736801510564352L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LogoutServlet -GET"); 
		
		this.doPost(req, resp);
		//HttpSession session = req.getSession(); 
		
		//session.setAttribute("user", null);//user is a variable name the developer defines
		//session.setAttribute("role", null);
		//req.getRequestDispatcher("login.html").forward(req, resp);
		//resp.sendRedirect("login.html");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LogoutServlet -POST");
		HttpSession session = req.getSession(); 
		
		session.setAttribute("user", null);//user is a variable name the developer defines
		//session.setAttribute("role", null);
		//req.getRequestDispatcher("login.html").forward(req, resp);
		resp.sendRedirect("login.html");
	}
}
