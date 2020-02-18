/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamation;

import FXML.ClassLoaderFXML;
import java.io.IOException;
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
public class EmploiApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(ClassLoaderFXML.class.getResource("TestEmploi.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ReclamationApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        primaryStage.setTitle("Emploi!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
