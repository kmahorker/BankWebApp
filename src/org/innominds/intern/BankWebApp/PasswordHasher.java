package org.innominds.intern.BankWebApp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class for password hashing and verification
 * using BCrypt algorithm.
 */
public class PasswordHasher {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    /**
     * Hashes a password using BCrypt
     * 
     * @param plainTextPassword The password to hash
     * @return The hashed password
     */
    public static String hashPassword(String plainTextPassword) {
        if (plainTextPassword == null) {
            return null;
        }
        return passwordEncoder.encode(plainTextPassword);
    }
    
    /**
     * Verifies if a plain text password matches a hashed password
     * 
     * @param plainTextPassword The plain text password to check
     * @param hashedPassword The hashed password to compare against
     * @return true if the password matches, false otherwise
     */
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        if (plainTextPassword == null || hashedPassword == null) {
            return false;
        }
        return passwordEncoder.matches(plainTextPassword, hashedPassword);
    }
}