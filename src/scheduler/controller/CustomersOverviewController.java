package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import scheduler.model.Customer;
import scheduler.model.Scheduler;
import javafx.beans.property.*;
import scheduler.util.dialogueHandling;
import scheduler.util.dialogueReturnValues;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomersOverviewController implements Initializable {

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
    private Button buttonOpen;

    @FXML
    private TableView<Customer> tableAllCustomers;

    @FXML
    private TableColumn<Customer, Integer> labelCustomerID;

    @FXML
    private TableColumn<Customer, String> labelName;

    @FXML
    private TableColumn<Customer, String> labelAddress;

    @FXML
    private TableColumn<Customer, String> labelPostalCode;

    @FXML
    private TableColumn<Customer, String> labelPhoneNumber;

    @FXML
    private TableColumn<Customer, Integer> labelCountry;

    @FXML
    private TableColumn<Customer, Integer> labelDivisionID;

    @FXML
    private Label labelNameSelector;

    @FXML
    void onClickCustomerSearch(ActionEvent event) {

    }

    @FXML
    void onClickAddNewCustomer(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersAdd.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Add Customer");
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


    @FXML
    void onClickTableItem(MouseEvent event) throws IOException {

    }



    @FXML
    void onClickButtonOpen(ActionEvent event) throws IOException {
        Customer C = tableAllCustomers.getSelectionModel().getSelectedItem();

        try {
            C.getName();
        }
        catch(NullPointerException e) {
            dialogueHandling.displayDialogue(true, dialogueReturnValues.NO_CUSTOMER_SELECTED);
            return;
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersDetail.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customer Detail");
        stage.show();

    }


    /**
     * Initializes the Customers Overview Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableAllCustomers.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldSelection, newSelection) -> {
           if(!newSelection.getName().isEmpty()) {
                Customer C = tableAllCustomers.getSelectionModel().getSelectedItem();
                CustomersDetailController.passParameters(C);
                String customer = String.format("Click to view details for: %s", C.getName());
                labelNameSelector.setText(customer);

           }

        }));





        tableAllCustomers.setItems(Scheduler.getAllCustomers());

        labelCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        labelName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        labelAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        labelPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        labelPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        labelCountry.setCellValueFactory(new PropertyValueFactory<>("CountryID"));
        labelDivisionID.setCellValueFactory(new PropertyValueFactory<>("DivisionID"));



    }
}
