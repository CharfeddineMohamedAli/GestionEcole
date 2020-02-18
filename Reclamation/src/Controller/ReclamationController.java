package Controller;

import Entities.Matiere;
import Entities.Note;
import Entities.Reclamation;
import Entities.Type_note_matiere;
import Services.ReclamationService;
import Utils.EtatReclamation;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ReclamationController implements Initializable {
    ReclamationService reclamationService;
    public ReclamationController(){
reclamationService = new ReclamationService();
 try {
            //recherche+ modification + supp
            Reclamation r = reclamationService.rechercherReclamationParID(3);
            if (r != null) {
                r.setEtat(EtatReclamation.Résolu);
                reclamationService.modifierReclamation(r);
                //reclamationService.suprimerReclamation(r);
            }
            //recap
            System.out.println("all: " + reclamationService.getAll());
            System.out.println("user 1: " + reclamationService.getAllParUserID(1));
            //stat
            System.out.println("nb total: " + reclamationService.nbReclamationTotal());
            System.out.println("nb en cours: " + reclamationService.nbReclamationParType(EtatReclamation.En_Cours));
            System.out.println("stat: " + reclamationService.statReclamationParType(EtatReclamation.En_Cours) + "%");

            //System.out.println(reclamationService.existReclamation(3));
        } catch (SQLException ex) {
            Logger.getLogger(TESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       
        
    }
 
    @FXML
    private TableView<Note> NotesEtudiant;

    @FXML
    private TableColumn<Note, Matiere> col_matiere;

    @FXML
    private TableColumn<Note, Integer> col_note;

    @FXML
    private TableColumn<Note, Type_note_matiere> col_type;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<String> list = FXCollections.observableArrayList("Notes","Enseignants","Autres");
    
       
        //NotesEtudiant.setVisible(false);
        typeRec.setItems(list);
       
             //NotesEtudiant.setVisible(true);
             
             
                    
    }
    
private void afficher_par_matiere(){
     col_matiere.setCellValueFactory(new PropertyValueFactory<Note, Matiere>("matiere"));
        col_note.setCellValueFactory(new PropertyValueFactory<Note, Integer>("notes"));
        col_type.setCellValueFactory(new PropertyValueFactory<Note, Type_note_matiere>("type"));

        try {
            NotesEtudiant.getItems().setAll(reclamationService.getNoteParUserID(2, "Math_1"));
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private JFXComboBox<String> typeRec;
  

  @FXML
    void afficher(MouseEvent  event) {
        if(typeRec.getSelectionModel().isEmpty()){
            NotesEtudiant.setVisible(false);
        } else if(typeRec.getSelectionModel().getSelectedItem().matches("Notes")){
            NotesEtudiant.setVisible(true);

    afficher_par_matiere();
}
    }



}
