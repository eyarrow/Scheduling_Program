package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import scheduler.model.Reports;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for the Reports Overview UI
 */
public class ReportsController implements Initializable {

    Stage stage;
    Parent scene;

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

    /**
     * Navigates the user to the Appointments screen when they click on the APPOINTMENT button on the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void onClickAppointments(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    /**
     * Navigates the user to the Customers screen when they click on the CUSTOMER button on the main menu
     * @param event
     * @throws IOException
     */
    @FXML
    void onClickCustomers(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    /**
     * Navigates the user to the Login page where they are automatically logged out, when they click on the LOGOUT button on the main menu. They can choose to either login again, or exit the application from the login screen.
     * @param event
     * @throws IOException
     */
    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Login.fxml/"));
        stage.setScene(new Scene(scene, 600, 552));
        stage.setTitle("Acme Consulting : Login");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    /**
     * Navigates the user to the Overview page, when they click on the OVERVIEW button on the main menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void onClickOverview(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Overview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Overview");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    /**
     * Navigates the user to the Reports page, when they click on the REPORTS button on the main menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void onClickReports(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Reports.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Reports");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    /**
     * Loads the appropriate report type when the combo box is clicked.
     * @param event
     * @throws IOException
     */
    @FXML
    void onClickReportType(ActionEvent event) throws IOException {
        if(!comboReportType.getSelectionModel().getSelectedItem().isEmpty()) {
            if(comboReportType.getSelectionModel().getSelectedItem().startsWith("Number of Appointments")) {
                stage = (Stage)((ComboBox)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/scheduler/view/ReportsBreakdown.fxml/"));
                stage.setScene(new Scene(scene, 1243, 753));
                stage.setTitle("Acme Consulting : View by Type and Month");
                scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
                stage.show();
            }
            else {
                stage = (Stage) ((ComboBox) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/scheduler/view/ReportsApptByContact.fxml/"));
                stage.setScene(new Scene(scene, 1243, 753));
                stage.setTitle("Acme Consulting : View Appointments by Contact");
                scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
                stage.show();
            }

        }

    }


    /**
     * Initializes the Reports Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboReportType.setItems(Reports.returnListOfReportTypes());

    }
}
