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

@WebServlet("/ajaxNavbar")
public class AjaxNavbarServlet extends HttpServlet {
	
	public AjaxNavbarServlet() {
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxNavBar -GET");
		
		HttpSession session = req.getSession();
		ErsUser user = (ErsUser) session.getAttribute("user");
		if (user == null) return;
		
		System.out.println(user);
		
		String path = "";
		if (user.getRole() == ErsUserRole.EMPLOYEE) path = "features/navbar/navbar_employee.html";
		else if (user.getRole() == ErsUserRole.MANAGER) path = "features/navbar/navbar_manager.html";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
