package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.ImageDTO;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

@WebServlet("/ajaxLoadReceipt")
public class AjaxLoadReceiptServlet extends HttpServlet {
	
	private AppService service = AppServiceImpl.getService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxLoadReceiptServlet -GET");
		
		int reId = Integer.parseInt(req.getParameter("id"));
		byte[] receipt = service.getReceiptByReimbursementId(reId);
		
		ImageDTO receiptImg = new ImageDTO("image/png", receipt);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(receiptImg);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}

}
