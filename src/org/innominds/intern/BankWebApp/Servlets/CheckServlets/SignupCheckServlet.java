package org.innominds.intern.BankWebApp.Servlets.CheckServlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.innominds.intern.BankWebApp.Universal;
import org.innominds.intern.BankWebApp.UserFormBean;
import org.innominds.intern.BankWebApp.Database.UserJdbcTemplate;
import org.innominds.intern.BankWebApp.Original.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class SignupCheckServlet
 */
@WebServlet("/SignupCheck")
public class SignupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupCheckServlet() {
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
	 * This method first gets the empty JavaBean UserFormBean object from
	 * Beans.xml. Then it gets and saves the value of each form entry. Then each
	 * form input is mapped into the UserFormBean, and that UserFormBean is
	 * saved in the session. The inputs are validated and errors are mapped and
	 * saved into the UserFormBean. If there are no errors, a new row is added
	 * to the database, and the user is automatically redirected to the login
	 * page. Otherwise the user is sent to the SignupRetry page.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		UserJdbcTemplate jdbc = (UserJdbcTemplate) context
				.getBean("UserJdbcTemplate");
		RequestDispatcher rd = null;
		UserFormBean formHandler = (UserFormBean) context
				.getBean("formHandler");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String balance = request.getParameter("balance");
		Integer bal = null;
		if (Universal.isParsable(balance)) {
			bal = Integer.parseInt(balance);
		}
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("name", name);
		properties.put("username", username);
		properties.put("password", password);
		properties.put("confirmPassword", confirmPassword);
		properties.put("balance", balance);

		formHandler.setName(name);
		formHandler.setUsername(username);
		formHandler.setPassword(password);
		formHandler.setConfirmPassword(confirmPassword);
		formHandler.setBalance(balance);
		try {
			BeanUtils.populate(formHandler, properties);

			BeanUtils.setProperty(formHandler, "confirmPassword",
					confirmPassword);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean validation = formHandler.validate();
		try {
			BeanUtils.setProperty(formHandler, "errors",
					formHandler.getErrors());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("formHandler", formHandler);
		if (validation) {

			jdbc.create(name, username, password, bal);
			response.sendRedirect("Login");

			// rd = request.getRequestDispatcher("LoginPage.jsp"); //TODO:
			// Change to SignUpConfirmation.jsp
		} else {

			// rd = request.getRequestDispatcher("SignupRetry.jsp");
			response.sendRedirect("SignupRetry");
		}
		// rd.forward(request, response);

	}

}
