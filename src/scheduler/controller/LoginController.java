package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scheduler.model.Scheduler;
import scheduler.model.TimeManagement;
import scheduler.util.dialogueHandling;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    //JavaFX objects for stage and scene
    Stage stage;
    Parent scene;


    @FXML
    private TextField textUserID;

    @FXML
    private Button buttonSignIn;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Label labelZoneID;

    @FXML
    void onActionLogin(ActionEvent event) throws SQLException, IOException {
        //Capture user name and password from fields
        String user = textUserID.getText();
        String password = textPassword.getText();
        boolean success = false;

        //uses error checking to see if the username and password fields are populated.
        //will break from the function if not, so the user can re-enter information
        if (dialogueHandling.checkAuthentication(user, password) == false ) {
           return;
        }

        Scheduler login = new Scheduler();
        if(login.loginToApplication(user, password) == false ) {
            return;
        }
        else {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Overview.fxml/"));
            stage.setScene(new Scene(scene, 1243, 753));
            stage.setTitle("Acme Consulting : Overview");
            stage.show();
        }

    }




    /**
     * Initializes the Login Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String zoneID = String.format("Zone ID: %s", TimeManagement.returnZoneIDString());
        labelZoneID.setText(zoneID);
    }
}
