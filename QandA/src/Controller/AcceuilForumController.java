/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AcceuilForumController implements Initializable {
    
    @FXML
    private Pane content;
    @FXML
    private HBox id_afficherTous;
    @FXML
    private HBox id_ajouter;
    @FXML
    private HBox id_afficherMesSujets;
    @FXML
    private HBox id_statistique;

 
    @FXML
    void btn_afficherTous(MouseEvent event) {
         if (event.getTarget() == id_afficherTous) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AffichageForum.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
         
         if (event.getTarget() == id_ajouter) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AjoutSujet.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
         if (event.getTarget() == id_afficherMesSujets) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/MesSujets.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
         
         if (event.getTarget() == id_statistique) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/s.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
         
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
