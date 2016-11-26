package org.innominds.intern.BankWebApp.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The welcome page when first starting up the application. It will greet the
 * user and allow the user to either login or sign up at the bank.
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public WelcomeServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * Cancels the current session and goes to WelcomePage.jsp
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("WelcomePage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		RequestDispatcher rd = null;
		if (button.equals("Login")) {
			rd = request.getRequestDispatcher("LoginPage.jsp");
		} else if (button.equals("Signup")) {
			rd = request.getRequestDispatcher("SignupPage.jsp");
		}

		rd.forward(request, response);
	}

	/*
	 * public void login(){ System.out.println("hello---login"); }
	 * 
	 * public void signup(){ System.out.println("hello---signup"); }
	 */

}
