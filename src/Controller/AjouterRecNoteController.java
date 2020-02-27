/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.ReclamationService;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class AjouterRecNoteController implements Initializable {

    ReclamationService reclamationService;

    public AjouterRecNoteController() {
        reclamationService = new ReclamationService();
    }

    @FXML
    private TextField id_champ;

    @FXML
    private Button envoie;

    @FXML
    private JFXTextField subjectTxt;

    @FXML
    void envoyer(ActionEvent event) throws SQLException {

        //ReclamationController rc = new ReclamationController();
        //controle saisie
        if (id_champ.getText() != null && !id_champ.getText().trim().equals("")) {

            switch (ReclamationController.typeReclamation) {
                case 0:
                    ReclamationController.reclamationNote.setDesc(id_champ.getText());
                    reclamationService.ajouterReclamationNote(ReclamationController.reclamationNote);
                    break;
                case 1:
                    System.out.println("prof");
                    ReclamationController.reclamationProf.setDesc(id_champ.getText());
                    reclamationService.ajouterReclamationProf(ReclamationController.reclamationProf);
                    break;
                case 2:
                    System.out.println("autre");
                    //controle saisie
                    if (subjectTxt.getText() != null && !subjectTxt.getText().trim().equals("")) {
                        ReclamationController.reclamationAutre.setSujet(subjectTxt.getText());
                        reclamationService.ajouterReclamation(ReclamationController.reclamationAutre);
                    }
                    break;
            }

        }
        Notifications notificationBuilder = Notifications.create().title("reclamation ajoutée").text("avec succés").position(Pos.TOP_RIGHT);
        notificationBuilder.show();
    }

    @FXML
    void clearText(ActionEvent event) {
        id_champ.setText("");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //id_champ.setText("" + ReclamationController.reclamationNote.getId_note());

        if (ReclamationController.typeReclamation == 2) {
            subjectTxt.setVisible(true);
        }

    }

}
