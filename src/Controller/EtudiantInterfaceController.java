/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author admin
 */
public class EtudiantInterfaceController implements Initializable{

    @FXML
    private AnchorPane content3;

    @FXML
    private AnchorPane content;

    @FXML
    private Button update_profile;

    @FXML
    private Button see_marks;

    @FXML
    private Button student_absences;

    @FXML
    private Button publier;

    @FXML
    private Button reclamation;

    @FXML
    private Button stage;

    @FXML
    void dashboard_action(ActionEvent event) {
  if (event.getTarget() == update_profile) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/Modifier_profile_etudiant.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(EtudiantInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        
    }
    
}
