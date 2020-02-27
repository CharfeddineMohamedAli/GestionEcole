/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.print.PrinterJob;
import Entities.Reclamation;
import Entities.ReclamationNote;
import Entities.ReclamationProf;
import Services.ReclamationService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class ConsulterReclamationAdminController implements Initializable {

    private final ReclamationService reclamationService;
    private List<Object> reclamations, reclamationsFilter;

    /**
     * Initializes the controller class.
     */
    public ConsulterReclamationAdminController() {
        reclamationService = new ReclamationService();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficherTableViewAll();

        } catch (SQLException ex) {
            Logger.getLogger(ConsulterReclamationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //events
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            delBtn.setDisable(true);
            editBtn.setDisable(true);
            reclamationsFilter = reclamations.stream().filter(
                    t -> {
                        Reclamation r = (Reclamation) t;
                        boolean result = r.getUser().getFirst_Name().contains(newValue) || r.getUser().getLast_Name().contains(newValue) || r.getDesc().contains(newValue) || r.getEtat().name().contains(newValue);

                        if (t instanceof ReclamationProf) {
                            ReclamationProf rp = (ReclamationProf) t;
                            result = result || rp.getProf().getFirst_Name().contains(newValue) || rp.getProf().getLast_Name().contains(newValue);
                        }

                        if (t instanceof ReclamationNote) {
                            ReclamationNote rn = (ReclamationNote) t;
                            result = result || String.valueOf(rn.getNote().getMoyenne()).contains(newValue);
                        }

                        return result;
                    }).collect(Collectors.toList());
            recs.getItems().clear();
            recs.getItems().addAll(reclamationsFilter);
        });

        recs.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            ConsulterReclamationController.reclamationSelection = recs.getSelectionModel().getSelectedItem();

            if (ConsulterReclamationController.reclamationSelection instanceof Reclamation) {
                ConsulterReclamationController.typeReclamation = 2;
            } else if (ConsulterReclamationController.reclamationSelection instanceof ReclamationNote) {
                ConsulterReclamationController.typeReclamation = 0;
            } else {
                ConsulterReclamationController.typeReclamation = 1;
            }

            delBtn.setDisable(false);
            editBtn.setDisable(false);
        });
    }

    @FXML
    private JFXTextField search;

    @FXML
    private TableView recs;

    @FXML
    private TableColumn etudiant;

    @FXML
    private TableColumn nometud;

    @FXML
    private TableColumn prenometud;

    @FXML
    private TableColumn enseignant;

    @FXML
    private TableColumn nomens;

    @FXML
    private TableColumn prenomens;

    @FXML
    private TableColumn desc;

    @FXML
    private TableColumn note;

    @FXML
    private TableColumn etat;

    private void afficherTableViewAll() throws SQLException {

        nometud.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("user") {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                Reclamation r = (Reclamation) param.getValue();
                return new ReadOnlyObjectWrapper<String>(r.getUser().getFirst_Name());
            }
        });

        prenometud.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("user") {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                Reclamation r = (Reclamation) param.getValue();
                return new ReadOnlyObjectWrapper<String>(r.getUser().getLast_Name());
            }
        });

        desc.setCellValueFactory(new PropertyValueFactory("desc"));
        etat.setCellValueFactory(new PropertyValueFactory("etat"));

        nomens.setCellValueFactory(new PropertyValueFactory("prof") {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                if (param.getValue() instanceof ReclamationProf) {
                    ReclamationProf r = (ReclamationProf) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(r.getProf().getFirst_Name());
                }
                return super.call(param);
            }
        });

        prenomens.setCellValueFactory(new PropertyValueFactory("prof") {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                if (param.getValue() instanceof ReclamationProf) {
                    ReclamationProf r = (ReclamationProf) param.getValue();
                    return new ReadOnlyObjectWrapper<String>(r.getProf().getLast_Name());
                }
                return super.call(param);
            }
        });

        note.setCellValueFactory(new PropertyValueFactory("note") {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                if (param.getValue() instanceof ReclamationNote) {
                    ReclamationNote r = (ReclamationNote) param.getValue();
                    return new ReadOnlyObjectWrapper(r.getNote().getNet());
                }
                return super.call(param);
            }
        });

        Collection reclamationsNotes = reclamationService
                .getReclamationsByUserID(
                        ReclamationController.userConnecte.getId_user(),
                        "Notes");
        Collection reclamationsProf = reclamationService
                .getReclamationsByUserID(
                        ReclamationController.userConnecte.getId_user(),
                        "Enseignants");
        reclamations = reclamationService
                .getReclamationsByUserID(
                        ReclamationController.userConnecte.getId_user(),
                        "Autres");

        reclamations.addAll(reclamationsProf);
        reclamations.addAll(reclamationsNotes);

        recs.getItems().setAll(reclamations);
        reclamationsFilter = reclamations;
    }

    @FXML
    private JFXButton delBtn;

    @FXML
    private JFXButton editBtn;

    @FXML
    void remove(ActionEvent event) {

        Reclamation r = (Reclamation) recs.getSelectionModel().getSelectedItem();

        try {
            if (r instanceof ReclamationNote) {
                reclamationService.suprimerReclamationNote((ReclamationNote) r);
            } else if (r instanceof ReclamationProf) {
                reclamationService.suprimerReclamationProf((ReclamationProf) r);
            } else {
                reclamationService.suprimerReclamation(r);
            }
            System.out.println("reclamation supprimée");
            Notifications notificationBuilder = Notifications.create().title("reclamation supprimée").text("avec succés").position(Pos.TOP_RIGHT).hideAfter(Duration.seconds(5));
            notificationBuilder.show();
            //refresh data
            reclamations.removeIf((t) -> t == (r));
            reclamationsFilter.removeIf((t) -> t == (r));
            recs.getItems().setAll(reclamationsFilter);
            delBtn.setDisable(true);
            editBtn.setDisable(true);
        } catch (SQLException exception) {
            Notifications notificationBuilder = Notifications.create().title("reclamation non supprimée").text("avec échec").position(Pos.TOP_RIGHT).hideAfter(Duration.seconds(5));
            notificationBuilder.show();
        }
    }

    @FXML
    void update(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane;
        newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ModifierReclamationAdmin.fxml"));

        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Modifier Reclamation");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private JFXButton print;

    public void printAll(ActionEvent event) {
        final PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob.showPrintDialog(recs.getScene().getWindow())) {
            if (printerJob.printPage(recs)) {
                printerJob.endJob();
            }
        }
    }
};
