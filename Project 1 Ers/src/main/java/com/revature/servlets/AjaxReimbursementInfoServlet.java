package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ErsReimbursementDTO;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsReimbursementStatus;
import com.revature.model.ErsUser;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

@WebServlet("/ajaxReimbursementInfo")
public class AjaxReimbursementInfoServlet extends HttpServlet {
	
	private AppService service = AppServiceImpl.getService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxReimbursementInfoServlet -GET");
		
		HttpSession session = req.getSession();
		ErsUser user = (ErsUser) session.getAttribute("user");
	
		if (user != null) {
			List<ErsReimbursement> dtoLst = (List<ErsReimbursement>) session.getAttribute("reimbursements");
			if (dtoLst == null) {
//				dtoLst = service.toDTOLst(service.getReimbursements(user));
				dtoLst = service.getReimbursements(user);
				session.setAttribute("reimbursements", dtoLst);
			}

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dtoLst);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
		else {
			System.out.println("There is no session attribute named 'user'");
		}
	}
	
	private String getValue(String json) {
		String sub = "";
		for(int i = json.indexOf(':') + 1; i < json.length(); i++) {
			char c = json.charAt(i);
			if (Character.isLetter(c)) sub += c;
		}
		return sub;
	}
	
//	private List<ErsReimbursementDTO> toDTOLst(List<ErsReimbursement> lst) {
//		List<ErsReimbursementDTO> dtoLst = new ArrayList<>();
//		for(ErsReimbursement re : lst) {
//			dtoLst.add(new ErsReimbursementDTO(re, service.getAuthor(re), service.getResolver(re)));
//		}
//		return dtoLst;
//	}
}
