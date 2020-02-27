/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Categorie;
import Entities.Sujet;
import Services.SujetService;
import Utils.UserUniTech;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterSujetController implements Initializable {

    @FXML
    private JFXTextField f_titre;

    @FXML
    private JFXButton id_add;
    @FXML
    private JFXTextArea id_description;
    @FXML
    private JFXComboBox<Categorie> id_categorie;

    @FXML
    private AnchorPane id_page_ajout;
    @FXML
    private Label id_verifier_titre;

    @FXML
    private Label id_verifier_description;

    @FXML
    private Label id_verifier_categorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_categorie.getItems().removeAll(id_categorie.getItems());
        id_categorie.getItems().addAll(Categorie.branche, Categorie.credits,
                Categorie.matiéres, Categorie.paiement);

    }

    public static SujetService sujetService = new SujetService();

    @FXML
    void add(ActionEvent event) throws SQLException {

        if (((f_titre.getText().isEmpty()) == false)
                && ((id_categorie.getSelectionModel().isEmpty() == false))
                && (id_description.getText().isEmpty() == false)
                && (sujetService.rechercherparNom(f_titre.getText()) == false)) {
            Sujet sujet = new Sujet(UserUniTech.userConnecte.getId_user(), f_titre.getText(), id_description.getText(),
                    id_categorie.getValue());
            sujet.setNbre_vues(0);
            sujet.setNbre_jaime(0);

            sujetService.ajouterSujet(sujet);

            try {

                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AjoutSujet.fxml"));

                id_page_ajout.getChildren().clear();
                id_page_ajout.getChildren().add(newLoadedPane);

            } catch (IOException ex) {
                Logger.getLogger(AjouterSujetController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Image img = new Image("/aa.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Demande D'ajout")
                    .text("Merci pour attendre la réponse")
                    .graphic(new ImageView(img))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();
        } else {
            BoxBlur blur = new BoxBlur(3, 3, 3);
            id_page_ajout.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Repetez svp");
            alert.setHeaderText("champs non validés");
            alert.setContentText("Verifiez vos champs svp!!");
            alert.showAndWait();
            id_page_ajout.setEffect(null);
            System.out.println("nest pas possible");
        }
    }

    @FXML
    void verifier_categorie(MouseEvent event) {
        if (id_categorie.getSelectionModel().isEmpty()) {
            id_verifier_categorie.setText("categorie n'est pas choisie!");
            id_verifier_categorie.setTextFill(Color.RED);
            id_verifier_categorie.setVisible(true);
        } else {
            id_verifier_categorie.setText("categorie  choisie!");
            id_verifier_categorie.setTextFill(Color.GREEN);
            id_verifier_categorie.setVisible(true);
        }
    }

    @FXML
    void verifier_description(KeyEvent event) {
        if (id_description.getText().isEmpty()) {
            id_verifier_description.setText("champ vide!");
            id_verifier_description.setTextFill(Color.RED);
            id_verifier_description.setVisible(true);
        } else {
            id_verifier_description.setText("description remplie!");
            id_verifier_description.setTextFill(Color.GREEN);
            id_verifier_description.setVisible(true);

        }
    }

    @FXML
    void verifier_titre(KeyEvent event) {
        if (sujetService.rechercherparNom(f_titre.getText())) {
            id_verifier_titre.setText("Titre déja utilisé!");
            id_verifier_titre.setTextFill(Color.RED);
            id_verifier_titre.setVisible(true);
        } else if (f_titre.getText().isEmpty()) {
            id_verifier_titre.setText("champ vide!");
            id_verifier_titre.setTextFill(Color.RED);
            id_verifier_titre.setVisible(true);
        } else {
            id_verifier_titre.setText("Titre possible!");
            id_verifier_titre.setTextFill(Color.GREEN);
            id_verifier_titre.setVisible(true);

        }
    }

}
