package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/filterView")
public class FilterViewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		ERS_User_Roles role = AppService.appService.validateRole(clientUser);
		
		if(role.getUr_role().equals("Manager")) {
			req.getRequestDispatcher("features/history/filtermanager.html").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("features/history/filter.html").forward(req, resp);
		}
	}

}
