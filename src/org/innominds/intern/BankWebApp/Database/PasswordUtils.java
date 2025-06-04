package org.innominds.intern.BankWebApp.Database;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utility class for handling password hashing and verification.
 * Uses BCrypt for secure password storage.
 * 
 * @author Tembo
 */
public class PasswordUtils {
    
    /**
     * Hashes a password using BCrypt with a randomly generated salt.
     * 
     * @param plainTextPassword The password to hash
     * @return The hashed password
     */
    public static String hashPassword(String plainTextPassword) {
        if (plainTextPassword == null) {
            return null;
        }
        
        // Generate a salt with a cost factor of 12
        String salt = BCrypt.gensalt(12);
        
        // Hash the password with the salt
        return BCrypt.hashpw(plainTextPassword, salt);
    }
    
    /**
     * Checks if a plain text password matches a hashed password.
     * 
     * @param plainTextPassword The plain text password to check
     * @param hashedPassword The hashed password to check against
     * @return true if the passwords match, false otherwise
     */
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        if (plainTextPassword == null || hashedPassword == null) {
            return false;
        }
        
        // Check if the plain text password matches the hashed password
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}