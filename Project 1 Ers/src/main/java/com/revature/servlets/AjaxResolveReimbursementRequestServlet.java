package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUser;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

@WebServlet("/ajaxResolveRequest")
public class AjaxResolveReimbursementRequestServlet extends HttpServlet {
	
	private AppService service = AppServiceImpl.getService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxResolveReimbursementRequestServlet -GET");
		
		HttpSession session = req.getSession();
		ErsUser clientUser = (ErsUser) session.getAttribute("user");
		
		int reId = Integer.parseInt(req.getParameter("re_id"));
		boolean approve = Boolean.parseBoolean(req.getParameter("approve"));

		ErsReimbursement re = service.getReimbursement(reId);
		
		if (clientUser != null && re != null) {
			service.resolveRequest(clientUser, re, approve);
			session.removeAttribute("allReimbursements");
		}
		
		req.getRequestDispatcher("features/manager/view_reimbursements/reimbursements_view.html").forward(req, resp);
		//get session
		//get r_id from url
		//get approve/deny from url
		//call resolveRequest method in service using user from session and reimbursement from r_id (call service method)
		//forward back to manager/view_reimbursements/reimbursements_view.html
	}

}
  