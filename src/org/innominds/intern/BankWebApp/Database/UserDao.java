package org.innominds.intern.BankWebApp.Database;

import java.util.List;

import javax.sql.DataSource;

import org.innominds.intern.BankWebApp.Original.User;

/**
 * Database Facilities and CRUD methods.
 * @author Kaushik
 *
 */
public interface UserDao {
	
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the accounts table.
	    */
	   public void create(String name, String username, String password, Integer balance);
	   /** 
	    * This is the method to be used to list down
	    * a record from the accounts table corresponding
	    * to a passed username.
	    */
	   public User getUser(String username);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the accounts table.
	    */
	   public List<User> listUsers();
	   /** 
	    * This is the method to be used to delete
	    * a record from the accounts table corresponding
	    * to a passed username.
	    */
	   public void delete(String username);
	   /** 
	    * This is the method to be used to update
	    * a record into the accounts table.
	    */
	   public void update(String username, Integer balance);
	   
	   /**
	    * This is to be used to check whether a specified username has been taken
	    * @param username
	    * @return
	    */
	   public boolean checkDuplicate(String username);

}
