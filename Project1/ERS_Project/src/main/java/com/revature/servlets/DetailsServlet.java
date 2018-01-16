package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ReimbursementFullDTO;
import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		
		ERS_Reimbursements rmbtses = AppService.appService.getReimbursementById(Integer.parseInt((String)req.getParameter("r_id")));
		
		session.setAttribute("reimbursement", rmbtses);
		
		ReimbursementFullDTO rmbt = 
				AppService.appService.getReimbursementDetailsById(
						Integer.parseInt((String)req.getParameter("r_id")), clientUser);
		
		
		
		ObjectMapper jackson = new ObjectMapper();
		String json = jackson.writeValueAsString(rmbt);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);
		
	}

}
