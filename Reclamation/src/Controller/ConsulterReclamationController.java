/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Matiere;
import Entities.Note;
import Entities.Reclamation;
import Entities.ReclamationNote;
import Entities.ReclamationProf;
import Entities.User;
import Services.ReclamationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class ConsulterReclamationController implements Initializable {

    public static int typeReclamation = -1;
    private final ReclamationService reclamationService;
    public static Object reclamationSelection = null;

    public ConsulterReclamationController() {
        reclamationService = new ReclamationService();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList list = FXCollections.observableArrayList("Notes", "Enseignants", "Autres");
        typeRec.setItems(list);

        //events
        typeRec.valueProperty().addListener((observable) -> {
            ConsulterReclamationController.typeReclamation = typeRec.getSelectionModel().getSelectedIndex();
            delBtn.setDisable(true);
            updateBtn.setDisable(true);
            try {
                afficherTableView();
                dataTable.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dataTable.setOnMouseClicked((event) -> {
            if (dataTable.getSelectionModel().getSelectedIndex() >= 0) {
                delBtn.setDisable(false);
                updateBtn.setDisable(false);
                reclamationSelection = dataTable.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    private JFXButton delBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private TableView dataTable;

    @FXML
    private JFXComboBox<?> typeRec;

    @FXML
    private TableColumn nomColumn;

    @FXML
    private TableColumn prenomColumn;

    @FXML
    private TableColumn noteColumn;

    @FXML
    private TableColumn descColumn;

    private void afficherTableView() throws SQLException {

        //dataTable.getColumns().clear();
        String typeSelected = (String) typeRec.getSelectionModel().getSelectedItem();
        User user = null;

        if (typeSelected.matches("Notes")) {
            System.out.println("Note");
            noteColumn.setVisible(true);

            noteColumn.setCellValueFactory(new PropertyValueFactory<ReclamationNote, Integer>("note") {
                @Override
                public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ReclamationNote, Integer> param) {
                    return new ReadOnlyObjectWrapper< Integer>(param.getValue().getNote().getNotes());
                }
            });
        } else {
            noteColumn.setVisible(false);
        }

        descColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("desc"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("user") {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Object, String> param) {
                if (typeSelected.matches("Enseignants")) {
                    ReclamationProf rp = (ReclamationProf) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(rp.getUser().getLast_Name());
                } else if (typeSelected.matches("Notes")) {
                    ReclamationNote rp = (ReclamationNote) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(rp.getUser().getLast_Name());
                } else {
                    Reclamation r = (Reclamation) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(r.getUser().getLast_Name());
                }
            }
        });

        prenomColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("user") {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Object, String> param) {
                if (typeSelected.matches("Enseignants")) {
                    ReclamationProf rp = (ReclamationProf) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(rp.getUser().getFirst_Name());
                } else if (typeSelected.matches("Notes")) {
                    ReclamationNote rp = (ReclamationNote) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(rp.getUser().getFirst_Name());
                } else {
                    Reclamation r = (Reclamation) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(r.getUser().getFirst_Name());
                }
            }
        });

        dataTable.getItems().setAll(reclamationService.getReclamationsByUserID(ReclamationController.userConnecte.getId_user(), typeSelected));
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ModifierReclamation.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Modifier Reclamation");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void supprimer(ActionEvent event) throws SQLException {
        String typeSelected = (String) typeRec.getSelectionModel().getSelectedItem();
        if (typeSelected.matches("Notes")) {
            ReclamationNote r = (ReclamationNote) dataTable.getSelectionModel().getSelectedItem();
            reclamationService.suprimerReclamationNote(r);
        } else if (typeSelected.matches("Enseignants")) {
            ReclamationProf r = (ReclamationProf) dataTable.getSelectionModel().getSelectedItem();
            reclamationService.suprimerReclamationProf(r);
        } else {
            Reclamation r = (Reclamation) dataTable.getSelectionModel().getSelectedItem();
            reclamationService.suprimerReclamation(r);
        }
        System.out.println("reclamation supprimée");
        Notifications notificationBuilder =Notifications.create().title("reclamation supprimée").text("avec succés").position(Pos.TOP_RIGHT).hideAfter(Duration.seconds(5));
        notificationBuilder.show();
        //refresh data
        dataTable.getItems().setAll(reclamationService.getReclamationsByUserID(ReclamationController.userConnecte.getId_user(), typeSelected));
    }

}
