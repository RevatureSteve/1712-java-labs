package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ERS_Reimbursement_Type;
import com.revature.service.AppService;


@WebServlet("/requestType")
public class RequestTypeOptionsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ERS_Reimbursement_Type> dbTypes = AppService.appService.getTypes();
		String[] type = new String[dbTypes.size()];
		
		ObjectMapper jackson = new ObjectMapper();
		
		int index = 0;
		
		for(ERS_Reimbursement_Type dbType : dbTypes) {
			
			String currentType = jackson.writeValueAsString(dbType);
			type[index] = currentType;
			index++;
		}
		
		String json = jackson.writeValueAsString(type);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);
	}

}
