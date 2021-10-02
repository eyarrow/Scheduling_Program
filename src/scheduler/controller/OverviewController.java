package scheduler.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import scheduler.util.MainMenuHelper;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static scheduler.util.MainMenuHelper.logoutMenu;


public class OverviewController implements Initializable {
    Stage stage;
    Parent scene;

    MainMenuHelper menu = new MainMenuHelper();

    @FXML
    private Button buttonOverview;

    @FXML
    private Button buttonCustomers;

    @FXML
    private Button buttonAppointments;

    @FXML
    private Button buttonReports;

    @FXML
    private Button buttonLogout;

    @FXML
    private Label labelApptToday;

    @FXML
    private Label labelAppointTomorrow;

    @FXML
    private Label labelAppointThisWeek;

    @FXML
    void onClickAppointments(ActionEvent event) {

    }

    @FXML
    void onClickCustomers(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        stage.show();
    }

    @FXML
    void onClickLogOut(ActionEvent event) {
        logoutMenu();
    }

    @FXML
    void onClickOverview(ActionEvent event) {

    }

    @FXML
    void onClickReports(ActionEvent event) {

    }

    /**
     * Initializes the Overview Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
