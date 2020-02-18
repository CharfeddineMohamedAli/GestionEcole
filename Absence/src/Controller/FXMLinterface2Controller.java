package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HPAY104-I5-1TR
 */
public class FXMLinterface2Controller implements Initializable {

   
   

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ImageView img;

    @FXML
    private TableColumn<?, ?> absence;

    @FXML
    private TableColumn<?, ?> justifier;

    @FXML
    private Pane pane;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> prenom;

    @FXML
    private TableColumn<?, ?> sceance;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> matiere;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
