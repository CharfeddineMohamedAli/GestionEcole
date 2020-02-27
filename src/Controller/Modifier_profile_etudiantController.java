/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.UserService;
import Utils.UserUniTech;
import com.jfoenix.controls.JFXButton;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
public class Modifier_profile_etudiantController implements Initializable {

    @FXML
    private JFXTextField change_first;

    @FXML
    private JFXTextField change_last;

    @FXML
    private JFXTextField change_name;

    @FXML
    private JFXTextField change_email;

    @FXML
    private JFXPasswordField change_password;

    @FXML
    private JFXPasswordField password_repeter;

    @FXML
    private JFXTextField change_number;

    @FXML
    private JFXTextField change_cin;

    @FXML
    private JFXTextField change_age;

    @FXML
    private JFXButton modifier_user;

    @FXML
    private ImageView image_etudiant;
    @FXML
    private AnchorPane content;
    @FXML
    private FontAwesomeIconView image_user;

    @FXML
    private Label upload_image;

    public static UserService userService = new UserService();

    @FXML
    void modifier_user(ActionEvent event) throws SQLException, IOException {
        UserUniTech.userConnecte.setFirst_Name(change_first.getText());
        UserUniTech.userConnecte.setLast_Name(change_last.getText());
        UserUniTech.userConnecte.setUser_Name(change_name.getText());
        UserUniTech.userConnecte.setAge(Integer.parseInt(change_age.getText()));
        UserUniTech.userConnecte.setCIN(Integer.parseInt(change_cin.getText()));
        UserUniTech.userConnecte.setEmail(change_email.getText());
        UserUniTech.userConnecte.setPassword(change_password.getText());
        UserUniTech.userConnecte.setPhone_number(Integer.parseInt(change_number.getText()));
        userService.modifierUser(UserUniTech.userConnecte);
        content.getChildren().clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        change_first.setText(UserUniTech.userConnecte.getFirst_Name());
        change_last.setText(UserUniTech.userConnecte.getLast_Name());
        change_email.setText(UserUniTech.userConnecte.getEmail());
        change_name.setText(UserUniTech.userConnecte.getUser_Name());
        change_cin.setText(String.valueOf(UserUniTech.userConnecte.getCIN()));
        change_number.setText(String.valueOf(UserUniTech.userConnecte.getPhone_number()));
        Image im = new Image("/FXML/Res/Images/" + UserUniTech.userConnecte.getImage_user());
        image_etudiant.setImage(im);
        change_password.setText(UserUniTech.userConnecte.getPassword());
        change_age.setText(String.valueOf(UserUniTech.userConnecte.getAge()));
        password_repeter.setText(UserUniTech.userConnecte.getPassword());
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
        UserUniTech.userConnecte.setImage_user(file.getName());
        image_etudiant.setImage(image);
    }
}
