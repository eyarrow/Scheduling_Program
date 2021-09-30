package scheduler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scheduler.Dao.dbOperations;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //dbOperations.openConnection();
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 552));
        primaryStage.show();
    }

    /**
     * Runs stop application command
     */
    @Override
    public void stop() throws Exception {
        System.out.println("Exiting the Acme Consulting scheduling program. Goodbye!");
        //dbOperations.closeConnection();
    }


    public static void main(String[] args) {
        launch(args);



    }
}
