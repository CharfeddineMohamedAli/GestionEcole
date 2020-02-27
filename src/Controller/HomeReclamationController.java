/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.ReclamationService;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class HomeReclamationController implements Initializable {

    ReclamationService reclamationService;
    UserService userService;

    public HomeReclamationController() {
        reclamationService = new ReclamationService();
        userService = new UserService();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            if (reclamationService.getTypeUserByID(ReclamationController.userConnecte.getId_user()).equals("etudiant")) {
                addBtn.setDisable(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private JFXButton consulterBtn;

    @FXML
    private JFXButton addBtn;
    @FXML
    private JFXButton stat;

    @FXML
    private JFXButton btnDcx;

    @FXML
    private AnchorPane content;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Reclamation.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Ajouter Reclamation");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void consulter(ActionEvent event) throws IOException, SQLException {
        AnchorPane newLoadedPane;

        if (userService.getUserRole(ReclamationController.userConnecte.getId_user()).equals("admin")) {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ConsulterReclamationAdmin.fxml"));
        } else {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ConsulterReclamation.fxml"));
        }
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Reclamation");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deconnecter(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void stat(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Stats.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Stats Reclamation");
        stage.setScene(scene);
        stage.show();
    }
}
