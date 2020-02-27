/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Categorie;
import Services.SujetService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierSujetController implements Initializable {

    @FXML
    private JFXTextField f_titre;
    @FXML
    private JFXButton id_modifier;
    @FXML
    private JFXTextArea id_description;
    @FXML
    private JFXComboBox<Categorie> id_categorie;
    @FXML
    private AnchorPane id_page_modifé;

    /**
     * Initializes the controller class.
     */
    public static SujetService sujetService = new SujetService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        f_titre.setText(MesSujetsController.getSujet_modifié().getTitre_Sujet());
        id_description.setText(MesSujetsController.getSujet_modifié().getContenu_Sujet());

        id_categorie.getItems().addAll(Categorie.branche, Categorie.credits,
                 Categorie.matiéres, Categorie.paiement);
        id_categorie.setValue(MesSujetsController.getSujet_modifié().getCategorie());
    }

    @FXML
    private void modifer(ActionEvent event) {
        MesSujetsController.getSujet_modifié().setTitre_Sujet(f_titre.getText());
        MesSujetsController.getSujet_modifié().setContenu_Sujet(id_description.getText());
        MesSujetsController.getSujet_modifié().setCategorie(id_categorie.getValue());
        sujetService.modifierSujet(MesSujetsController.getSujet_modifié());
        try {

            AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/MesSujets.fxml"));
            id_page_modifé.getChildren().clear();
            id_page_modifé.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(ModifierSujetController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image img = new Image("/aa.png");
        Notifications notificationBuilder = Notifications.create()
                .title("Sujet Modifié")
                .text("Vous avez modifé le sujet")
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);

        notificationBuilder.show();

    }

}
