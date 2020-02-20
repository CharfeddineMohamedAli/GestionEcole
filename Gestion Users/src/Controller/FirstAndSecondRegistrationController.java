/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Level;
import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author admin
 */
public class FirstAndSecondRegistrationController implements Initializable {

    public static User user = new User();
    
    
    @FXML
    private FontAwesomeIconView retour2;
    @FXML
    private AnchorPane content1;
    @FXML
    private FontAwesomeIconView next0;
    @FXML
    private Pane id_reg;
    @FXML
    private Label id_label_level;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXPasswordField tf_password;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField tf_repeter;

    @FXML
    private JFXTextField email;

   @FXML
    private FontAwesomeIconView retour_first;

    @FXML
    private Label ver_nom;

    @FXML
    private Label ver_user;

    @FXML
    private Label erreurMail;

    @FXML
    private Label ver_mot;

    @FXML
    private Label ver_rep;

    @FXML
    private Label ver_prenom;

    @FXML
    private AnchorPane content2;

    @FXML
    private JFXTextField tf_Number;

    @FXML
    private JFXTextField tf_CIN;

    @FXML
    private FontAwesomeIconView retour;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private FontAwesomeIconView image_user;

    @FXML
    private Label upload_image;

    @FXML
    private JFXButton create_account;

    @FXML
    private Label lab_CIN;

    @FXML
    private Label lab_Age;

    @FXML
    private JFXTextField tf_Age;

    @FXML
    private ComboBox<String> cb_Gender;

    @FXML
    private Label lab_number;

    @FXML
    private RadioButton radio_etudiant;

    @FXML
    private RadioButton radio_enseignant;

    @FXML
    private RadioButton radio_parent;

    @FXML
    private JFXComboBox<Level> id_level;

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void fermer(MouseEvent event) throws IOException {

        System.exit(0);
    }

    @FXML
    void gotopage2(MouseEvent event) throws IOException {
        user.setFirst_Name(firstName.getText());
        user.setLast_Name(lastName.getText());
        user.setUser_Name(userName.getText());
        user.setEmail(email.getText());
        user.setPassword(tf_password.getText());
        tf_repeter.getText();
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/SecondRegistrationFXML.fxml"));
        content1.getChildren().clear();
        content1.getChildren().add(newLoadedPane);
    }

    @FXML
    void retour1(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/InitRegistration.fxml"));
        content1.getChildren().clear();
        content1.getChildren().add(newLoadedPane);
    }

    @FXML
    void add_gender(ActionEvent event) {

    }

    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void upload_Image(MouseEvent event) {
    }

    @FXML
    void backto1(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/FirstRegistrationFXML.fxml"));
        content2.getChildren().clear();
        content2.getChildren().add(newLoadedPane);

    }
    @FXML
    private void doRegistration(MouseEvent event) throws SQLException {
        UserService userService = new UserService();

        user.setPhone_number(Integer.parseInt(tf_Number.getText()));
        user.setCIN(Integer.parseInt(tf_CIN.getText()));
        user.setAge(Integer.parseInt(tf_Age.getText()));
        userService.ajouterUser(user);

    }

    @FXML
    void verifier_enseignant(ActionEvent event) {
        if (radio_enseignant.isSelected()) {
            id_label_level.setVisible(false);
            id_level.setVisible(false);
            radio_etudiant.setSelected(false);
            radio_parent.setSelected(false);
            user.setRole("enseignant");
        }
    }

    @FXML
    void verifier_etudiant(ActionEvent event) {
        if (radio_etudiant.isSelected()) {
            radio_parent.setSelected(false);
            radio_enseignant.setSelected(false);
            user.setRole("etudiant");
            id_label_level.setVisible(true);
            id_level.setVisible(true);

        }
        id_level.getItems().addAll(Level.level_1, Level.level_2, Level.level_3, Level.level_4, Level.level_5);
    }

    @FXML
    void verifier_parent(ActionEvent event) {
        if (radio_parent.isSelected()) {
            id_label_level.setVisible(false);
            id_level.setVisible(false);
            radio_enseignant.setSelected(false);
            radio_etudiant.setSelected(false);
            user.setRole("parent");

        }
    }

    @FXML
    void gotopage0(MouseEvent event) throws IOException {
        if (radio_etudiant.isSelected()) {
            user.setLevel(id_level.getValue());
        } else {
            user.setLevel(Level.level_0);
        }
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/FirstRegistrationFXML.fxml"));
        content1.getChildren().clear();
        content1.getChildren().add(newLoadedPane);
    }

}
