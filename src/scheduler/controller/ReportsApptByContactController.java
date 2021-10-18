package scheduler.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import scheduler.model.Appointment;
import scheduler.model.Contact;
import scheduler.model.Reports;
import scheduler.model.Scheduler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsApptByContactController implements Initializable {

    Stage stage;
    Parent scene;
    ObservableList<Appointment> appointmentByContact;

    @FXML
    private ComboBox<String> comboReportType;

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
    private ComboBox<Contact> comboContacts;

    @FXML
    private TableView<Appointment> tableAppointments;

    @FXML
    private TableColumn<Appointment, Integer> columnApptID;

    @FXML
    private TableColumn<Appointment, String> columnTitle;

    @FXML
    private TableColumn<Appointment, String> columnType;

    @FXML
    private TableColumn<Appointment, String> columnDescription;

    @FXML
    private TableColumn<Appointment, String> columnStart;

    @FXML
    private TableColumn<Appointment, String> columnEnd;

    @FXML
    private TableColumn<Appointment, Integer> columnCustomerID;

    @FXML
    void clickComboContacts(ActionEvent event) {
        if(!comboContacts.getSelectionModel().isEmpty()) {
            Contact C = comboContacts.getSelectionModel().getSelectedItem();
            appointmentByContact = Reports.appointmentByContact(C.getContactID());
            tableAppointments.setItems(appointmentByContact);
            columnApptID.setCellValueFactory(new PropertyValueFactory<>("AppointmentID"));
            columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
            columnStart.setCellValueFactory(new PropertyValueFactory<>("start"));
            columnEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
            columnCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));

        }
    }

    @FXML
    void onClickAppointments(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    void onClickCustomers(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Login.fxml/"));
        stage.setScene(new Scene(scene, 600, 552));
        stage.setTitle("Acme Consulting : Login");
        scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    void onClickOverview(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Overview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Overview");
        scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    void onClickReports(ActionEvent event) throws IOException {
        if (!comboReportType.getSelectionModel().getSelectedItem().isEmpty()) {
            if (comboReportType.getSelectionModel().getSelectedItem().startsWith("Number of Appointments")) {
                stage = (Stage) ((ComboBox) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/scheduler/view/ReportsBreakdown.fxml/"));
                stage.setScene(new Scene(scene, 1243, 753));
                stage.setTitle("Acme Consulting : View by Type and Month");
                scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
                stage.show();
            }

        }
    }

    @FXML
    void onClickReportType(ActionEvent event) throws IOException {
        if (!comboReportType.getSelectionModel().getSelectedItem().isEmpty()) {
            if (comboReportType.getSelectionModel().getSelectedItem().startsWith("Number of Appointments")) {
                stage = (Stage) ((ComboBox) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/scheduler/view/ReportsBreakdown.fxml/"));
                stage.setScene(new Scene(scene, 1243, 753));
                stage.setTitle("Acme Consulting : View by Type and Month");
                scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
                stage.show();
            }

        }
    }


        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            comboReportType.setItems(Reports.returnListOfReportTypes());
            comboContacts.setItems(Scheduler.getAllContacts());

        }

    }


