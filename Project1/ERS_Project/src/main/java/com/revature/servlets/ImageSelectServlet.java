package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//TODO reomve
@WebServlet("/ajaxImageSelect")
public class ImageSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ImageSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("features/imageSelect/imageselect.html").forward(request, response);
	}
}
