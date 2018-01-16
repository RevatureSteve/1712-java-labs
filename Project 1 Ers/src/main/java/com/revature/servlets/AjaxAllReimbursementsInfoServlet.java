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
import com.revature.dto.ErsReimbursementDTO;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

@WebServlet("/ajaxAllReimbursementsInfo")
public class AjaxAllReimbursementsInfoServlet extends HttpServlet {
	
	private AppService service = AppServiceImpl.getService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxAllReimbursementsInfoServlet");
		
		HttpSession session = req.getSession();
		
		List<ErsReimbursementDTO> dtoLst = (List<ErsReimbursementDTO>) session.getAttribute("allReimbursements");
		if (dtoLst == null) {
			dtoLst = service.getAllReimbursementsDTO();
			session.setAttribute("allReimbursements", dtoLst);
		}
		
		String idParam = req.getParameter("empl_id");
		if (idParam != null) {
			int id = Integer.parseInt(idParam);
			if (id >= 0) dtoLst = filterByEmployeeId(dtoLst, id);
		}
		
				
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dtoLst);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}

	private List<ErsReimbursementDTO> filterByEmployeeId(List<ErsReimbursementDTO> lst, int id) {
		List<ErsReimbursementDTO> filtered = new ArrayList<>();
		for(ErsReimbursementDTO re : lst) {
			if (re.getAuthor().getId() == id) filtered.add(re);
		}
		return filtered;
	}
}
