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

public class AppointmentsModifyController implements Initializable {

    Stage stage;
    Parent scene;

    private static Appointment passedParameters;

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
    private ComboBox<Customer> comboCustomerName;

    @FXML
    private ComboBox<Contact> comboBoxContact;

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
    void onClickButtonAdd(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsAdd.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Add an Appointment");
        stage.show();
    }

    @FXML
    void onClickCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();
    }


    /**
     * If the user updates the Customer name combo box, the Customer ID field is also updated.
     * @param event click on Customer name combo box.
     */
    @FXML
    void onClickCustomerName(ActionEvent event) {
        if(!comboCustomerName.getSelectionModel().getSelectedItem().getName().isEmpty()) {
            labelCustomerID.setText(String.valueOf(comboCustomerName.getSelectionModel().getSelectedItem().getCustomerID()));
        }

    }


    /**
     * Runs validation when the save button is clicked. If validated, confirms the changes with
     * the user and updates the record if the change in confirmed.
     * @param event
     */
    @FXML
    void onClickButtonSave(ActionEvent event) throws IOException {
        //Check if combo boxes have values

        try {
            comboBoxContact.getSelectionModel().getSelectedItem().getContactID();
        }
        catch(NullPointerException e) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.CONTACT_ID_BLANK);
        }

        try {
            comboType.getSelectionModel().getSelectedItem().toLowerCase();
        }
        catch(NullPointerException e) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.TYPE_BLANK);
        }

        try {
            comboCustomerName.getSelectionModel().getSelectedItem().getName();
        }
        catch (NullPointerException e) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.CUSTOMER_BLANK);
        }


        //Pull Values
        String title = textfieldTitle.getText();
        String description = textDescription.getText();
        String location = textFieldLocation.getText();
        int ContactID = comboBoxContact.getSelectionModel().getSelectedItem().getContactID();
        String type = comboType.getSelectionModel().getSelectedItem();
        int CustomerID = comboCustomerName.getSelectionModel().getSelectedItem().getCustomerID();
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

        //Verify the modification
        if(!dialogueHandling.confirmAppointmentModification(A)) {
            //User pressed cancel
            return;
        }

        //Save the modified record
        Scheduler.modifyAppointment(A);

        //Post verification dialogue
        dialogueHandling.confirmationDialogue(dialogueReturnValues.CONFIRM_APPT_MOD_HEADER.toString(), dialogueReturnValues.CONFIRM_APPT_MOD_MESSAGE.toString());

        //Load Appointment Overview
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();

    }


    /**
     * Initializes the Appts Modify Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelAppointmentID.setText(String.valueOf(passedParameters.getAppointmentID()));
        labelCustomerID.setText(String.valueOf(passedParameters.getCustomerID()));
        labelUserID.setText(String.valueOf(passedParameters.getUserID()));
        textDescription.setText(passedParameters.getDescription());
        textFieldLocation.setText(passedParameters.getLocation());
        textfieldTitle.setText(passedParameters.getTitle());

        comboType.setItems(Scheduler.returnAppointmentTypes());
        comboStartTime.setItems(TimeManagement.returnLocalTime());
        comboEndTime.setItems(TimeManagement.returnLocalTime());
        comboCustomerName.setItems(Scheduler.getAllCustomers());
        comboCustomerName.setValue(Scheduler.returnCustomer(passedParameters.getCustomerID()));
        comboBoxContact.setItems(Scheduler.getAllContacts());
        comboBoxContact.setValue(Scheduler.getContactByID(passedParameters.getContactID()));
        comboType.setValue(passedParameters.getType());
        LocalTime start = passedParameters.getStart().toLocalDateTime().toLocalTime();
        comboStartTime.setValue(start);
        LocalTime end = passedParameters.getEnd().toLocalDateTime().toLocalTime();
        comboEndTime.setValue(end);
        dateDatePicker.setValue(passedParameters.getStart().toLocalDate());
    }


}
