/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reclamation;
import Entities.User;
import Services.ReclamationService;
import Utils.EtatReclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class TESTController implements Initializable {

    ReclamationService reclamationService;

    public TESTController() {
        reclamationService = new ReclamationService();

        try {
            //recherche+ modification + supp
            Reclamation r = reclamationService.rechercherReclamationParID(3);
            if (r != null) {
                r.setEtat(EtatReclamation.Résolu);
                reclamationService.modifierReclamation(r);
                //reclamationService.suprimerReclamation(r);
            }
            //recup
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button btnAddBtn;
    @FXML
    private JFXTextField txtDesc;

    @FXML
    void onClickAdd(ActionEvent event) {
        try {
            reclamationService.ajouterReclamation(new Reclamation(1, txtDesc.getText(), new User("abc", "bcd", "aaa")));
        } catch (SQLException ex) {
            Logger.getLogger(TESTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
