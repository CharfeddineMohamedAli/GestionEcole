/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.UserService;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;

/**
 *
 * @author admin
 */
public class ModifierUserController implements Initializable {

    UserService userService = new UserService();

    @FXML
    private AnchorPane content;
    @FXML
    private JFXTextField id_nom;

    @FXML
    private JFXTextField id_prenom;

    @FXML
    private JFXTextField id_nomuser;

    @FXML
    private JFXTextField id_email;
    @FXML
    private ImageView id_image;

    @FXML
    private Label upload_image;

    @FXML
    void Modifier_user(ActionEvent event) throws SQLException, IOException {
        TableViewAllController.user_a_modifier.setFirst_Name(id_nom.getText());
        TableViewAllController.user_a_modifier.setLast_Name(id_prenom.getText());
        TableViewAllController.user_a_modifier.setUser_Name(id_nomuser.getText());
        TableViewAllController.user_a_modifier.setEmail(id_email.getText());

        userService.modifierUser(TableViewAllController.user_a_modifier);
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/TableViewAll.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
        Notifications notificationBuilder = Notifications.create()
                .title("Utilisateur modifié")
                .text("Vous avez modifié l'utilisateur")
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);

        notificationBuilder.showError();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_nom.setText(TableViewAllController.user_a_modifier.getFirst_Name());
        id_prenom.setText(TableViewAllController.user_a_modifier.getLast_Name());
        id_nomuser.setText(TableViewAllController.user_a_modifier.getUser_Name());
        id_email.setText(TableViewAllController.user_a_modifier.getEmail());
        Image im = new Image("/Images/" + TableViewAllController.user_a_modifier.getImage_user());
        id_image.setImage(im);

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
        id_image.setImage(image);
        TableViewAllController.user_a_modifier.setImage_user(file.getName());

    }
}
