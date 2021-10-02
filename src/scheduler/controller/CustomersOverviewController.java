package scheduler.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersOverviewController implements Initializable {

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
    private TableView<?> tableAllCustomers;

    @FXML
    private TableColumn<?, ?> labelCustomerID;

    @FXML
    private TableColumn<?, ?> labelName;

    @FXML
    private TableColumn<?, ?> labelAddress;

    @FXML
    private TableColumn<?, ?> labelPostalCode;

    @FXML
    private TableColumn<?, ?> labelPhoneNumber;

    @FXML
    private TableColumn<?, ?> labelCountry;

    @FXML
    private TableColumn<?, ?> labelDivisionID;

    /**
     * Initializes the Customers Overview Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
