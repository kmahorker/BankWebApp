package org.innominds.intern.BankWebApp.Database;

import java.util.List;

import org.innominds.intern.BankWebApp.Original.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Utility class for migrating existing plain text passwords to hashed passwords.
 * This class is intended to be used once during the application upgrade.
 * 
 * @author Tembo
 */
public class PasswordMigrationUtil {
    
    /**
     * Migrates all existing plain text passwords in the database to hashed passwords.
     * This method should be called once during application startup after the upgrade.
     */
    public static void migratePasswords() {
        // Get database access
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserJdbcTemplate userJdbc = (UserJdbcTemplate) context.getBean("UserJdbcTemplate");
        
        // Get all users
        List<User> users = userJdbc.listUsers();
        
        // Update each user's password to a hashed version
        for (User user : users) {
            String plainTextPassword = user.getPassword();
            
            // Only hash passwords that aren't already hashed
            if (plainTextPassword != null && !isAlreadyHashed(plainTextPassword)) {
                String hashedPassword = PasswordUtils.hashPassword(plainTextPassword);
                
                // Update the password in the database
                updateUserPassword(userJdbc, user.getUsername(), hashedPassword);
            }
        }
    }
    
    /**
     * Updates a user's password in the database directly.
     * 
     * @param userJdbc The JDBC template
     * @param username The username of the user
     * @param hashedPassword The new hashed password
     */
    private static void updateUserPassword(UserJdbcTemplate userJdbc, String username, String hashedPassword) {
        JdbcTemplate jdbcTemplate = userJdbc.getJdbcTemplateObject();
        String SQL = "UPDATE accounts SET Password = ? WHERE Username = ?";
        jdbcTemplate.update(SQL, hashedPassword, username);
    }
    
    /**
     * Basic check to determine if a password is already hashed with BCrypt.
     * BCrypt hashed passwords typically start with "$2a$", "$2b$", or "$2y$".
     * 
     * @param password The password to check
     * @return true if the password appears to be hashed, false otherwise
     */
    private static boolean isAlreadyHashed(String password) {
        return password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$");
    }
}