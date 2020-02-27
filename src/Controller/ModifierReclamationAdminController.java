/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reclamation;
import Entities.ReclamationNote;
import Entities.ReclamationProf;
import Services.ReclamationService;
import Utils.EtatReclamation;
import Utils.MailTools;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class ModifierReclamationAdminController implements Initializable {

    private static int etatSelection = -1;
    Reclamation rec = (Reclamation) ConsulterReclamationController.reclamationSelection;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        etats.getItems().clear();
        etats.getItems().addAll(EtatReclamation.values());

        etatSelection = rec.getEtat().ordinal();
        etats.getSelectionModel().select(rec.getEtat());

        etats.valueProperty().addListener((observable) -> {
            etatSelection = etats.getSelectionModel().getSelectedIndex();
        });
    }

    private final ReclamationService reclamationService;

    public ModifierReclamationAdminController() {
        this.reclamationService = new ReclamationService();
    }

    @FXML
    private Button updateBtn;

    @FXML
    private JFXTextField subjectTxt;

    @FXML
    private JFXComboBox etats;

    @FXML
    void update(ActionEvent event) throws SQLException, Exception {

        //modifier object
        rec.setEtat(EtatReclamation.values()[etatSelection]);
        //update db
        switch (ConsulterReclamationController.typeReclamation) {
            case 0:
                reclamationService.modifierReclamationNote((ReclamationNote) rec);
                break;
            case 1:
                reclamationService.modifierReclamationProf((ReclamationProf) rec);
                break;
            case 2:
                reclamationService.modifierReclamation(rec);
                break;
        }

        //MailTools.sendMail(rec.getUser().getEmail());
        MailTools.sendMail("mohamed.khammeri@esprit.tn");

        //reclamationService.modifierReclamation(reclamation);
    }

}
