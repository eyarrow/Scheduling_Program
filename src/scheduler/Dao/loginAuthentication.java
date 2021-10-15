package scheduler.Dao;

import scheduler.model.Scheduler;
import scheduler.util.dbOperations;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that manages login and authentication, on the data persistence layer.
 */
public abstract class loginAuthentication {



    /**
     * Determines if the name and password exist in the application database, and that they match.
     * @param userName is the userName used for login
     * @param password is the password that corresponds with the entered username.
     * @return Returns true if the provided username and password match what exists in the database.
     * Returns false if it does not.
     */
    public static boolean authenticateUser (String userName, String password) throws SQLException {
        String USER_AUTHENTICATE = String.format("select * from users where User_Name = '%s' AND Password = '%s'", userName, password);

        ResultSet result = dbOperations.dbQuery(USER_AUTHENTICATE);
        if(!result.next()) {
            return false;
        }
        else {
            int User = result.getInt("User_ID");
            Scheduler.setUserID(User);
        }
        return true;
    }




}
