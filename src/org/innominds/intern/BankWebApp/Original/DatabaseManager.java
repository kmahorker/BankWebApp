package org.innominds.intern.BankWebApp.Original;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This is a universal class that has static methods to help manage a database.
 * It includes methods that allow you load the driver for the database, connect to it, and
 * get a query.
 * @author Kaushik
 *
 */
public class DatabaseManager {

	/**
	 * Finds the class of the inputted driver in order load that class. The jar file of the connector/ driver
	 * must be in the build path in order for the system to find it.
	 * @param dbdriver
	 */
	public static void loadDriver(String dbdriver)
	{
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a connection to the database with the DriverManager using a url, username, and password to the connection.
	 * Returns this connection to be usable for other needs.
	 * @param dburl
	 * @param dbuname
	 * @param dbpassword
	 * @return
	 */
	public static Connection getConnection(String dburl, String dbuname, String dbpassword)
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl,dbuname,dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	/**
	 * Returns a PreparedStatement that is created from the connection and passes qury code in the string format
	 * with '?' in place of values. 
	 * @param con
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(Connection con, String sql)
	{
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * Closes the connection to the database safely.
	 * @param con
	 */
	public static void closeConnection(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes the PreparedStatement safely to prevent further changes.
	 * @param ps
	 */
	public static void closePrepraredStatement(PreparedStatement ps)
	{
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
