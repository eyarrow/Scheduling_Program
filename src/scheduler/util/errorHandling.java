package scheduler.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class errorHandling {

    /**
     *
     * Used to display basic alert and confirmation dialogues to the user. Errors and confirmation
     * messages are displayed in the type of dialogue indicated by the boolean parameter. This function
     * assumes that the message is a single string, that does not require formatting.
     * @param error a true value will display an "Error" dialogue. A false value will result
     *              in a "Confirmation" dialogue being displayed.
     * @param code  an enum value that will be used to display the correct feedback in the dialogue
     *              box. It is used to insert the appropriate string
     * @return boolean is set to true if the user responded with "Ok" in the confirmation dialogue.
     * Both error dialogue and cancel responses for a confirmation dialogue will return a false boolean.
     *
     */
    public boolean displayDialogue(boolean error, dialogueReturnValues code) {
        if(error) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(code.toString());
            alert.showAndWait();
            return false;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, code.toString());
            alert.setTitle("Please confirm?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                return true;
            }
            else {
                return false;
            }
        }
}


}
