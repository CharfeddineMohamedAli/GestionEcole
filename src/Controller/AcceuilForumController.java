/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.SujetService;
import Utils.UserUniTech;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AcceuilForumController implements Initializable {
    
    SujetService ss = new SujetService();
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
    private HBox Siteweb;
    @FXML
    private JFXTextField logged;
    
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
        if (event.getTarget() == Siteweb) {
            try {
                System.out.println("hhhhhhhh");
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/web.fxml"));
                content.getChildren().clear();
                content.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                Logger.getLogger(AcceuilForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    String musicFile = "D:/silversun.mp3";
    
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
    
    @FXML
    void play(ActionEvent event) {
        mediaPlayer.play();
    }
    
    @FXML
    void stop(ActionEvent event) {
        mediaPlayer.stop();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        logged.setText(UserUniTech.userConnecte.getFirst_Name());
        logged.setEditable(false);
    }
    
}
