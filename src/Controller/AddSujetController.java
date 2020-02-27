/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Branche;
import Entities.Stage;
import java.io.IOException;
import Services.StageService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AddSujetController implements Initializable {

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
    private Button ajouter;
    @FXML
    private Button table;

    @FXML
    void add(ActionEvent event) throws SQLException {
        Stage stage = new Stage();
        stage.setDescription(description.getText());
        stage.setSujet(sujet.getText());
        stage.setId_user(1);
        stage.setId_stage(2);
        stage.setBranche(branche.getValue());
        if (((description.getText().isEmpty())) || ((sujet.getText().isEmpty())) || ((branche.getSelectionModel().isEmpty()))) {
            Notifications notificationBuilder = Notifications.create()
                    .title("chqmps vide")
                    .text("veuillez remplir les champs vide")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.showWarning();
        } else {
            ss.ajouterStage(stage);
            description.clear();
            Notifications notificationBuilder = Notifications.create()
                    .title("stage ajouté")
                    .text("vous pouvez ajouté d'autre stage")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        branche.getItems().addAll(Branche.Business,
                Branche.Data_science, Branche.Génie_logiciel,
                Branche.Informatque, Branche.Sécurité, Branche.intelligence);
    }

    @FXML
    void tableview(ActionEvent event) throws IOException {

        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/ViewSujet.fxml"));
        anchorpane.getChildren().clear();
        anchorpane.getChildren().add(newLoadedPane);
    }

}
