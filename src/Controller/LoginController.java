/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.User;
import FXML.ClassLoaderFXML;
import Services.UserService;
import Utils.UserUniTech;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author admin
 */
public class LoginController implements Initializable {

    UserService userService;

    public LoginController() {
        userService = new UserService();
    }

    @FXML
    private AnchorPane content;
    @FXML
    private JFXTextField username_login;

    @FXML
    private JFXPasswordField password_login;

    @FXML
    private JFXButton btn_login;

    @FXML
    private Label sign_up;

    @FXML
    private JFXButton signup1;

    @FXML
    void gotosignup(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(ClassLoaderFXML.class.getResource("/FXML/InitRegistration.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        User user;
        user = userService.authentifier(username_login.getText(), password_login.getText());
        if (user != null) {
            System.out.println(user);
            //static
            UserUniTech.userConnecte = user;
            AnchorPane newLoadedPane = FXMLLoader.load(ClassLoaderFXML.class.getResource("/FXML/HomeUniTech.fxml"));
            content.getChildren().clear();
            content.getChildren().add(newLoadedPane);
        }
    }

    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //enter
        password_login.setOnKeyReleased((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    login(null);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
