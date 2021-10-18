package scheduler.controller;

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
import scheduler.model.Reports;
import scheduler.model.Type;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsBreakdownController implements Initializable {

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

    @FXML
    private TableColumn<Type, String> columnAppointmentType;

    @FXML
    private TableColumn<Type, Integer> columnNumOfAppointments;

    @FXML
    private TableView<Type> tableMonthView;

    @FXML
    private TableView<Type> tableTypeView;

    @FXML
    void clickComboReportType(ActionEvent event) throws IOException {
        if (!comboReportType.getSelectionModel().getSelectedItem().isEmpty()) {
            if (comboReportType.getSelectionModel().getSelectedItem().startsWith("Contact Schedules")) {
                stage = (Stage) ((ComboBox) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/scheduler/view/ReportsApptByContact.fxml/"));
                stage.setScene(new Scene(scene, 1243, 753));
                stage.setTitle("Acme Consulting : View Appointments by Contact");
                scene.getStylesheets().add(getClass().getResource("/images/style.css").toExternalForm());
                stage.show();
            }

        }
    }

    @FXML
    void onClickAppointments(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/AppointmentsOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Appointments Overview");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    @FXML
    void onClickCustomers(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/CustomersOverview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Customers Overview");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Login.fxml/"));
        stage.setScene(new Scene(scene, 600, 552));
        stage.setTitle("Acme Consulting : Login");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    @FXML
    void onClickOverview(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Overview.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Overview");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    @FXML
    void onClickReports(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/scheduler/view/Reports.fxml/"));
        stage.setScene(new Scene(scene, 1243, 753));
        stage.setTitle("Acme Consulting : Reports");
        scene.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboReportType.setItems(Reports.returnListOfReportTypes());
        tableTypeView.setItems(Reports.returnTypeAggregates());

        columnAppointmentType.setCellValueFactory(new PropertyValueFactory<>("typeDescription"));
        columnNumOfAppointments.setCellValueFactory(new PropertyValueFactory<>("numberOfOccurences"));

    }

}
