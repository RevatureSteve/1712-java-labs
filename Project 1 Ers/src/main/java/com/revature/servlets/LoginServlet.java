package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ErsUser;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901784448217028279L;

	private final AppService service = AppServiceImpl.getService();
	
	public LoginServlet() {
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -GET");
		req.getRequestDispatcher("login.html").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		ErsUser clientUser = new ErsUser();
		clientUser.setUsername(username);
		clientUser.setPassword(password);
		clientUser = service.validateUser(clientUser);
		System.out.println(clientUser);

		System.out.println("Username entered: " + username + ", Password entered: " + password);

		if (clientUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", clientUser);
			req.getRequestDispatcher("app.html").forward(req, resp);
//			resp.sendRedirect("app.html");
			
		}
		else {
			System.out.println("Invalid credentials -sending user back to login.html");
			req.getRequestDispatcher("login.html").forward(req, resp);
		}

	}

}
