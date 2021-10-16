package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scheduler.model.Appointment;
import scheduler.model.Scheduler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsDetailController implements Initializable {

    Stage stage;
    Parent scene;

    static Appointment passedParameters;

    @FXML
    private Button buttonAddNewAppointment;

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
    private TextField textfieldSearch;

    @FXML
    private Button buttonSearch;

    @FXML
    private Label labelAppointmentTitle;

    @FXML
    private Label labelStartTime;

    @FXML
    private Label labelAppointmentID;

    @FXML
    private Label labelContactName;

    @FXML
    private Label labelType;

    @FXML
    private Label labelDescription;

    @FXML
    private Label labelLocation;

    @FXML
    private Label labelEndTime;

    @FXML
    private Label labelCustomerID;

    @FXML
    private Label labelUserID;

    @FXML
    private Label labelCustomerName;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonModify;

    @FXML
    private Button buttonReturn;

    public static void copyPassedParameters(Appointment A) {
        passedParameters = A;
    }

    @FXML
    void onClickAppointments(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();
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
    void onClickLogOut(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Login.fxml/"));
        stage.setScene(new Scene(scene, 600, 552));
        stage.setTitle("Acme Consulting : Login");
        stage.show();
    }

    @FXML
    void onClickOverview(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Overview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Overview");
        stage.show();
    }

    @FXML
    void onClickReports(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Reports.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Reports");
        stage.show();
    }

    @FXML
    void onClickButtonDelete(ActionEvent event) {

    }

    /**
     * Sends the Appointment object being referenced on the detail page to the Modify Appointment Conroller
     * @param event Click the Modify button
     */
    @FXML
    void onClickButtonModify(ActionEvent event) {

        AppointmentsModifyController.copyPassedParameters(passedParameters);
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsModify.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();

    }

    @FXML
    void onClickButtonReturn(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();
    }

    @FXML
    void onClickButtonAdd(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsAdd.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Add an Appointment");
        stage.show();
    }


    /**
     * Initializes the Appts Detail Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelAppointmentID.setText(String.valueOf(passedParameters.getAppointmentID()));
        labelAppointmentTitle.setText(passedParameters.getTitle());
        labelCustomerID.setText(String.valueOf(passedParameters.getCustomerID()));
        labelContactName.setText(passedParameters.getContactName());
        labelDescription.setText(passedParameters.getDescription());
        labelStartTime.setText(passedParameters.getFormattedStart());
        labelEndTime.setText(passedParameters.getFormattedEnd());
        labelUserID.setText(String.valueOf(passedParameters.getUserID()));
        labelType.setText(passedParameters.getType());
        labelCustomerName.setText(Scheduler.returnCustomerName(passedParameters.getCustomerID()));



    }
}
