/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextField;
import Entities.ListeStage;
import Entities.Stage;
import java.io.File;
import java.io.IOException;
import java.net.ProtocolException;
import Services.StageService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import Services.ListeStageService;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PostulerClientController implements Initializable {

    public static StageService ss = new StageService();
    public static ListeStageService lss = new ListeStageService();
    public static Stage stage_modif = new Stage();

    @FXML
    private AnchorPane content;

    @FXML
    private Label laBranche;

    @FXML
    private Label laSujet;

    @FXML
    private Label laDesc;
    @FXML
    private Button retour;
    @FXML
    private Button cv;

    @FXML
    private Button lm;
    @FXML
    private Label cvLa;
    @FXML
    private Label lmLa;
    @FXML
    private Button postulerbtn;
    @FXML
    private JFXTextField adr;

    String lienCv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        laSujet.setText(ViewSujetClientController.stage_modif.getSujet());
        laDesc.setText(ViewSujetClientController.stage_modif.getDescription());
        laBranche.setText(ViewSujetClientController.stage_modif.getBranche().toString());

    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ViewSujetClient.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
    }

    @FXML
    void cv(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.setTitle("Ouvrir le fichier jpg");
        fc.getExtensionFilters().addAll(new ExtensionFilter("JPG files", "*.jpg"));
        File selectedFile = fc.showOpenDialog(null);
        //this.lienCv=selectedFile.getPath();
        if (selectedFile != null) {//this.lienCv=selectedFile.getPath();
            cvLa.setText(selectedFile.getName());
            //System.out.println(this.lienCv);
        } else {
            System.out.println("fichier non valide");
        }

    }

    @FXML
    private void lm(ActionEvent event) throws ProtocolException, IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Ouvrir le fichier jpg");
        fc.getExtensionFilters().addAll(new ExtensionFilter("JPG files", "*.jpg"));
        File selectedFile = fc.showOpenDialog(null);
        //File defaultDirectory = new File("C:\\wamp64\\www\\uploads");
        // fc.setInitialDirectory(defaultDirectory);

        if (selectedFile != null) {
            lmLa.setText(selectedFile.getName());
        } else {
            System.out.println("fichier non valide");
        }

    }

    @FXML
    private void postbtn(ActionEvent event) throws SQLException {
        ListeStage ls = new ListeStage();
        ls.setSujet(laSujet.getText());
        ls.setDescription(laDesc.getText());
        ls.setBranche(laBranche.getText());
        ls.setLettreMotivation(lmLa.getText());
        ls.setCV(cvLa.getText());
        ls.setAdresse(adr.getText());
        lss.ajouterlisteStage(ls);

    }

}
