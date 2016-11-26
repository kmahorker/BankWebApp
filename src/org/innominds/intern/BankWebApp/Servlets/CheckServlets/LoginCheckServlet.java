package org.innominds.intern.BankWebApp.Servlets.CheckServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.innominds.intern.BankWebApp.Database.*;
import org.innominds.intern.BankWebApp.Original.*;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Gets and verifies the login information. If the information is valid,
	 * then the user is given access to their account and forwarded to the
	 * HomePage. Otherwise the user is forwarded to a retry page.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		RequestDispatcher rd = null;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		UserJdbcTemplate jdbc = (UserJdbcTemplate) context
				.getBean("UserJdbcTemplate");
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		User currentUser = jdbc.getUser(username);
		if (currentUser != null && currentUser.checkPassword(password)) {
			request.getSession().setAttribute("currentUser", currentUser);
			// HomeServlet hs = new HomeServlet();
			// hs.doPost(request, response);
			// rd = request.getRequestDispatcher("/Home");
			response.sendRedirect("/BankWebApp/Home");
		} else {
			// LoginRetryServlet lr = new LoginRetryServlet();
			// lr.doPost(request, response);
			// rd = request.getRequestDispatcher("/LoginRetry");
			response.sendRedirect("/BankWebApp/LoginRetry");
		}
		// rd.forward(request,response);
	}
}
