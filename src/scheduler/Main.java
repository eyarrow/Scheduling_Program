package scheduler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scheduler.model.Scheduler;
import scheduler.util.dbOperations;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        primaryStage.setTitle("Acme Consulting : Login ");
        primaryStage.setScene(new Scene(root, 600, 552));
        //root.getStylesheets().add( getClass().getResource( "/images/style.css" ).toExternalForm() );
        //root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.show();
        dbOperations.openConnection();

    }




    public static void main(String[] args) {
        launch(args);


        dbOperations.closeConnection();
    }
}
