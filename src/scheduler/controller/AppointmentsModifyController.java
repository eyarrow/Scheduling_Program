package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsModifyController implements Initializable {

    Stage stage;
    Parent scene;

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
    private TextField textfieldTitle;

    @FXML
    private TextField textDescription;

    @FXML
    private Label labelAppointmentID;

    @FXML
    private TextField textFieldName;

    @FXML
    private ComboBox<?> comboType;

    @FXML
    private TextField textFieldLocation;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private ComboBox<?> comboStartTime;

    @FXML
    private ComboBox<?> comboEndTime;

    @FXML
    private Label labelCustomerID;

    @FXML
    private Label labelUserID;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonSave;

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
    void onClickButtonAdd(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsAdd.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Add an Appointment");
        stage.show();
    }


    /**
     * Initializes the Appts Modify Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
