package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scheduler.util.dialogueReturnValues;
import scheduler.util.dialogueHandling;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    //JavaFX objects for stage and scene
    Stage stage;
    Scene scene;


    @FXML
    private TextField textUserID;

    @FXML
    private Button buttonSignIn;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Label labelZoneID;

    @FXML
    void onActionLogin(ActionEvent event) {
        dialogueHandling.informationDialogue(dialogueReturnValues.APPOINTMENT_NOTIFICATION, dialogueReturnValues.NO_APPT_NEXT_15MINUTES);

        //error.displayDialogue(true, dialogueReturnValues.NO_CONTENT);
    }




    /**
     * Initializes the Login Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
