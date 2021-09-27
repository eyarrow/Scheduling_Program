package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scheduler.util.dialogueReturnValues;
import scheduler.util.errorHandling;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    //JavaFX objects for stage and scene
    Stage stage;
    Scene scene;

    //Instantiate object declaration for error handling
    errorHandling error = new errorHandling();

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
        error.displayDialogue(false, dialogueReturnValues.NO_CONTENT);
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
