/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.EmploiService;
import Utils.HeureSeance;
import Utils.JourSeance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class TestEmploiController implements Initializable {

    EmploiService emploiService;

    public TestEmploiController() {
        emploiService = new EmploiService();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List l = Arrays.asList(JourSeance.values());
        jour.setItems(FXCollections.observableArrayList(l));
        l = Arrays.asList(HeureSeance.values());
        heure.setItems(FXCollections.observableArrayList(l));
    }

    @FXML
    private JFXComboBox<?> jour;

    @FXML
    private JFXComboBox<?> heure;

    @FXML
    private JFXComboBox<?> classe;

    @FXML
    private JFXComboBox<?> enseignant;

    @FXML
    private JFXComboBox<?> semaine;

    @FXML
    private JFXComboBox<?> salle;

    @FXML
    private JFXButton addBtn;

    @FXML
    void ajouterSeance(ActionEvent event) {

    }

}
