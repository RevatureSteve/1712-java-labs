package com.revature.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;
import com.revature.service.AppServiceImpl;

@WebServlet("/ajaxAccountUpdate")
public class AjaxAccountUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxAccountUpdateServlet -GET");
		req.getRequestDispatcher("features/update_account/account_update.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxAccountUpdateServlet -POST");
		
		Map<String, String[]> myMap = req.getParameterMap();
		Set<String> reObject = myMap.keySet();
		Object obj = reObject.toArray()[0];
		ObjectMapper jackson = new ObjectMapper();
		
		ErsUser user = jackson.readValue(((String) obj), ErsUser.class);
		
		HttpSession session = req.getSession();
		ErsUser sessionUser = (ErsUser) session.getAttribute("user");
		sessionUser.setUsername(user.getUsername());
		sessionUser.setFirstname(user.getFirstname());
		sessionUser.setLastname(user.getLastname());
		sessionUser.setEmail(user.getEmail());
		session.setAttribute("user", sessionUser);
		
		AppServiceImpl.getService().updateUserInfo(sessionUser);
		
		String path = "";
		if (sessionUser.getRole() == ErsUserRole.EMPLOYEE) req.getRequestDispatcher("features/dashboard/dashboard_employee.html").forward(req, resp);
		else if (sessionUser.getRole() == ErsUserRole.MANAGER) req.getRequestDispatcher("features/dashboard/dashboard_manager.html").forward(req, resp);

	}

}
