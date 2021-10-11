package scheduler.controller;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scheduler.model.Country;
import scheduler.model.Customer;
import scheduler.model.Division;
import scheduler.model.Scheduler;
import scheduler.util.dialogueReturnValues;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static scheduler.util.dialogueHandling.*;

public class CustomersAddController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Button buttonAddNewCustomer;

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
    private TextField textfieldAddress;

    @FXML
    private TextField textfieldPostalCode;

    @FXML
    private TextField textFieldPhoneNumber;

    @FXML
    private ComboBox<Country> comboCountry;

    @FXML
    private ComboBox<Division> comboDivisionID;

    @FXML
    private Label labelCustomerID;

    @FXML
    private TextField textFieldName;

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

    /**
     * Once a country is picked, the division combo box will be populated with relevant divisions.
     * @param event combo box click
     */
    @FXML
    void onClickCountryCombo(ActionEvent event) {
        if(!comboCountry.itemsProperty().getValue().isEmpty()) {
            Country country = comboCountry.getSelectionModel().getSelectedItem();
            comboDivisionID.setItems(Scheduler.getDivision(country));
        }

    }





    @FXML
    void onClickSave(ActionEvent event) throws IOException {

        if(comboCountry.getSelectionModel().isEmpty() ) {
            displayDialogue(true, dialogueReturnValues.COUNTRY_CODE_BLANK);
            return;
        }
        if(comboDivisionID.getSelectionModel().isEmpty()) {
            displayDialogue(true, dialogueReturnValues.DIVISION_CODE_BLANK);
            return;
        }
        else {
            String name = null;
            String address = null;
            String postal = null;
            String phone = null;
            int country_id = 0;
            int division_id = 0;

                name = textFieldName.getText();
                address = textfieldAddress.getText();
                postal = textfieldPostalCode.getText();
                phone = textFieldPhoneNumber.getText();
                Country country = comboCountry.getValue();
                country_id = country.getCountry_id();
                Division division = comboDivisionID.getValue();
                division_id = division.getDivision_id();
            System.out.println("Division id at assignement is: " + division_id);


                if(validateCustomer(name, address, postal, phone)){
                    Customer C = new Customer(name, address, postal, phone, division_id, country_id);
                    Scheduler.addCustomer(C);

                    confirmCustomerAdded(C);

                    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
                    stage.setScene(new Scene(scene, 1243, 753));
                    stage.setTitle("Acme Consulting : Customers Overview");
                    stage.show();
            }

        }





    }



    @FXML
    void onClickCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        stage.show();
    }


    /**
     * Initializes the Customers Add Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboCountry.setItems(Scheduler.getAllCountries());


    }
}
