package scheduler.model;

import scheduler.Dao.loginAuthentication;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.sql.SQLException;

import static scheduler.Dao.loginAuthentication.authenticateUser;

public class Scheduler {
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
