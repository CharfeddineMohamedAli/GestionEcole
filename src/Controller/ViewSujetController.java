/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Branche;
import Entities.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import Services.StageService;

/**
 * FXML Controller class
 *
 * @author dell is hell
 */
public class ViewSujetController implements Initializable {

    StageService stageService = new StageService();
    public static Stage stage_modif = new Stage();

    @FXML
    private TableColumn<Stage, Branche> branche;

    @FXML
    private TableColumn<Stage, String> description;

    @FXML
    private TableColumn<Stage, String> sujet;

    @FXML
    private TableView<Stage> tablestage;

    @FXML
    private AnchorPane content;

    @FXML
    private Button supp;

    @FXML
    private Button modifier;

    @FXML
    private Button ajouter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        // TODO
    }

    public void afficher() {

        sujet.setCellValueFactory(new PropertyValueFactory<Stage, String>("sujet"));
        description.setCellValueFactory(new PropertyValueFactory<Stage, String>("description"));
        branche.setCellValueFactory(new PropertyValueFactory<Stage, Branche>("branche"));

        try {
            tablestage.getItems().setAll(stageService.readAllS());
        } catch (SQLException ex) {
            Logger.getLogger(ViewSujetController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void supprimer(ActionEvent event) {
        ObservableList<Stage> selectedRows, Stage;
        Stage = tablestage.getItems();
        selectedRows = tablestage.getSelectionModel().getSelectedItems();
        for (Stage stage : selectedRows) {
            Stage.remove(sujet);
            stageService.supprimerStage(stage);
            afficher();
            Notifications notificationBuilder = Notifications.create()
                    .title("stage supprimé")
                    .text("BYE BYE")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();
        }

        /**
         * Initializes the controller class.
         */
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        stage_modif = tablestage.getSelectionModel().getSelectedItem();
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/EditSujet.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

    @FXML
    void add(ActionEvent event) throws IOException {

        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AddSujet.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
    }

}
