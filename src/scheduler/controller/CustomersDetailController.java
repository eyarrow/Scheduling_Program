package scheduler.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersDetailController implements Initializable {
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
    private Label labelCustomerName;

    @FXML
    private Label labelCustomerID;

    @FXML
    private Label labelAddress;

    @FXML
    private Label labelPostalCode;

    @FXML
    private Label labelPhoneNumber;

    @FXML
    private Label labelCountry;

    @FXML
    private Label labelDivisionID;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonModify;

    @FXML
    private Button buttonReturn;

    /**
     * Initializes the Customers Detail Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
