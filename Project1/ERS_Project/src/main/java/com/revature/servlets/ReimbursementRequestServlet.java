package com.revature.servlets;

import java.awt.image.BufferedImage;
import java.io.*;//added
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;//added

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;//added
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;//all added
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_Users;
import com.revature.service.AppService;

@WebServlet("/requestReimbursement")
public class ReimbursementRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("in doGet");
		
		req.getRequestDispatcher("features/rRequest/reimbursementrequest.html").forward(req, resp);
		
		
		//PrintWriter out = resp.getWriter();
		//resp.setContentType("application/json");
		//out.println("In doGet");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ERS_Users clientUser = (ERS_Users)session.getAttribute("user");
		
		int type = Integer.parseInt((String)req.getParameter("requestType"));
		double amount = Double.parseDouble((String)req.getParameter("amount"));
		String description = (String)req.getParameter("description");
		
		
		
		
		ERS_Reimbursements rRequest = new ERS_Reimbursements();
		
		rRequest.setR_amount(amount);
		rRequest.setR_description(description);
		rRequest.setRt_type(type);
		rRequest.setR_receipt(null);
		rRequest.setU_id_author(clientUser.getU_id());
		//rRequest.setR_receipt(blob);
		
		System.out.println("type:" + type);
		System.out.println("amount: " + amount);
		AppService.appService.submitRequest(rRequest);
		
		
		resp.sendRedirect("app.html");
		
		//PrintWriter out = resp.getWriter();
		//resp.setContentType("application/json");
		//out.println("In doPost");
	}
	
	/*
	//Image stuff----------------------------------------------------------------------
		SerialBlob blob = null;
		boolean isMultipart = false;
		//String filePath = "C:\\Users\\David\\Documents\\Apache\\apache-tomcat-9.0.2\\webapps\\data";
		int maxFileSize = 50 * 1024;
		int maxMemSize = 4 * 1024;
		File file; // the file to use
		
		//logic begin
		
		//check for file upload request
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if (!isMultipart) {
			System.out.println("no file uploaded");
		}
		
		//skipping error;
		
		//using a relative path to place content rather than in the c:\temp folder
		//MINE
		String contextRoot = getServletContext().getRealPath("/");
		
		//FACTORY!!!!!----------------------------------------
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		
		//location to save data that is larger than memsize
		factory.setRepository(new File(contextRoot + "WEB-INF/tmp"));
		
		//Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//maximum file size to be uploaded
		upload.setSizeMax(maxFileSize);
		
		
		try {
			//parse the request to get file items
			List fileItems = upload.parseRequest(req);
			
			//process the uploaded file items
			Iterator i = fileItems.iterator();
			
			System.out.println("servlet upload");
			
			while(i.hasNext()) {
				FileItem fi = (FileItem)i.next();
				
				if(!fi.isFormField()) {
					//get the uploaded file parameters
					
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					if( fileName.lastIndexOf("\\") >= 0 ) {
						file = new File(contextRoot + "WEB-INF/img" + fileName.substring( fileName.lastIndexOf("\\")));
					}
					else {
						file = new File(contextRoot + "WEB-INF/img" + fileName.substring( fileName.lastIndexOf("\\")+1));
					}
					fi.write(file);
					
					
//					BufferedImage bufferedImage = ImageIO.read(file.getAbsoluteFile());
					
					Path path = Paths.get(file.getAbsolutePath());
					byte[] data = Files.readAllBytes(path);
					
					
					
					try {
						blob = new SerialBlob(data);
					}
					catch (SQLException e) {
						
					}
					
					
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		BufferedImage uploadedImage = null;
		
		
		
		//temporary disc location?
		
		byte[] image = new byte[100];
		
		
		
		//End image stuff------------------------------------------------------------------
		enctype = "multipart/form-data"
	 */
}

