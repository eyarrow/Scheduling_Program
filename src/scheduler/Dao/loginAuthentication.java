package scheduler.Dao;

import scheduler.util.dbOperations;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class loginAuthentication {

    //static String USER_AUTHENTICATE = String.format("select * from users where User_Name = '%s' AND Password = '%s'", this.userName, this.password);
    //change this to the correct string after testing.

    /**
     * Determines if the name and password exist in the application database, and that they match.
     * @param userName
     * @param password
     * @return Returns true if the provided username and password match what exists in the database.
     * Returns false if it does not.
     */
    public static boolean authenticateUser (String userName, String password) throws SQLException {
        String USER_AUTHENTICATE = String.format("select * from users where User_Name = '%s' AND Password = '%s'", userName, password);

        ResultSet result = dbOperations.dbQuery(USER_AUTHENTICATE);
        if(result.next() == false) {
            return false;
        }
        return true;
    }




}
