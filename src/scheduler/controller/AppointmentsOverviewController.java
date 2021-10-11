package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import scheduler.model.Appointment;
import scheduler.model.Scheduler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsOverviewController implements Initializable {
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
    private RadioButton radioAll;

    @FXML
    private ToggleGroup View_by;

    @FXML
    private RadioButton radioWeekly;

    @FXML
    private RadioButton radioMonthly;

    @FXML
    private TableView<Appointment> tableAllAppointments;

    @FXML
    private TableColumn<Appointment, ?> labelAppointmentID;

    @FXML
    private TableColumn<Appointment, ?> labelName;

    @FXML
    private TableColumn<Appointment, ?> labelType;

    @FXML
    private TableColumn<Appointment, ?> labelTitle;

    @FXML
    private TableColumn<Appointment, ?> labelDescription;

    @FXML
    private TableColumn<Appointment, ?> labelLocation;

    @FXML
    private TableColumn<Appointment, ?> labelStartTime;

    @FXML
    private TableColumn<Appointment, ?> labelEndTime;

    @FXML
    private TableColumn<Appointment, ?> labelCustomerID;

    @FXML
    private TableColumn<Appointment, ?> labelUserID;

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


    /**
     * Initializes the Appts Overview Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableAllAppointments.setItems(Scheduler.getAllAppointments());

        labelAppointmentID.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        labelName.setCellValueFactory(new PropertyValueFactory<>(""));

    }

}
