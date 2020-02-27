/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Branche;
import java.io.IOException;
import Services.StageService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class EditSujetController implements Initializable {

    public static StageService ss = new StageService();
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private TextArea description;
    @FXML
    private ComboBox<Branche> branche;
    @FXML
    private TextField sujet;
    @FXML
    private Button modifier;

    @FXML

    void edit(ActionEvent event) throws SQLException, IOException {

        ViewSujetController.stage_modif.setSujet(sujet.getText());
        ViewSujetController.stage_modif.setDescription(description.getText());
        ViewSujetController.stage_modif.setBranche(branche.getValue());

        ss.modifierStage(ViewSujetController.stage_modif);
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ViewSujet.fxml"));
        anchorpane.getChildren().clear();
        anchorpane.getChildren().add(newLoadedPane);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        branche.getItems().addAll(Branche.Business, Branche.Data_science,
                Branche.Génie_logiciel, Branche.Informatque, Branche.Sécurité, Branche.intelligence);

        sujet.setText(ViewSujetController.stage_modif.getSujet());
        description.setText(ViewSujetController.stage_modif.getDescription());
        branche.setValue(ViewSujetController.stage_modif.getBranche());

    }

}
