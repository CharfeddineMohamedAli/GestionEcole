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
public class ModifierReclamationController implements Initializable {

    private final ReclamationService reclamationService;

    public ModifierReclamationController() {
        this.reclamationService = new ReclamationService();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switch (ConsulterReclamationController.typeReclamation) {
            case 0:
                ReclamationNote r = (ReclamationNote) ConsulterReclamationController.reclamationSelection;
                descriptionTxt.setText(r.getDesc());
                break;
            case 1:
                ReclamationProf rp = (ReclamationProf) ConsulterReclamationController.reclamationSelection;
                descriptionTxt.setText(rp.getDesc());
                break;
            case 2:
                Reclamation rec = (Reclamation) ConsulterReclamationController.reclamationSelection;
                descriptionTxt.setText(rec.getDesc());
                break;
        }
    }

    @FXML
    private TextField descriptionTxt;

    @FXML
    private Button envoie;

    @FXML
    private JFXTextField subjectTxt;

    @FXML
    void clearText(ActionEvent event) {
        descriptionTxt.setText("");
    }

    @FXML
    void envoyer(ActionEvent event) throws SQLException {

        switch (ConsulterReclamationController.typeReclamation) {

            case 0:
                ReclamationNote r = (ReclamationNote) ConsulterReclamationController.reclamationSelection;
                r.setDesc(descriptionTxt.getText().trim());
                reclamationService.modifierReclamationNote(r);
                break;
            case 1:
                ReclamationProf rp = (ReclamationProf) ConsulterReclamationController.reclamationSelection;
                rp.setDesc(descriptionTxt.getText().trim());
                reclamationService.modifierReclamationProf(rp);
                break;
            case 2:
                Reclamation rec = (Reclamation) ConsulterReclamationController.reclamationSelection;
                rec.setDesc(descriptionTxt.getText().trim());
                reclamationService.modifierReclamation(rec);
                break;
        }
        System.out.println("reclamation modifiée");
        Notifications notificationBuilder = Notifications.create().title("reclamation modifiée").text("avec succés").position(Pos.TOP_RIGHT);
        notificationBuilder.show();
    }

}
