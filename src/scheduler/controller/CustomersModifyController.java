package scheduler.controller;

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
import scheduler.model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
     *
     * @param event
     */
    @FXML
    void onClickSave(ActionEvent event) {

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
     * Initializes the Customers Modify Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelCustomerID.setText(String.valueOf(passedParameters.getCustomerID()));
        textFieldName.setText(passedParameters.getName());
        textfieldAddress.setText(passedParameters.getAddress());
        textfieldPostalCode.setText(passedParameters.getPostalCode());
        textFieldPhoneNumber.setText(passedParameters.getPhoneNumber());


    }
}
