package org.innominds.intern.BankWebApp.Database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.innominds.intern.BankWebApp.Original.User;

/**
 * Utilizes JdbcTemplate from Spring to run queries.
 * @author Kaushik
 *
 */
public class UserJdbcTemplate implements UserDao {
	 private DataSource dataSource;
	 private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, String username, String password,
			Integer balance) {
		String SQL = "INSERT INTO accounts VALUES(?,?,?,?)";
		jdbcTemplateObject.update(SQL, name,username, password, balance);

	}

	@Override
	public User getUser(String username) {
		try{
			String SQL = "SELECT * FROM accounts WHERE Username = ?";
			User user = jdbcTemplateObject.queryForObject(SQL, new String[]{username}, new UserMapper());
			return user;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<User> listUsers() {
		String SQL = "SELECT * FROM accounts";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	@Override
	public void delete(String username) {
		String SQL = "DELETE FROM accounts where Username = ?";
		jdbcTemplateObject.update(SQL, username);
		
	}

	@Override
	public void update(String username, Integer balance) {
		String SQL = "UPDATE accounts set Balance = ? WHERE Username = ?";
		jdbcTemplateObject.update(SQL, balance, username);

	}
	
	/**
	 * If it is a duplicate username, the method will return true.
	 * If it is unique, it will return false.
	 */
	@Override
	public boolean checkDuplicate(String username) {
		if(this.getUser(username) == null){
			return false;
		}
		return true;
		
	}

}
