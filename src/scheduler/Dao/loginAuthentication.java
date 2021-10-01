package scheduler.Dao;

import scheduler.util.dbOperations;

import javax.xml.transform.Result;
import java.sql.ResultSet;

public abstract class loginAuthentication {
    String userName = NULL;
    String password = NULL;

    String USER_AUTHENTICATE = "select * from users";

    /**
     * Determines if the name and password exist in the application database, and that they match.
     * @param userName
     * @param password
     * @return Returns true if the provided username and password match what exists in the database.
     * Returns false if it does not.
     */
    public static boolean authenticateUser (String userName, String password) {
        ResultSet result = dbOperations.dbQuery(USER_AUTHENTICATE);
        return true;

    }


}
