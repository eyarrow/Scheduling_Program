package scheduler.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AppointmentsOverviewController {

    @FXML
    private Button buttonAddNewAppointment;

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
    private RadioButton radioAll;

    @FXML
    private ToggleGroup View_by;

    @FXML
    private RadioButton radioWeekly;

    @FXML
    private RadioButton radioMonthly;

    @FXML
    private TableView<?> tableAllAppointments;

    @FXML
    private TableColumn<?, ?> labelAppointmentID;

    @FXML
    private TableColumn<?, ?> labelName;

    @FXML
    private TableColumn<?, ?> labelType;

    @FXML
    private TableColumn<?, ?> labelTitle;

    @FXML
    private TableColumn<?, ?> labelDescription;

    @FXML
    private TableColumn<?, ?> labelLocation;

    @FXML
    private TableColumn<?, ?> labelStartTime;

    @FXML
    private TableColumn<?, ?> labelEndTime;

    @FXML
    private TableColumn<?, ?> labelCustomerID;

    @FXML
    private TableColumn<?, ?> labelUserID;

}
