package org.innominds.intern.BankWebApp.Original;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

/**
 *
 * This class represents a bank's client that has an account at the bank. The client contains vital information such as, name, username, password, and balance.
 * A User object is created for each and every client in the corresponding classes.
 * @author Kaushik
 * 6/21/2015
 */
public class User {
	private String name; //Legal name
	private String username; //Login info
	private String password; //Login info
	private int balance; //Money in the bank
	
	public User(){
		
	}
	public User(String name, String username, String password, int balance) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
	//	dbAddUser();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	/**
	 * Checks to see if the passed String and the User's password when creating the account match.
	 * @param pass
	 * @return
	 */
	public boolean checkPassword(String pass){
		return pass.equals(password);
	}
	
	public void deposit(int amt){
		balance+=amt;
	}
	
	public void withdraw(int amt){
		balance -= amt;
	}
	
	
	/**
	 * This method is used to make balance changes to the account (withdraw/deposit).
	 * This method also checks to ensure the input is a multiple of 100, and ensure
	 * no negative balance is withdrawn. It returns a boolean confirming whether or not
	 * the transaction occurs. 
	 * @param amt
	 * @return
	 */
	public boolean transaction(int amt, boolean checkAm){
		//CheckAm: true -- deposit
		//CheckAm: false -- withdraw
		if((checkAm == true && amt<0)|| (checkAm == false && amt>0)){
			System.out.println("\nPlease enter a valid amount.");
			return false;
		}
		if(amt%100 == 0){
			if(balance+amt >= 0){
				balance+=amt;
			//	dbUpdateBalance(); //Updates the database with the new balance
				return true;
			}
			else{
				System.out.println("\nYou have insufficient funds to withdraw that amount.");
				return false;
			}
		}
		else{
			System.out.println("\nYou must enter an amount that is a multiple of 100");
		}
		/*if(checkAm){
			System.out.println("\nYou must deposit an amount that is a multiple of 100.");
		}
		else{
			System.out.println("\nYou must withdraw an amount that is a multiple of 100.");
		}*/
		return false;
		
	}
	

	/**
	 * Outputs the User's bank balance in its proper format.
	 */
	public void printBalance(){
		System.out.println("\nYour current balance is " + "₹" + balance); //Had to change the encoding to UTF-8 in order to get Rupee symbol to show up
	}
	public boolean isParsable(String input) {
		boolean parsable = true;
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			parsable = false;
		}
		return parsable;
	}

	
/*	----------- JDBC METHODOLOGIES NOW TRANSFERRED IN WEB APP  ---------------
	*//**
	 * Loads the JDBC driver for mysql to access the database.
	 * Fetches the connection of the database in order to access its elements.
	 * Creates a PreparedStatement that executes an SQL Query which adds the information of 
	 * the User object that was just created into a row of the accounts table of the bankdatabase.
	 * Closes the PreparedStatement and the Connection to the database.
	 *//*
	public void dbAddUser(){
		DatabaseManager.loadDriver("com.mysql.jdbc.Driver");
		Connection con = null;
		con = DatabaseManager.getConnection("jdbc:mysql://localhost:3306/BankDatabase", "root", "mysql");
		String sql = "INSERT INTO accounts VALUES(?,?,?,?)";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con,sql);
		try{ 
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3,password);
			ps.setInt(4, balance);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("There was an error in creating your account.");
			System.exit(1);
		}
		DatabaseManager.closePrepraredStatement(ps);
		DatabaseManager.closeConnection(con);

	}
	
	*//**
	 * Loads the JDBC driver for mysql.
	 * Fetches the connection of the database in order to access its elements.
	 * Creates a PreparedStatement that executes an SQL Query.
	 * This SQL Query updates the database to the new balance of this particular user.
	 * Closes the Prepared Statement and the Connection to the Database.
	 *//*
	public void dbUpdateBalance(){
		DatabaseManager.loadDriver("com.mysql.jdbc.Driver");
		Connection con = null;
		con = DatabaseManager.getConnection("jdbc:mysql://localhost:3306/BankDatabase", "root", "mysql");
		String sql = "UPDATE accounts SET Balance = ?  WHERE Username = ?";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con,sql);
		try{ 
			ps.setInt(1,balance);
			ps.setString(2,username);
			ps.executeUpdate();
		}catch(SQLException e){
			System.out.println("There was an error in updating your balance");
			System.exit(1);
		}
		DatabaseManager.closePrepraredStatement(ps);
		DatabaseManager.closeConnection(con);

	}*/
}
