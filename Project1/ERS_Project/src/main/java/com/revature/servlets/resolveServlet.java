package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ERS_Reimbursement_Status;
import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/resolve")
public class resolveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ERS_Reimbursement_Status> statuses = new ArrayList<>();
		statuses = AppService.appService.getStatuses();
		
		String[] statusStrings = new String[statuses.size()];
		ObjectMapper jackson = new ObjectMapper();
		int i = 0;
		for(ERS_Reimbursement_Status s : statuses) {
			statusStrings[i] = jackson.writeValueAsString(s);
			i++;
		}
		
		String json = jackson.writeValueAsString(statusStrings);
		
		System.out.println("resolve servlet -get");
		System.out.println(json);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		
		int resolverId = clientUser.getU_id();
		
		int r_id = Integer.parseInt((String)req.getParameter("r_id"));
		
		int rs_id = Integer.parseInt((String)req.getParameter("resolveSelect"));
		
		ERS_Reimbursements rmbt = AppService.appService.getReimbursementById(r_id);
		rmbt.setRt_status(rs_id);
		rmbt.setU_id_resolver(resolverId);
		
		boolean success = AppService.appService.resolveReimbursement(rmbt);
		
		System.out.println("resolved: " + success);
		resp.sendRedirect("app.html");
		
	}

}
