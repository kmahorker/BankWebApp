package org.innominds.intern.BankWebApp.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.innominds.intern.BankWebApp.Original.User;

public class UserMapper implements RowMapper<User> {

	/**
	 * Sets the fields of a User object to that of the ResultSet.
	 */
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setName(rs.getString("Name"));
		user.setUsername(rs.getString("Username"));
		user.setPassword(rs.getString("Password"));
		user.setBalance(rs.getInt("Balance"));
		return user;
	}

}
