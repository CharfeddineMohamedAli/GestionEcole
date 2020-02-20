/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author admin
 */
public class LoginController implements Initializable {

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
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/FirstRegistrationFXML.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

    @FXML
    void login(ActionEvent event) {
        User user = new User();
        UserService userService = new UserService();
        username_login.getText();
        password_login.getText();

    }

    @FXML
    void close_app(MouseEvent event) {
    System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
