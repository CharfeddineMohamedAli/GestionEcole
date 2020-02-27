/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class TraitementController implements Initializable {

    @FXML
    private JFXTextField adresse;
    @FXML
    private Label CV;
    @FXML
    private Label LM;
    @FXML
    private AnchorPane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adresse.setText(ViewDemandeStageController.listS.getAdresse());
        CV.setText(ViewDemandeStageController.listS.getCV());
        LM.setText(ViewDemandeStageController.listS.getLettreMotivation());
    }

    @FXML
    private void cv(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/CV.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

    @FXML
    private void lm(MouseEvent event) {
    }

}
