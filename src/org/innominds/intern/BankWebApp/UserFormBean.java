package org.innominds.intern.BankWebApp;

import java.util.HashMap;

import org.innominds.intern.BankWebApp.Database.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class is a JavaBean that represents one form submission on the
 * SignupPage. It contains a field for each entry, as well as a method
 * to validate the input.
 * 
 * @author Kaushik
 *
 */
public class UserFormBean {
	private String name; // Legal name
	private String username; // Login info
	private String password; // Login info
	private String confirmPassword;

	private String balance; // Money in the bank
	private HashMap<String, String> errors; //Error Message matched to input name

	public UserFormBean() {
		name = "";
		username = "";
		password = "";
		confirmPassword = "";
		balance = "";
	}

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}



	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}



	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}



	/**
	 * @return the errors
	 */
	public HashMap<String, String> getErrors() {
		return errors;
	}



	/**
	 * @param errors the errors to set
	 */
	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}



	/**
	 * This method checks each input and returns whether or not all the inputs are valid.
	 * If a certain input is invalid, it will map the specified error message to that 
	 * invalid input using a HashMap.
	 * @return
	 */
	public boolean validate() {
		errors = new HashMap<String, String>();
		boolean allOk = true;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		UserJdbcTemplate jdbc = (UserJdbcTemplate) context
				.getBean("UserJdbcTemplate");
		if (name.equals("")) {
			errors.put("name", "Please enter a valid name");
			allOk = false;
		}
		if (username.equals("")) {
			errors.put("username", "You must enter a username");
			allOk = false;
		}
		if (jdbc.checkDuplicate(username)) {
			errors.put("username", "Username has been taken");
			username = "";
			allOk = false;
		}
		if (password.equals("")) {
			errors.put("password", "You must enter a password");
			allOk = false;
		}
		if (!password.equals("")
				&& (confirmPassword.equals("") || !password
						.equals(confirmPassword))) {
			errors.put("confirmPassword", "The passwords do not match");
			confirmPassword = "";
			allOk = false;
		}
		try {
			Integer.parseInt(balance);
		} catch (NumberFormatException e) {
			errors.put("balance", "Please enter a valid number");
			balance = "";
			allOk = false;
		}
		return allOk;
	}

	public String getErrorMsg(String s) {
		String errorMsg = (String) errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}
}
