package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entite.matiere;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *plements Initializable {

 * @author HPAY104-I5-1TR
 */
public class FXMLinterfaceController implements Initializable {

     @FXML
    private AnchorPane content;

    @FXML
    private ComboBox<matiere> choixClasse;

    @FXML
    private Button consulter;

    @FXML
    private Pane pane;

    @FXML
    private Button chercher;

    @FXML
    void search(KeyEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/FXMLinterface1.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }
    
    @FXML
    void consult() throws IOException {
         AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/FXMLinterface2.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }
  

   
    


    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
