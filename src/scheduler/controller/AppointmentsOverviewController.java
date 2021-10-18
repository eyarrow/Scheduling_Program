package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import scheduler.model.Appointment;
import scheduler.model.Customer;
import scheduler.model.Scheduler;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    private Button buttonDetail;

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
    private TableColumn<Appointment, Integer> labelAppointmentID;

    @FXML
    private TableColumn<Appointment, String> labelName;

    @FXML
    private TableColumn<Appointment, String> labelType;

    @FXML
    private TableColumn<Appointment, String> labelTitle;

    @FXML
    private TableColumn<Appointment, String> labelDescription;

    @FXML
    private TableColumn<Appointment, String> labelLocation;

    @FXML
    private TableColumn<Appointment, ZonedDateTime> labelStartTime;

    @FXML
    private TableColumn<Appointment, ZonedDateTime> labelEndTime;

    @FXML
    private TableColumn<Appointment, Integer> labelCustomerID;

    @FXML
    private TableColumn<Appointment, Integer> labelUserID;

    @FXML
    private Label labelAppointmentMessage;

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
    void onClickButtonDetail(ActionEvent event) throws IOException, InvocationTargetException {

        Appointment A = tableAllAppointments.getSelectionModel().getSelectedItem();

        try {
            A.getLocation();
        }
        catch(NullPointerException e) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.NO_APPOINTMENT_SELECTED);
            return;
        }


        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsDetail.fxml/"));
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

    @FXML
    void onClickRadioAll(ActionEvent event) {
        tableAllAppointments.setItems(Scheduler.getAllAppointments());

        labelAppointmentID.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        labelCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        labelDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        labelLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        labelType.setCellValueFactory(new PropertyValueFactory<>("type"));
        labelStartTime.setCellValueFactory(new PropertyValueFactory<>("FormattedStart"));
        labelEndTime.setCellValueFactory(new PropertyValueFactory<>("FormattedEnd"));
        labelUserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        labelTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        labelName.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
    }

    @FXML
    void onClickRadioMonth(ActionEvent event) {
        tableAllAppointments.setItems(Scheduler.returnAppointmentsByDayInterval(30));

        labelAppointmentID.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        labelCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        labelDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        labelLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        labelType.setCellValueFactory(new PropertyValueFactory<>("type"));
        labelStartTime.setCellValueFactory(new PropertyValueFactory<>("FormattedStart"));
        labelEndTime.setCellValueFactory(new PropertyValueFactory<>("FormattedEnd"));
        labelUserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        labelTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        labelName.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
    }

    @FXML
    void onClickRadioWeek(ActionEvent event) {
        tableAllAppointments.setItems(Scheduler.returnAppointmentsByDayInterval(7));

        labelAppointmentID.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        labelCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        labelDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        labelLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        labelType.setCellValueFactory(new PropertyValueFactory<>("type"));
        labelStartTime.setCellValueFactory(new PropertyValueFactory<>("FormattedStart"));
        labelEndTime.setCellValueFactory(new PropertyValueFactory<>("FormattedEnd"));
        labelUserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        labelTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        labelName.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
    }


    /**
     * Initializes the Appts Overview Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Lambda Expression - Listener for when a value on the Table View is clicked. When a value is clicked
         * a label at the top of the page changes to the reflect the Appointment ID. It also sets up
         * passed parameters for the Appointment object, which can be used to populate that customer's information on
         * the detail screen.
         */
        tableAllAppointments.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldSelection, newSelection) -> {
            if(!newSelection.getLocation().isEmpty()) {
                Appointment A = tableAllAppointments.getSelectionModel().getSelectedItem();
                AppointmentsDetailController.copyPassedParameters(A);
                String appointment = String.format("Click to view details for Appointment ID: %x", A.getAppointmentID());
                labelAppointmentMessage.setText(appointment);

                AppointmentsDetailController.copyPassedParameters(A);

            }

        }));

        labelAppointmentMessage.setText("Click on an appointment below to select it...");
        tableAllAppointments.setItems(Scheduler.getAllAppointments());

        labelAppointmentID.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
        labelCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        labelDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        labelLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        labelType.setCellValueFactory(new PropertyValueFactory<>("type"));
        labelStartTime.setCellValueFactory(new PropertyValueFactory<>("FormattedStart"));
        labelEndTime.setCellValueFactory(new PropertyValueFactory<>("FormattedEnd"));
        labelUserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        labelTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        labelName.setCellValueFactory(new PropertyValueFactory<>("ContactName"));


    }

}
