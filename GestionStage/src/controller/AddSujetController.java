/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entites.Branche;
import entites.Stage;
import services.StageService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AddSujetController implements Initializable {
    public static StageService ss= new StageService();
   @FXML
    private AnchorPane anchorpane;

    @FXML
    private TextArea description;
    @FXML
    private Button ajouter;
    @FXML
    private ComboBox<Branche> branche;
    @FXML
    private TextField sujet;

     @FXML
    void add(ActionEvent event) throws SQLException {
        Stage stage=new Stage();
        stage.setDescription(description.getText());
        stage.setSujet(sujet.getText());
        stage.setId_user(1);
        stage.setId_stage(2);
        stage.setBranche(branche.getValue());
        
        
        ss.ajouterStage(stage);
        description.clear();

    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       branche.getItems().addAll(Branche.Business,Branche.Data_science,Branche.Génie_logiciel,Branche.Informatque,Branche.Sécurité,Branche.intelligence);
    }    
    
}
