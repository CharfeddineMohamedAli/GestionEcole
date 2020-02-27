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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Services.StageService;

/**
 * FXML Controller class
 *
 * @author dell is hell
 */
public class ViewSujetClientController implements Initializable {

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
    private Button postuler;
    @FXML
    private TextField search;

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
            Logger.getLogger(ViewSujetClientController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void postuler(ActionEvent event) throws IOException {

        stage_modif = tablestage.getSelectionModel().getSelectedItem();
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/PostulerClient.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

    @FXML
    private void searchSujet(javafx.scene.input.KeyEvent event) throws SQLException {
        StageService stageService = new StageService();
        ArrayList AL = (ArrayList) stageService.readAllS();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Stage> filteredData = new FilteredList<>(OReservation, p -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getSujet()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<Stage> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablestage.comparatorProperty());
        tablestage.setItems(sortedData);

    }
}
