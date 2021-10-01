package scheduler.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public abstract class dbOperations {

    //dbConnect - connects to the database
    //dbDisconnect - disconnects from the database
    //dbQuery - passes a query to the database

    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    private static String password = "Passw0rd!"; // Password
    public static Connection connection;  // Connection Interface


    /**
     * Opens a connection to the application database.
     */
    public static void openConnection()
        {
            try {
                Class.forName(driver); // Locate Driver
                connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
                System.out.println("Connection successful!");
            }
            catch(Exception e)
            {
                System.out.println("Error:" + e.getMessage());
            }
        }

    /**
     * Closes the connection to the application database
     */
        public static void closeConnection() {
            try {
                connection.close();
                System.out.println("Connection closed!");
            }
            catch(Exception e)
            {
                System.out.println("Error:" + e.getMessage());
            }
        }

    /**
     *
     * Accepts a SQL Query in the form of a string, and sends that to the application database.
     * @param sqlQuery
     * @return Result set if the query had results, Null if the query had no results.
     */
    public static ResultSet dbQuery(String sqlQuery) {
        return NULL;
    }

    /**
     *
     * Accepts a SQL Update statement in the form of a string and sends that to the application database.
     * @param sqlStatement
     */
    public static void dbUpdate (String sqlStatement) {

    }



}


