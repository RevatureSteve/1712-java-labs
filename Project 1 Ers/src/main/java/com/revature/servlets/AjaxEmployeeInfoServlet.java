package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ErsUserDTO;
import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;
import com.revature.service.AppServiceImpl;

@WebServlet("/ajaxEmployeeInfo")
public class AjaxEmployeeInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxEmployeeInfoServlet");
		
		HttpSession session = req.getSession();
		ErsUser user = (ErsUser) session.getAttribute("user");
		
		if (user != null && user.getRole() == ErsUserRole.MANAGER) {
			List<ErsUserDTO> userLst = (List<ErsUserDTO>) session.getAttribute("employees");
			if (userLst == null) {
				userLst = AppServiceImpl.getService().getAllUsersDTO("employee");
				session.setAttribute("employees", userLst);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(userLst);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
	}

}
