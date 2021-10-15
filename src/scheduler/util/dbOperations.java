package scheduler.util;

import java.sql.*;

/**
 * Manages all direct connections with the database.
 */
public abstract class dbOperations {


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
     *
     * Returns the current open connection for use in queries
      * @return the connection to the application database.
     */
   public static Connection getConnection() {
        return connection;
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
                //do nothing. At this point the program is closing, this is not an actionable error.
            }
        }


    /**
     *
     * Accepts a SQL Query in the form of a string, and sends that to the application database.
     * @param sqlQuery
     * @return Result set if the query had results, Null if the query had no results.
     */
    public static ResultSet dbQuery(String sqlQuery) throws SQLException {
        try {
            PreparedStatement ps = dbOperations.getConnection().prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * Accepts a SQL Update statement in the form of a string and sends that to the application database.
     * @param sqlStatement
     */
    public static void dbUpdate (String sqlStatement) {
        try {
            PreparedStatement ps = dbOperations.getConnection().prepareStatement(sqlStatement);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



}


