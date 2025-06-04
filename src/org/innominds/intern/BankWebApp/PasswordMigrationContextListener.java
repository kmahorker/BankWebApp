package org.innominds.intern.BankWebApp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.innominds.intern.BankWebApp.Database.PasswordMigrationUtil;

/**
 * Application Lifecycle Listener implementation class for password migration.
 * This listener runs once when the application starts to migrate plain text passwords to hashed passwords.
 * 
 * @author Tembo
 */
@WebListener
public class PasswordMigrationContextListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public PasswordMigrationContextListener() {
        // Default constructor
    }

    /**
     * Called when the application is being started.
     * Triggers the password migration process.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Run the password migration to convert plain text passwords to hashed passwords
            PasswordMigrationUtil.migratePasswords();
            System.out.println("Password migration completed successfully");
        } catch (Exception e) {
            System.err.println("Error during password migration: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Called when the application is being shut down.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No action needed on shutdown
    }
}