package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import com.revature.model.ErsReimbursement;
import com.revature.model.ErsReimbursementType;
import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

@WebServlet("/ajaxSubmitReimbursementRequest")
@MultipartConfig
public class AjaxSubmitReimbursementRequestServlet extends HttpServlet {
	
	AppService service = AppServiceImpl.getService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxSubmitReimbursementRequest -GET");
		
		ErsUser clientUser = (ErsUser) req.getSession().getAttribute("user");
		if (clientUser != null && clientUser.getRole() == ErsUserRole.EMPLOYEE) {
			req.getRequestDispatcher("features/employee/submit_reimbursement/reimbursement_submit.html").forward(req, resp);
		}
		else if (clientUser != null) {
			req.getRequestDispatcher("features/dashboard/dashboard_manager.html");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxSubmitReimbursementRequestServlet -POST");
		
		double amount = Double.parseDouble(req.getParameter("amount"));
		ErsReimbursementType type = ErsReimbursementType.forValue(req.getParameter("type"));
		String description = req.getParameter("description");
		
		byte[] receipt = null;
		Part receiptPart = req.getPart("receipt");
		if (receiptPart != null) {
			receipt = toByteArray(receiptPart.getInputStream());
		}
		
		
		ErsReimbursement re = new ErsReimbursement();
		re.setAmount(amount);
		re.setDescription(description);
		re.setType(type);
		re.setReceipt(receipt);
		
		HttpSession session = req.getSession();
		ErsUser user = (ErsUser) session.getAttribute("user");
		
		int submittedId = service.submitReimbursementRequest(re, user);
		ErsReimbursement submittedRe = service.getReimbursement(submittedId);
		session.setAttribute("lastSubmittedReimbursement", submittedRe);
		
		session.removeAttribute("reimbursements");
		
		if (user.getRole() == ErsUserRole.EMPLOYEE) req.getRequestDispatcher("features/employee/view_reimbursements/reimbursements_view.html").forward(req, resp);
	}
	
	private byte[] toByteArray(InputStream in) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		try {
			while ((nRead = in.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer.toByteArray();
	}
}
