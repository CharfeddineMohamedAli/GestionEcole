/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author KattaX
 */
import Utils.UserUniTech;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameUser.setText(UserUniTech.userConnecte.getFirst_Name() + " " + UserUniTech.userConnecte.getLast_Name().toUpperCase());

        if (!UserUniTech.userConnecte.getRole().equals("admin")) {
            btn_permutation.setDisable(true);
        }
    }

    @FXML
    private AnchorPane content;

    @FXML
    private JFXButton btn_rec;

    @FXML
    private JFXButton btn_emploi;

    @FXML
    private Label nameUser;

    @FXML
    private JFXButton btn_classe;

    @FXML
    private JFXButton btn_notes;

    @FXML
    private JFXButton btn_abs;

    @FXML
    void classe(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Affecter_Classe.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Classe");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void emploi(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/HomeEmploi.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Emploi");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void notes(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/recherche.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Note");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void reclamation(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/HomeReclamation.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Reclamation");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private JFXButton btn_q_a;

    @FXML
    void absence(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/FXMLinterface.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Absence");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void qAndA(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = null;
        if (UserUniTech.userConnecte.getRole().equals("admin")) {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AdminSujet.fxml"));
        } else {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AcceuilForum.fxml"));
        }
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Stage");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private JFXButton btn_stage;

    @FXML
    void stage(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = null;
        if (UserUniTech.userConnecte.getRole().equals("admin")) {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ViewSujet.fxml"));
        } else {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ViewSujetClient.fxml"));
        }
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Stage");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private JFXButton btn_profil;

    @FXML
    private JFXButton btn_permutation;

    @FXML
    void permutation(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/PermutationFXML.fxml"));
        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Permutation");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void profil(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = null;
        if (UserUniTech.userConnecte.getRole().equals("enseignant")) {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Modifier_profile_enseignant.fxml"));
        } else if (UserUniTech.userConnecte.getRole().equals("etudiant")) {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Modifier_profile_etudiant.fxml"));
        } else if (UserUniTech.userConnecte.getRole().equals("parent")) {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Modifier_profile_parent.fxml"));
        } else {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/Modifier_profile_parent.fxml"));
        }

        Scene scene = new Scene(newLoadedPane);
        Stage stage = new Stage();
        stage.setTitle("Dashboard Permutation");
        stage.setScene(scene);
        stage.show();
    }
}
