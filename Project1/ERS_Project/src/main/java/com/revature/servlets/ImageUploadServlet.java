package com.revature.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.model.ERS_Reimbursements;
import com.revature.service.AppService;

import oracle.sql.BLOB;

@WebServlet("/imageUpload")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		ERS_Reimbursements rmbt = (ERS_Reimbursements)session.getAttribute("reimbursement");
		
		
		Part filePart = req.getPart("img");
        
		//int reimNum = Integer.parseInt(req.getParameter("reimNum"));
        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//        InputStream fileContent = filePart.getInputStream();
//        
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        
//        int nRead;
//        byte[] data = new byte[16384];
//        while ((nRead = fileContent.read(data, 0, data.length)) != -1) {
//          buffer.write(data, 0, nRead);
//        }
//        buffer.flush();
//        byte[] bytes = buffer.toByteArray();
		
		InputStream fileContent = filePart.getInputStream();
		
		rmbt.setR_receipt(Base64.getEncoder().encode(fileContent.readAllBytes()));
		//rmbt.setR_receipt(fileContent.readAllBytes());
		
		
		AppService.appService.updateReimbursementAddReceipt(rmbt);
		
		PrintWriter out = resp.getWriter();
		out.print(fileContent.readAllBytes());
		
		
		//resp.sendRedirect("app.html");
	}
}


/*
		
		
		
		BLOB blob = null;
		boolean isMultipart = false;
		//String filePath = "C:\\Users\\David\\Documents\\Apache\\apache-tomcat-9.0.2\\webapps\\data";
		int maxFileSize = 50 * 1024;
		int maxMemSize = 4 * 1024;
		File file; // the file to use
		
		//logic begin
		
		//check for file upload request
		isMultipart = ServletFileUpload.isMultipartContent(req);//replace with tomcat?
		
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
					
					for(int ir = 0; ir < 20; ir++) {
						System.out.println(data[ir]);
					}
					
					rmbt = AppService.appService.putInBlob(rmbt, data);
					
					
//					blob = new BLOB();
//					
//					
//					try {
//						blob = new SerialBlob(data);
//					}
//					catch (SQLException e) {
//						System.out.println("sql exception with serialblob");
//					}
					
					
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("didn't work");
		}
		
		
		
		
		AppService.appService.updateReimbursementAddReceipt(rmbt);
		
*/