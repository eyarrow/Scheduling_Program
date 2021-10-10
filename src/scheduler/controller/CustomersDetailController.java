package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scheduler.model.Customer;
import scheduler.model.Scheduler;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomersDetailController implements Initializable {

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
     * A customer is passed from the Customers Overview screen, and displayed on the Customer detail page.
     * @param passed a customer object
     */
    public static void passParameters(Customer passed) {
        passedParameters = passed;
    }

    /**
     * When the "Add new customer" button is clicked it loads the add customer screen
     * @param event click on add customer button
     * @throws IOException for exceptions
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
     * Return to the customer overview page when the button is pressed
     * @param event clicking the "Return to list" button
     * @throws IOException
     */
    @FXML
    void onClickReturnToList(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        stage.show();

    }


    @FXML
    void onClickDelete(ActionEvent event) throws IOException {
        if(dialogueHandling.confirmDeletionCustomer(passedParameters)) {
            Scheduler.deleteCustomer(passedParameters);
            dialogueHandling.informationDialogue(dialogueReturnValues.CUSTOMER_DELETED_HEADER, dialogueReturnValues.CUSTOMER_DELETED_BODY);
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
            stage.setScene(new Scene(scene, 1243, 753));
            stage.setTitle("Acme Consulting : Customers Overview");
            stage.show();
        }
        else {
            return;
        }

    }

    @FXML
    void onClickModify(ActionEvent event) throws IOException {
        CustomersModifyController.setPassedParameters(passedParameters);
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersModify.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Modify Customer");
        stage.show();

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


    /**
     * Initializes the Customers Detail Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelCustomerID.setText(String.valueOf(passedParameters.getCustomerID()));
        labelCustomerName.setText(passedParameters.getName());
        labelAddress.setText(passedParameters.getAddress());
        labelPostalCode.setText(passedParameters.getPostalCode());
        labelPhoneNumber.setText(passedParameters.getPhoneNumber());
        labelCountry.setText(String.valueOf(passedParameters.getCountryID()));
        labelDivisionID.setText(String.valueOf(passedParameters.getCountryID()));

    }

}
