package scheduler.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

    @FXML
    private ComboBox<?> comboReportType;

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
     * Initializes the Reports Controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
