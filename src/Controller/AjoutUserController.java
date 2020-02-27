/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author admin
 */
public class AjoutUserController implements Initializable {

    public static UserService userService = new UserService();

    @FXML
    private JFXTextField id_login;

    @FXML
    private JFXTextField id_mdp;

    @FXML
    void add(ActionEvent event) throws SQLException {
        /*
        User u1 = new User();
        u1.setLogin(id_login.getText());
        u1.setPassword(id_mdp.getText());
        userService.ajouterUser(u1);*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
