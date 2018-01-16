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
import com.revature.dto.ReimbursementBasicDTO;
import com.revature.model.ERS_Reimbursement_Status;
import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		//List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		List<ReimbursementBasicDTO> dto = new ArrayList<>();
		List<ReimbursementBasicDTO> dtoReturn = new ArrayList<>();
		
		ERS_User_Roles role = AppService.appService.validateRole(clientUser);
		
		//List<ERS_Reimbursement_Status> statuses = new ArrayList<>();
		
		System.out.println("Filter: " + req.getParameter("f"));
		System.out.println("Filter Id: " + req.getParameter("uid"));
		System.out.println("User Role: " + role.getUr_role());
		
		if(role.getUr_role().equals("Employee"))
		{
			System.out.println("We think you're an employee");
			dto = AppService.appService.getBasicRmbtByUser(clientUser);
			
			if(!req.getParameter("f").equals("None")) { //if there is a filter active
				for(ReimbursementBasicDTO r : dto) {
					if(req.getParameter("f").equals("Pending")) { //if the filter is for unresolved
						if(r.getRt_status().equals(req.getParameter("f"))) {
							
							dtoReturn.add(r);
						}
						System.out.println("rejected " + r.getRt_status());
					}
					else { //if the filter is for resolved
						if(!r.getRt_status().equals("Pending")) {
							
							dtoReturn.add(r);
						}
						System.out.println("rejected " + r.getRt_status());
					}
				}
			}
			else { //if there is no filter
				for(ReimbursementBasicDTO r : dto) {
					dtoReturn.add(r);
				}
			}
		}
		else if(role.getUr_role().equals("Manager"))
		{
			System.out.println("We think you're a manager");
			dto = AppService.appService.getAllBasicReimbursements();
			
			int uid = 0;
			ERS_User_Roles filterRole = null;
			
			System.out.println("the uid value is" + req.getParameter("uid"));
			
			if(req.getParameter("uid") != null) {
				uid = Integer.parseInt((String)req.getParameter("uid"));
				if(AppService.appService.validateRole(AppService.appService.getUserById(uid)) != null) {
					filterRole = AppService.appService.validateRole(AppService.appService.getUserById(uid));
				}
			}
			
			
			if(uid == 0 || (filterRole != null && filterRole.getUr_role().equals("Manager"))) {
				if(!req.getParameter("f").equals("None")) { //if there is a filter active
					for(ReimbursementBasicDTO r : dto) {
						if(req.getParameter("f").equals("Pending")) { //if the filter is for unresolved
							if(r.getRt_status().equals(req.getParameter("f"))) {
								
								dtoReturn.add(r);
							}
							System.out.println("rejected " + r.getRt_status());
						}
						else { //if the filter is for resolved
							if(!r.getRt_status().equals("Pending")) {
								
								dtoReturn.add(r);
							}
							System.out.println("rejected " + r.getRt_status());
						}
					}
				}
				else {
					dtoReturn = dto;
				}
			}
			else {
				System.out.println("We think you're neither");
				dto = AppService.appService.getBasicRmbtByUser(AppService.appService.getUserById(Integer.parseInt((String)req.getParameter("uid"))));
				if(!req.getParameter("f").equals("None")) { //if there is a filter active
					for(ReimbursementBasicDTO r : dto) {
						if(req.getParameter("f").equals("Pending")) { //if the filter is for unresolved
							if(r.getRt_status().equals(req.getParameter("f"))) {
								
								dtoReturn.add(r);
							}
							System.out.println("rejected " + r.getRt_status());
						}
						else { //if the filter is for resolved
							if(!r.getRt_status().equals("Pending")) {
								
								dtoReturn.add(r);
							}
							System.out.println("rejected " + r.getRt_status());
						}
					}
				}
				else {
					dtoReturn = dto;
				}
			}
			
		}
		else
		{
			PrintWriter out = resp.getWriter();
			out.println("No reimbursements are associated with this account type.");
		}
		
		if(dtoReturn.isEmpty()) {
			PrintWriter out = resp.getWriter();
			out.println("No reimbursements to display.");
		}
		else
		{
			
			
			
			String[] rmbt = new String[dtoReturn.size()];
			ObjectMapper jackson = new ObjectMapper();
			int i = 0;
			for(ReimbursementBasicDTO r : dtoReturn) {
				rmbt[i] = jackson.writeValueAsString(r);
				i++;
			}
			
			
			String json = jackson.writeValueAsString(rmbt);
			//let's try
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.println(json);
		}
	}
	
	
	

}

/*
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		//List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		List<ReimbursementBasicDTO> dto = new ArrayList<>();
		List<ReimbursementBasicDTO> dtoReturn = new ArrayList<>();
		
		ERS_User_Roles role = AppService.appService.validateRole(clientUser);
		
		//List<ERS_Reimbursement_Status> statuses = new ArrayList<>();
		
		int uid = Integer.parseInt((String)req.getParameter("uid"));
		ERS_User_Roles uidRole = AppService.appService.validateRole(AppService.appService.getUserById(uid));
		String filterRole = uidRole.getUr_role();
		
		AppService.appService.validateRole(AppService.appService.getUserById(Integer.parseInt((String)req.getParameter("uid")))).getUr_role().equals("Manager")
		
		if(role.getUr_role().equals("Employee"))
		{
			
			dto = AppService.appService.getBasicRmbtByUser(clientUser);
			
			if(req.getParameter("f") != "None") {
				for(ReimbursementBasicDTO r : dto) {
					if(r.getRt_status().equals(req.getParameter("f"))) {
						dtoReturn.add(r);
					}
				}
			}
		}
		else if(role.getUr_role().equals("Manager"))
		{
			dto = AppService.appService.getAllBasicReimbursements();
			
			//if there is a filter and the uid is for a specific employee
			if(req.getParameter("f") != "None" && filterRole.equals("Employee")) {
				for(ReimbursementBasicDTO r : dto) {
					if(r.getRt_status().equals(req.getParameter("f")) && 
							r.getU_id_author() == Integer.parseInt(req.getParameter("uid"))) {
						dtoReturn.add(r);
					}
				}
			} //else if there is a filter
			else if(req.getParameter("f") != "None") {
				for(ReimbursementBasicDTO r : dto) {
					if(r.getRt_status().equals(req.getParameter("f"))) {
						dtoReturn.add(r);
					}
				}
			} //else show full history
			else {
				for(ReimbursementBasicDTO r : dto) {
					dtoReturn.add(r);
					
				}
			}
		}
		else
		{
			PrintWriter out = resp.getWriter();
			out.println("No reimbursements are associated with this account type.");
		}
		
		if(dto.isEmpty()) {
			PrintWriter out = resp.getWriter();
			out.println("No reimbursements to display.");
		}
		else
		{
			
			
			
			String[] rmbt = new String[dto.size()];
			ObjectMapper jackson = new ObjectMapper();
			int i = 0;
			for(ReimbursementBasicDTO r : dto) {
				rmbt[i] = jackson.writeValueAsString(r);
				i++;
			}
			
			String json = jackson.writeValueAsString(rmbt);
			
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.println(json);
		}
	}
	
	
*/