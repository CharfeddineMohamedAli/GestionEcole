package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entite.matiere;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HPAY104-I5-1TR
 */
public class FXMLinterface1Controller implements Initializable {
   @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button ajouter;

    @FXML
    private TableColumn<matiere,String> absence;

    @FXML
    private Button modifier;

    @FXML
    private TextField label1;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TextField label2;

    @FXML
    private TableColumn<matiere, String> matiere;

    @FXML
    private TextField label3;

    @FXML
    private Button actualiser;

    @FXML
    private Button supprimer;

    @FXML
    private TableColumn<matiere, String> justifier;

    @FXML
    private Pane pane;

    @FXML
    private TableColumn<matiere, String> prenom;

    @FXML
    private TableColumn<matiere, String> sceance;

    @FXML
    private TableView<matiere> table;

    @FXML
    void ajout(ActionEvent event) {

    }

    @FXML
    void actualise(ActionEvent event) {

    }

    @FXML
    void modif(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
