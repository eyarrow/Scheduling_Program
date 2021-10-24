package scheduler.controller;

import com.google.protobuf.NullValue;
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
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static scheduler.util.dialogueHandling.displayDialogue;

/**
 * Controller for the Modify Customer UI
 */
public class CustomersModifyController implements Initializable {

    Stage stage;
    Parent scene;

    static Customer passedParameters;

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

    /**
     * Function to copy the customer information over to the Modify Screen
     * @param passed is a customer object.
     */
    public static void setPassedParameters(Customer passed) {
        passedParameters = passed;
    }

    /**
     * Clicking on Add new customers loads the Add Customer screen
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickAddNewCustomer(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersAdd.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Add Customer");
        stage.show();
    }

    /**
     * Clicking cancel returns the user to the Customers Overview page.
     * @param event button click
     * @throws IOException
     */
    @FXML
    void onClickCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        stage.show();


    }

    /**
     * Validates entry and saves record as appropriate when the SAVE button is clicked.
     * @param event
     */
    @FXML
    void onClickSave(ActionEvent event) throws IOException {

        String name = textFieldName.getText();
        String address = textfieldAddress.getText();
        String postal = textfieldPostalCode.getText();
        String phone = textFieldPhoneNumber.getText();
        int country;
        int division;
        int CustomerID = passedParameters.getCustomerID();
        try {
            country = comboCountry.getSelectionModel().getSelectedItem().getCountry_id();

        }
        catch (NullPointerException e) {
            displayDialogue(true, dialogueReturnValues.COUNTRY_CODE_BLANK);
            return;
        }

        try {
            division = comboDivisionID.getSelectionModel().getSelectedItem().getDivision_id();
        }
        catch (NullPointerException e) {
            displayDialogue(true, dialogueReturnValues.DIVISION_CODE_BLANK);
            return;
        }
        Customer C = new Customer(CustomerID, name, address, postal, phone, division, country);
        if(dialogueHandling.validateCustomer(name, address, postal, phone)) {
            Scheduler.updateCustomer(C);
            dialogueHandling.confirmCustomerUpdated(C);


            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
            stage.setScene(new Scene(scene, 1243, 753));
            stage.setTitle("Acme Consulting : Customers Overview");
            stage.show();

        }



    }



    /**
     * Main menu item: Loads the appointments screen
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
     * Main menu item: Loads the Customers screen
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
     * Main menu item: Loads the login screen
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
     * Main menu item: Loads the Overview screen
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
     * Main menu item: Loads the report screen
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
     * Once a country is picked, the application with load the applicable division id's that exist within
     * that country.
     * @param event combo box click
     */
    @FXML
    void onClickComboCountry(ActionEvent event) {
        if(!comboCountry.itemsProperty().getValue().isEmpty()) {
            Country country = comboCountry.getSelectionModel().getSelectedItem();
            comboDivisionID.setItems(Scheduler.getDivision(country));
        }
    }


    /**
     * Initializes the Customers Modify Controller. Lamda: Listener for changes to the Country Combo box. If it is modified, the correct list
     * of divisions are listed, and the value of the division is set to null, so that the incorrect division
     * is not inadvertantly saved to a country to which it does not belong. Justification: This is a key control function that disallows invalid input
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Lamda: Listener for changes to the Country Combo box. If it is modified, the correct list
         * of divisions are listed, and the value of the division is set to null, so that the incorrect division
         * is not inadvertantly saved to a country to which it does not belong. Justification: This is a key control
         * function that disallows invalid input
         */
        comboCountry.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldSelection, newSelection) -> {
            if(!comboCountry.itemsProperty().getValue().isEmpty()) {
                Country country = comboCountry.getSelectionModel().getSelectedItem();
                comboDivisionID.setItems(Scheduler.getDivision(country));
                comboDivisionID.setValue(null);
            }
        }));


        labelCustomerID.setText(String.valueOf(passedParameters.getCustomerID()));
        textFieldName.setText(passedParameters.getName());
        textfieldAddress.setText(passedParameters.getAddress());
        textfieldPostalCode.setText(passedParameters.getPostalCode());
        textFieldPhoneNumber.setText(passedParameters.getPhoneNumber());
        comboCountry.setItems(Scheduler.getAllCountries());
        Country C = Scheduler.getCountry(passedParameters.getCountryID());
        comboCountry.setValue(C);
        Division D = Scheduler.getDivision(passedParameters.getDivisionID());
        comboDivisionID.setValue(D);




    }
}
