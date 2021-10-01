package scheduler.model;

import scheduler.Dao.loginAuthentication;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.sql.SQLException;

import static scheduler.Dao.loginAuthentication.authenticateUser;

/**
 *
 */
public class Scheduler {

    /**
     * Authenticates a user based on their username and password. Uses the DAO package to handle
     * backend operations. Displays Appointment alerts or error messaging as appropriate.
     * @param username
     * @param password
     * @return boolean is true if the user / password combination authenticates. Returns false if
     * it does not.
     * @throws SQLException
     */
    public boolean loginToApplication (String username, String password) throws SQLException {
        boolean success = authenticateUser(username, password);

        if(success) {
            dialogueHandling.informationDialogue(dialogueReturnValues.APPOINTMENT_NOTIFICATION, dialogueReturnValues.NO_APPT_NEXT_15MINUTES);
            return true;
        }
        else {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.WRONG_PASSWORD);
            return false;

        }
    }
}
