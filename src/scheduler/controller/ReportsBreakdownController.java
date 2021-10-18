package scheduler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportsBreakdownController implements Initializable {

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

    @FXML
    private TableColumn<?, ?> columnAppointmentType;

    @FXML
    private TableColumn<?, ?> columnNumOfAppointments;

    @FXML
    void clickComboReportType(ActionEvent event) {

    }

    @FXML
    void onClickAppointments(ActionEvent event) {

    }

    @FXML
    void onClickCustomers(ActionEvent event) {

    }

    @FXML
    void onClickLogOut(ActionEvent event) {

    }

    @FXML
    void onClickOverview(ActionEvent event) {

    }

    @FXML
    void onClickReports(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
