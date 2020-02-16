/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.Categorie;
import Entite.Sujet;
import Service.SujetService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author dell is hell
 */
public class AjoutSujetController implements Initializable {
public static SujetService sujetService = new SujetService();


  @FXML
    private AnchorPane id_page_ajout;

    @FXML
    private JFXTextArea id_description;

    @FXML
    private JFXTextField f_titre;

    @FXML
    private JFXComboBox<Categorie> id_categorie;

    @FXML
    private JFXButton id_add;

    



  

    @FXML
    void add(ActionEvent event) throws SQLException {
        Sujet sujet=new Sujet();
        sujet.setTitre_Sujet(f_titre.getText());
        sujet.setContenu_Sujet(id_description.getText());
        sujet.setCategorie(id_categorie.getValue());
        sujetService.ajouterSujet(sujet);
        f_titre.clear();
        id_description.clear();
        

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_categorie.getItems().addAll(Categorie.branche, Categorie.credits, Categorie.matiéres, Categorie.paiement);
    }

}
