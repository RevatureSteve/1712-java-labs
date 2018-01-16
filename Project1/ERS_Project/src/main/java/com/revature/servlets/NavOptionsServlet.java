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
import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/ajaxNavOptions")
public class NavOptionsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		ERS_User_Roles roles = (ERS_User_Roles)AppService.appService.validateRole(clientUser);
		
		class Options {
			public String role = "";
			public int u_id = 0;
			public String nb_option1 = ""; //E request M view unresolved requests
			public String nbdd_option1 = ""; //E view pending M view unresolved
			public String nbdd_option2 = ""; //E view history M view history
			public String nbdd_option3 = ""; //E submit new request M view employees
			public String nbdd_option4 = ""; //E account details M account details
			
			public Options(String role, int u_id, String mainOption, String option1, String option2, String option3, String option4) {
				this.role = role;
				this.u_id = u_id;
				this.nb_option1 = mainOption;
				this.nbdd_option1 = option1;
				this.nbdd_option2 = option2;
				this.nbdd_option3 = option3;
				this.nbdd_option4 = option4;
			}
		}
		
		String optionList = "";
		
		if(roles.getUr_role().equals("Employee")) {
			
			Options options = new Options(roles.getUr_role(), clientUser.getU_id(), "Request", "Pending", "History", "Request", "Account");
			
			ObjectMapper jackson = new ObjectMapper();
			optionList = jackson.writeValueAsString(options);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.println(optionList);
			
			//optionList = "{\"nb_option1\" : \"Request Reimbursement\" , \"nbdd_option1\" : \" }";
			
		} else if( roles.getUr_role().equals("Manager")) {
			
			Options options = new Options(roles.getUr_role(), clientUser.getU_id(), "Unresolved", "Unresolved", "History", "Employees", "Account");
			
			ObjectMapper jackson = new ObjectMapper();
			optionList = jackson.writeValueAsString(options);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.println(optionList);
			
		}
		else {
			PrintWriter out = resp.getWriter();
			//response.setContentType("application/json");
			out.println("<p>No view matches user role " + roles.getUr_role() + "</p>");
		}
	}

}
