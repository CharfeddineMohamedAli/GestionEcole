/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Matiere;
import Entite.Note;
import Entite.Type;
import Entite.User;
import Service.Note_Service;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author nada kd
 */


public class gérer_note_controller implements Initializable {
        Note_Service ns=new Note_Service();
        
         @FXML
    private TableView<Note> tabnote;
  
    
    @FXML
    private TableColumn<Note,Integer> cc;
        @FXML
    private TableColumn<User,String> nom_etud;
     @FXML
    private TextField tfNote;
   
  
    @FXML
    private Button bajouter;
    
    @FXML
    private ComboBox<Type> type;
    
   
    private void afficher_par_matiere(){
     cc.setCellValueFactory(new PropertyValueFactory<Note, Integer>("notes"));
       
       

        try {
         tabnote.getItems().setAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.getItems().addAll(Type.cc,Type.ds,Type.examen);
        // TODO
        


   
        
        
        }
    
       @FXML
     private void ajouter(ActionEvent event) {
        try {
            String text = tfNote.getText();
            
            int notes = Integer.parseInt(text);
            Note_Service sp = new Note_Service();
            Note n = new Note(1,notes,type.getValue());
            sp.ajouterNote(n);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/gérer_note.fxml"));
              try {
                
                Parent root = loader.load();
                gérer_note_controller apc = loader.getController();
                tfNote.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}