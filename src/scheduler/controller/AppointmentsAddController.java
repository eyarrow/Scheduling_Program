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
import scheduler.model.Contact;
import scheduler.model.Customer;
import scheduler.model.Scheduler;
import scheduler.model.TimeManagement;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

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
     * Controls what happens when the "save" button is depressed. Values are used to create an object
     * of Appointment type. Validation is run, and if the input validates then the record is saved.
     * @param event "Save" button is clicked.
     */
    @FXML
    void onClickSave(ActionEvent event) {
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





        String title = textfieldTitle.getText();
        String description = textDescription.getText();
        String location = textDescription.getText();
        int ContactID = comboBoxContact.getSelectionModel().getSelectedItem().getContactID();
        String type = comboBoxType.getSelectionModel().getSelectedItem();
        int CustomerID = comboBoxCustomer.getSelectionModel().getSelectedItem().getCustomerID();
        int UserID = Scheduler.getUserID();



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


        if(TimeManagement.validateBusinessHours(start, end)) {
            System.out.println("All validation passed on time.");
        }
        else {
            return;
        }


    }

    @FXML
    void onClickCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        stage.show();
    }

    @FXML
    void onClickComboBoxCustomer(ActionEvent event) {
        if(!comboBoxCustomer.getSelectionModel().isEmpty()) {
            Customer C = comboBoxCustomer.getSelectionModel().getSelectedItem();
            labelCustomerID.setText(String.valueOf(C.getCustomerID()));
        }

    }

    @FXML
    void onClickComboBoxContact(ActionEvent event) {

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

    }
}
