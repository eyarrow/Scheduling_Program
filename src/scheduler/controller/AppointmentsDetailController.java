package scheduler.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsDetailController implements Initializable {

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
    private Button buttonDelete;

    @FXML
    private Button buttonModify;

    @FXML
    private Button buttonReturn;

    /**
     * Initializes the Appts Detail Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
