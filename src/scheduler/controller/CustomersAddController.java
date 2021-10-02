package scheduler.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersAddController implements Initializable {

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
    private ComboBox<?> comboCountry;

    @FXML
    private ComboBox<?> comboDivisionID;

    @FXML
    private Label labelCustomerID;

    @FXML
    private TextField textFieldName;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonSave;

    /**
     * Initializes the Customers Add Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
