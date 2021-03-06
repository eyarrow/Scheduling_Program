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
import scheduler.model.*;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.util.ResourceBundle;

/**
 * Class to Manage the UI of the "Appointments : Add" screen
 */
public class AppointmentsAddController implements Initializable {

    Stage stage;
    Parent scene;

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
    private ComboBox<String> comboType;

    @FXML
    private TextField textFieldLocation;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private ComboBox<LocalTime> comboStartTime;

    @FXML
    private ComboBox<LocalTime> comboEndTime;

    @FXML
    private Label labelCustomerID;

    @FXML
    private Label labelUserID;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonSave;

    @FXML
    private ComboBox<Contact> comboBoxContact;

    @FXML
    private ComboBox<Customer> comboBoxCustomer;

    @FXML
    private ComboBox<String> comboBoxType;

    /**
     * Navigates the user to the Appointments screen when they click on the APPOINTMENT button on the main menu
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickAppointments(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();
    }

    /**
     * Navigates the user to the Customers screen when they click on the CUSTOMER button on the main menu
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickCustomers(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        stage.show();
    }

    /**
     * Navigates the user to the Login page where they are automatically logged out, when they click on the LOGOUT button on the main menu. They can choose to either login again, or exit the application from the login screen.
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Login.fxml/"));
        stage.setScene(new Scene(scene, 600, 552));
        stage.setTitle("Acme Consulting : Login");
        stage.show();
    }

    /**
     * Navigates the user to the Overview page, when they click on the OVERVIEW button on the main menu.
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickOverview(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Overview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Overview");
        stage.show();
    }

    /**
     * Navigates the user to the Reports page, when they click on the REPORTS button on the main menu.
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickReports(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Reports.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Reports");
        stage.show();
    }

    /**
     * Controls what happens when the "save" button is clicked. Values are used to create an object
     * of Appointment type. Validation is run, and if the input validates then the record is saved.
     * @param event "Save" button is clicked.
     */
    @FXML
    void onClickSave(ActionEvent event) throws IOException {
        //Check if combo boxes have values
        if(comboBoxContact.getSelectionModel().isEmpty()) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.CONTACT_ID_BLANK);
            return;
        }

        if(comboBoxType.getSelectionModel().isEmpty()) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.TYPE_BLANK);
            return;
        }

        if(comboBoxCustomer.getSelectionModel().isEmpty()) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.CUSTOMER_BLANK);
            return;
        }

        if(comboStartTime.getSelectionModel().isEmpty()) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.START_TIME_BLANK);
            return;
        }

        if(comboEndTime.getSelectionModel().isEmpty()) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.END_TIME_BLANK);
            return;
        }

        //Pull Values
        String title = textfieldTitle.getText();
        String description = textDescription.getText();
        String location = textFieldLocation.getText();
        int ContactID = comboBoxContact.getSelectionModel().getSelectedItem().getContactID();
        String type = comboBoxType.getSelectionModel().getSelectedItem();
        int CustomerID = comboBoxCustomer.getSelectionModel().getSelectedItem().getCustomerID();
        int UserID = Scheduler.getUserID();

        //Validation of String values
        if(!dialogueHandling.validateAppointment(title, description, location)) {
            return;
        }

        //managing Date entry
        LocalDate appointment_date = dateDatePicker.getValue();
        LocalTime start_time = comboStartTime.getSelectionModel().getSelectedItem();
        LocalTime end_time = comboEndTime.getSelectionModel().getSelectedItem();
        LocalDateTime start;
        LocalDateTime end;
        try {
            start = start_time.atDate(appointment_date);
            end = end_time.atDate(appointment_date);
        }
        catch(NullPointerException e) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.DATE_BLANK);
            return;
        }

        // Time & Date validation
        if(!TimeManagement.validateBusinessHours(start, end)) {
            return;
        }


        ZonedDateTime startZoned = ZonedDateTime.of(start, ZoneId.systemDefault());
        ZonedDateTime endZoned = ZonedDateTime.of(end, ZoneId.systemDefault());

        Appointment A = new Appointment(title, description, location, ContactID, type, startZoned, endZoned, CustomerID, Scheduler.getUserID());

        //Confirm there are no overlaps
        Appointment Overlap = TimeManagement.checkAppointmentTimeOverlap(0, CustomerID, startZoned.toLocalDateTime(), endZoned.toLocalDateTime());
        if(Overlap.getAppointmentID() != 0) {
            dialogueHandling.appointmentSchedulingConflict(Overlap, A);
            return;
        }

        Scheduler.addAppointment(A);

        //Confirmation Dialogue
        dialogueHandling.confirmAppointmentAdded(A);

        //Load Appointment Overview
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();

    }

    /**
     * Loads the Appointment overview screen when the user cancels
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();
    }

    /**
     * Sets the label value for customer id when the user selects or updates the Customer name from the dropdown box.
     * @param event combo box click
     */
    @FXML
    void onClickComboBoxCustomer(ActionEvent event) {
        if(!comboBoxCustomer.getSelectionModel().isEmpty()) {
            Customer C = comboBoxCustomer.getSelectionModel().getSelectedItem();
            labelCustomerID.setText(String.valueOf(C.getCustomerID()));
        }

    }

    @FXML
    void onClickComboBoxContact(ActionEvent event) {
        //currently not in use
    }





    /**
     * Initializes the Appts Add Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBoxContact.setItems(Scheduler.getAllContacts());
        comboBoxCustomer.setItems(Scheduler.getAllCustomers());
        comboBoxType.setItems(Scheduler.returnAppointmentTypes());

        TimeManagement.populateDateTimes();
        comboStartTime.setItems(TimeManagement.returnLocalTime());
        comboEndTime.setItems(TimeManagement.returnLocalTime());
        labelUserID.setText(String.valueOf(Scheduler.getUserID()));

    }
}
