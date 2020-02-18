package reclamation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entities.User;
import FXML.ClassLoaderFXML;
import Services.ReclamationService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author KattaX
 */
public class ReclamationApp extends Application {
      public static  User u = new User();

    @Override
    public void start(Stage primaryStage) {
        //DataSource.getInstance();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });

        //StackPane root = new StackPane();
        Parent root = null;
        try {
            root = FXMLLoader.load(ClassLoaderFXML.class.getResource("/FXML/Reclamation.fxml"));
            //root.getChildren().add(btn);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
        
       
    }

}
