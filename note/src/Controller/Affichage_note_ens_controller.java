/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Note;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author nada kd
 */
public class Affichage_note_ens_controller implements Initializable {
    
     @FXML private TableView<Note> table;
     @FXML private TableColumn<Note,String> nom_etud;
     @FXML private TableColumn<Note,Integer> prenom_etud;
     @FXML private TableColumn<Note,Integer> cin;
     @FXML private TableColumn<Note,Integer> cc;
     @FXML private TableColumn<Note,Integer> ds;
     @FXML private TableColumn<Note,Integer> exam;
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
