/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.FirstAndSecondRegistrationController.user;
import Entities.Gender;
import Entities.Level;
import Entities.User;

//sms
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;
import java.util.regex.*;
import javafx.scene.control.Alert;
import javafx.scene.effect.BoxBlur;

/**
 *
 * @author admin
 */
public class FirstAndSecondRegistrationController implements Initializable {

    UserService userService = new UserService();
    public static User user = new User();

    @FXML
    private Button uploadimage;
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
    private JFXComboBox<Gender> cb_Gender;

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

    @FXML
    private ImageView myImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void fermer(MouseEvent event) throws IOException {

        System.exit(0);
    }

    String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
            + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";

    @FXML
    void gotopage2(MouseEvent event) throws IOException, SQLException {

        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(email.getText());
        if (controler.matches()) {
            user.setEmail(email.getText());

        } else {

            Notifications notificationBuilder = Notifications.create()
                    .title("Bad syntax of Email")
                    .text("Type a correct Email")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder.showError();
            BoxBlur blur = new BoxBlur(3, 3, 3);
            content1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Type again please");
            alert.setHeaderText("Invalid field");
            alert.setContentText("Check the field please");
            alert.showAndWait();
            content1.setEffect(null);

        }
        user.setFirst_Name(firstName.getText());
        user.setLast_Name(lastName.getText());
        if ((userService.FindUNameByUName(userName.getText())) || ((!tf_password.getText().equals(tf_repeter.getText())))) {
            if (userService.FindUNameByUName(userName.getText())) {

                Notifications notificationBuilder = Notifications.create()
                        .title("User already exists")
                        .text("Choose another user name")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.CENTER);

                notificationBuilder.showWarning();
                BoxBlur blur = new BoxBlur(3, 3, 3);
                content1.setEffect(blur);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type again please");
                alert.setHeaderText("Invalid field");
                alert.setContentText("Check the field please");
                alert.showAndWait();
                content1.setEffect(null);

            } else if ((!tf_password.getText().equals(tf_repeter.getText()))) {

                Notifications notificationBuilder = Notifications.create()
                        .title("Password isn't the same")
                        .text("Type another password")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.CENTER);

                notificationBuilder.showWarning();
                BoxBlur blur = new BoxBlur(3, 3, 3);
                content1.setEffect(blur);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type again please");
                alert.setHeaderText("Invalid field");
                alert.setContentText("Check the field please");
                alert.showAndWait();
                content1.setEffect(null);

            }
        } else {
            user.setPassword(tf_password.getText());

            user.setUser_Name(userName.getText());

            AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/SecondRegistrationFXML.fxml"));
            content1.getChildren().clear();

            content1.getChildren().add(newLoadedPane);

        }

    }

    @FXML
    void retour1(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/InitRegistration.fxml"));
        content1.getChildren().clear();
        content1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void backto1(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/FirstRegistrationFXML.fxml"));
        content2.getChildren().clear();
        content2.getChildren().add(newLoadedPane);
        ;

    }

    @FXML
    private void doRegistration(MouseEvent event) throws SQLException {
        if ((tf_CIN.getText().length() == 8) && (tf_Number.getText().length() == 8)) {
            user.setCIN(Integer.parseInt(tf_CIN.getText()));
            UserService userService = new UserService();

            user.setPhone_number(Integer.parseInt(tf_Number.getText()));
            user.setCIN(Integer.parseInt(tf_CIN.getText()));
            user.setAge(Integer.parseInt(tf_Age.getText()));
            user.setGender(cb_Gender.getValue().toString());
            userService.ajouterUser(user);
        } else if (!(tf_Number.getText().length() == 8) && (tf_CIN.getText().length() == 8)) {

            Notifications notificationBuilder = Notifications.create()
                    .title("Bad syntax of phone number")
                    .text("Type a correct phone number")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder.showError();
            BoxBlur blur = new BoxBlur(3, 3, 3);
            content2.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Type again please");
            alert.setHeaderText("Invalid field");
            alert.setContentText("Check the field please");
            alert.showAndWait();
            content2.setEffect(null);
        } else if (!(tf_CIN.getText().length() == 8) && (tf_Number.getText().length() == 8)) {
            Notifications notificationBuilder1 = Notifications.create()
                    .title("Bad syntax of Cin")
                    .text("Type a correct Cin")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder1.showError();

            BoxBlur blur = new BoxBlur(3, 3, 3);
            content2.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Type again please");
            alert.setHeaderText("Invalid field");
            alert.setContentText("Check the field please");
            alert.showAndWait();
            content2.setEffect(null);
        } else {
            Notifications notificationBuilder1 = Notifications.create()
                    .title("Bad syntax of Cin and number")
                    .text("Type a correct Cin and number")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder1.showError();

            BoxBlur blur = new BoxBlur(3, 3, 3);
            content2.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Type again please");
            alert.setHeaderText("Invalid fields");
            alert.setContentText("Check the fields please");
            alert.showAndWait();
            content2.setEffect(null);

        }

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
        id_level.getItems().clear();
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

        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/FirstRegistrationFXML.fxml"));
        content1.getChildren().clear();
        content1.getChildren().add(newLoadedPane);
    }

    @FXML
    void choose_gender(MouseEvent event) {
        cb_Gender.getItems().addAll(Gender.Homme, Gender.Femme);
    }

    @FXML
    void btnLoadEventListener(MouseEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        BufferedImage bufferedImage = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        System.out.println(file.getName());
        user.setImage_user(file.getName());
        myImageView.setImage(image);

    }

}
