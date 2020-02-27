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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ParentInterfaceController implements Initializable {

    @FXML
    private AnchorPane list_choix_parent;

    @FXML
    private Button profil;

     @FXML
    private AnchorPane content;


    

    @FXML
    void dashboard_action(ActionEvent event) {
 if (event.getTarget() == profil) {
			try {
				AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/Modifier_profile_parent.fxml"));
				content.getChildren().clear();
				content.getChildren().add(newLoadedPane);
			} catch (IOException ex) {
				Logger.getLogger(EtudiantInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
			}
         }
    }
    
    

    @FXML
    void modifier_user(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
}
