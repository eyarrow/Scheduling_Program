package scheduler.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classes that are used to navigate and implement functionality for the main menu that is common
 * across multiple UI Screens
 */
public class MainMenuHelper {

    private Stage stage;
    private Parent scene;

    public static void logoutMenu() {
        if(dialogueHandling.displayDialogue(false, dialogueReturnValues.APPLICATION_EXIT)) {
            Platform.exit();
        }
    }

//    public void customersMenu() throws IOException {
//        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
//        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
//        stage.setScene(new Scene(scene, 1243, 753));
//        stage.setTitle("Acme Consulting : Customers Overview");
//        stage.show();
//    }
}
