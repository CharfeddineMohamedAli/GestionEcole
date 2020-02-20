package reclamation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entities.User;
import FXML.ClassLoaderFXML;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

    public static User u = new User();

    @Override
    public void start(Stage primaryStage) {
        //DataSource.getInstance();

        //StackPane root = new StackPane();
        Parent root = null;
        try {
            root = FXMLLoader.load(ClassLoaderFXML.class.getResource("/FXML/HomeReclamation.fxml"));
            //root.getChildren().add(btn);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        primaryStage.setTitle("Espace Reclamation!");
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
