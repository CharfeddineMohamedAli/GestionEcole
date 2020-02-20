package Controller;

import Entities.Enseignant;
import Entities.Matiere;
import Entities.Note;
import Entities.Reclamation;
import Entities.ReclamationNote;
import Entities.ReclamationProf;
import Entities.Type_note_matiere;
import Entities.User;
import Services.ReclamationService;
import Utils.EtatReclamation;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ReclamationController implements Initializable {

    ReclamationService reclamationService;
    public static ReclamationNote reclamationNote = new ReclamationNote();
    public static ReclamationProf reclamationProf = new ReclamationProf();
    public static Reclamation reclamationAutre = new Reclamation();
    public static User userConnecte = new User(2);
    public static int typeReclamation = -1;

    public ReclamationController() {
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
    private AnchorPane content;
    @FXML
    private TableView<Note> NotesEtudiant;

    @FXML
    private TableColumn<Note, Matiere> col_matiere;

    @FXML
    private TableColumn<Note, Integer> col_note;

    @FXML
    private TableColumn<Note, Type_note_matiere> col_type;

    @FXML
    private TableView<User> tabprof;

    @FXML
    private TableColumn<User, String> firstname;

    @FXML
    private TableColumn<User, String> lastname;

    @FXML
    private TableColumn<User, String> email;

    @FXML
    private TableColumn<User, String> img;

    @FXML
    private TableColumn<User, String> classe;

    @FXML
    private Button btnRec;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnRec.setDisable(true);
        
        reclamationAutre.setUser(userConnecte);

        ObservableList<String> list = FXCollections.observableArrayList("Notes", "Enseignants", "Autres");

        //NotesEtudiant.setVisible(false);
        typeRec.setItems(list);

        typeRec.valueProperty().addListener((observable) -> {
            btnRec.setDisable(true);
            typeReclamation = typeRec.getSelectionModel().getSelectedIndex();

            try {
                //System.out.println("aaaaa");
                if (typeReclamation == 2) {
                    //autre
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AjouterRecNote.fxml"));
                    content.getChildren().clear();
                    content.getChildren().add(newLoadedPane);
                } else {
                    afficherTableView();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //controle saisie
        NotesEtudiant.setOnMouseClicked((event) -> {
            if (NotesEtudiant.getSelectionModel().getSelectedIndex() >= 0) {
                enableBtnReclamer();
            }
        });

        tabprof.setOnMouseClicked((event) -> {
            if (tabprof.getSelectionModel().getSelectedIndex() >= 0) {
                enableBtnReclamer();
            }
        });

        //NotesEtudiant.setVisible(true);
    }

    private void afficher_par_matiere() {
        col_matiere.setCellValueFactory(new PropertyValueFactory<Note, Matiere>("matiere"));
        col_note.setCellValueFactory(new PropertyValueFactory<Note, Integer>("notes"));
        col_type.setCellValueFactory(new PropertyValueFactory<Note, Type_note_matiere>("type"));

        try {
            NotesEtudiant.getItems().setAll(reclamationService.getNoteParUserID(userConnecte.getId_user(), "Math_1"));
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void afficher_par_classe() throws SQLException {
        firstname.setCellValueFactory(new PropertyValueFactory<User, String>("first_Name"));
        lastname.setCellValueFactory(new PropertyValueFactory<User, String>("last_Name"));
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        img.setCellValueFactory(new PropertyValueFactory<User, String>("image_user"));
        classe.setCellValueFactory(new PropertyValueFactory<User, String>("classe"));

        tabprof.getItems().setAll(reclamationService.getUsersByRoleAndClasse("enseignant", "3a7"));

    }

    @FXML
    private JFXComboBox<String> typeRec;

    @FXML
    void afficher(MouseEvent event) throws SQLException {

    }

    private void enableBtnReclamer() {
        btnRec.setDisable(false);
    }

    private void afficherTableView() throws SQLException {
        if (typeRec.getSelectionModel().isEmpty()) {
            NotesEtudiant.setVisible(false);
            tabprof.setVisible(false);
        } else if (typeRec.getSelectionModel().getSelectedItem().matches("Notes")) {
            NotesEtudiant.setVisible(true);
            tabprof.setVisible(false);

            afficher_par_matiere();
        } else if (typeRec.getSelectionModel().getSelectedItem().matches("Enseignants")) {
            NotesEtudiant.setVisible(false);

            tabprof.setVisible(true);
            afficher_par_classe();
        }
    }

    @FXML
    void button_reclamer(ActionEvent event) throws IOException, SQLException {

        if (typeRec.getSelectionModel() != null) {

            AnchorPane newLoadedPane = null;

            if (typeRec.getSelectionModel().getSelectedItem().matches("Notes")) {
                //en fct de user connecté+note selectionée
                reclamationNote.setId_note(NotesEtudiant.getSelectionModel().getSelectedItem().getId_note());
                reclamationNote.setUser(userConnecte);
            } else if (typeRec.getSelectionModel().getSelectedItem().matches("Enseignants")) {
                Enseignant enseignant = reclamationService.findEnsById_user(tabprof.getSelectionModel().getSelectedItem().getId_user());
                System.out.println("prof: " + enseignant);
                reclamationProf.setProf(enseignant);
                reclamationProf.setUser(userConnecte);
            }

            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AjouterRecNote.fxml"));
            content.getChildren().clear();
            content.getChildren().add(newLoadedPane);
        }
    }

}
