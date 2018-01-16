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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/employeesData")
public class EmployeesDataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("employees data -GET");
		ObjectMapper jackson = new ObjectMapper();
		List<ERS_Users> employees = new ArrayList<>();
		
		employees = AppService.appService.getAllEmployees();
		
		String[] empStrings = new String[employees.size()];
		
		int i = 0;
		for(ERS_Users e : employees) {
			empStrings[i] = jackson.writeValueAsString(e);
			i++;
		}
		
		String json = jackson.writeValueAsString(empStrings);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.println(json);
	}
	
	
}
