package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.tomcat.util.codec.binary.Base64;

import com.revature.model.ERS_Reimbursements;
import com.revature.service.AppService;

@WebServlet("/imageView")
public class ImageViewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		ERS_Reimbursements rmbt = AppService.appService.getReimbursementById(Integer.parseInt((String)req.getParameter("id")));
		
		byte[] output = Base64.getDecoder().decode(rmbt.getR_receipt());// rmbt.getR_receipt();//
		resp.setContentType("image/jpg");
		PrintWriter out = resp.getWriter();
		out.print(output);
		
		
	}
	
	
	
	

}
