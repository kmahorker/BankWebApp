package org.innominds.intern.BankWebApp.Servlets.CheckServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.innominds.intern.BankWebApp.Database.UserJdbcTemplate;
import org.innominds.intern.BankWebApp.Original.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class DepositCheckServlet
 */
@WebServlet("/DepositCheck")
public class DepositCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepositCheckServlet() {
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
	 * If the amount being deposited is valid, then the currentUser's balance is
	 * updated in the database, and is the page is forwarded to Success.jsp.
	 * Otherwise, the page is forwarded to Error.jsp.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User currentUser = (User) request.getSession().getAttribute(
				"currentUser");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		UserJdbcTemplate jdbc = (UserJdbcTemplate) context
				.getBean("UserJdbcTemplate");
		RequestDispatcher rd = null;
		String amount = request.getParameter("amount");
		if (currentUser.isParsable(amount) && Integer.parseInt(amount) >= 0) {
			currentUser.deposit(Integer.parseInt(amount));
			jdbc.update(currentUser.getUsername(), currentUser.getBalance());
			rd = request.getRequestDispatcher("Success.jsp");
		} else {
			rd = request.getRequestDispatcher("Error.jsp");
		}
		rd.forward(request, response);

	}

}
