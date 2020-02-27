/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.ListeStage;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Services.ListeStageService;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ViewDemandeStageController implements Initializable {

    ListeStageService listestageService = new ListeStageService();
    public static ListeStage listS = new ListeStage();

    @FXML
    private AnchorPane content;
    @FXML
    private TableView<ListeStage> tabledemande;
    @FXML
    private TableColumn<ListeStage, String> sujet;
    @FXML
    private TableColumn<ListeStage, String> description;
    @FXML
    private TableColumn<ListeStage, String> branche;
    @FXML
    private TableColumn<ListeStage, String> LM;
    @FXML
    private TableColumn<ListeStage, String> CV;
    @FXML
    private TableColumn<ListeStage, String> adresse;
    @FXML
    private Button trait;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }

    public void afficher() {

        sujet.setCellValueFactory(new PropertyValueFactory<ListeStage, String>("sujet"));
        description.setCellValueFactory(new PropertyValueFactory<ListeStage, String>("description"));
        branche.setCellValueFactory(new PropertyValueFactory<ListeStage, String>("branche"));
        LM.setCellValueFactory(new PropertyValueFactory<ListeStage, String>("LettreMotivation"));
        CV.setCellValueFactory(new PropertyValueFactory<ListeStage, String>("CV"));
        adresse.setCellValueFactory(new PropertyValueFactory<ListeStage, String>("adresse"));
        try {
            tabledemande.getItems().setAll(listestageService.readAllS());
        } catch (SQLException ex) {
            Logger.getLogger(ViewSujetController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void traiter(ActionEvent event) throws IOException {

        listS = tabledemande.getSelectionModel().getSelectedItem();
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/Traitement.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

}
