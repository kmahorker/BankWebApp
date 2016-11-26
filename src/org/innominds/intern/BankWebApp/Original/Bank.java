package org.innominds.intern.BankWebApp.Original;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Console;

/**
 * This class represents the bank and its functions. It contains a list of its clients that have accounts there.
 * 
 * @author Kaushik
 * 6/21/2015
 */
public class Bank {
	
	private ArrayList<User> users; // Abstraction. Other classes don't need to know all the users. This list does not need to know what a User actually is.
	private Scanner in;
	public Bank(){
		in = new Scanner(System.in);
		users = new ArrayList<User>();
		dbGetAllUsers(); //Adds the users in the database into the ArrayList
		
		/*users.add(new User("Kaushik", "km1998", "hello", 10000));
		users.add(new User("Raj", "raj123", "wordpass", 52348));
		users.add(new User("John", "johnny", "abcdef", 1000));*/
	}
	public Bank(ArrayList<User> users) {
		super();
		this.users = users;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	/**
	 * Looks through all users in the users ArrayList and returns a User 
	 * 
	 * @param username
	 * @return
	 */
	public User findUser(String username) {
		for (User user : users) {
			String name = user.getUsername();
			if (name.equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	
	/**
	 * Goes through the list and returns true if the user with given username is in the list. Otherwise, returns false.
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkUser(String username) {
		for (User user : users) {
			String name = user.getUsername();
			if (name.equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Prints a goodbye message to the console.
	 */
	public void exitMessage(){
		System.out.println("\n\nThanks for using our bank. Please come again!");
		System.exit(1);
	}
	
	
	/**
	 * Reads Password without allowing the console to show the characters while the user is typing the password.
	 * @return
	 */
	public String readPass(){
		String pass = "";
		Console cnsl = System.console();
		if(cnsl!=null){
			char[] pword = cnsl.readPassword();
			for(char part: pword){
				pass+=part;
			}
			return pass;
		}
		return "";
		
	}
	
	
	/**
	 * Prompts the user for necessary information, creates a User object, and adds the object to the list.
	 */
	public void addUser(){
		String name = "";
		String username = "";
		String password = "";
		int balance = 0;
		boolean match = false;
		boolean check = false;
		boolean taken = true;
		System.out.println("\nThere will be a series of questions to complete your registration.");
		System.out.print("\nPlease enter your name: ");
		name = in.next();
		do{
			System.out.print("\nPlease enter your desired username: ");
			username = in.next();
			taken = checkUser(username);
			if(taken){
				System.out.println("This username is already taken. Please pick another one.");
			}
		}while(taken);
		
		do{
			System.out.print("\nPlease enter your desired password: ");
			password = in.next();
			System.out.print("\nConfirm Password: ");
			String confirm = in.next();
			match = confirm.equals(password);
			if(!match){
				System.out.println("The passwords don't match. Try again.");
			}
		}while(!match);
		do{
			System.out.print("\nPlease enter your desired starting balance: ");
			try{
				balance = in.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nPlease enter a valid amount.");
				in.next();
				continue;
			}
			check = true;
		}while(!check);
		users.add(new User(name, username, password, balance));
		System.out.println("\nThanks for creating an account at our bank!");
		System.out.println("\nNow redirecting you to the login page...");
	}
	
	/**
	 * Gets all of the users from the database through a JDBC connection by executing an SQL query
	 * with a PreparedStatement. Then retrieves all of the columns of the table with a ResultSet.
	 * The information from the result set is added to an empty user object which is then added to the
	 * ArrayList<User> users.
	 */
	public void dbGetAllUsers(){
		try{
			DatabaseManager.loadDriver("com.mysql.jdbc.Driver");
			Connection con = null;
			ResultSet rs = null;
			con = DatabaseManager.getConnection("jdbc:mysql://localhost:3306/BankDatabase", "root", "mysql");
			String sql = "SELECT * FROM accounts";
			PreparedStatement ps = DatabaseManager.getPreparedStatement(con,sql);
			
			
				rs = ps.executeQuery();			
				while(rs.next()){
					User user = new User();
					String name = "";
					String username = "";
					String password = "";
					int balance = 0;
				
						name = rs.getString("name");
						username = rs.getString("username");
						password = rs.getString("password");
						balance = rs.getInt("balance");
						
					user.setUsername(username);
					user.setName(name);
					user.setBalance(balance);
					user.setPassword(password);
					users.add(user);
				}
			
			DatabaseManager.closePrepraredStatement(ps);
			DatabaseManager.closeConnection(con);
		} catch (SQLException e) {
			System.out.println("Unable to fetch accounts at the moment.");
		}
	}
}
