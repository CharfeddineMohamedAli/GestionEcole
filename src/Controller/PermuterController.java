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
public class PermuterController implements Initializable {

    public static UserService userService = new UserService();
    @FXML
    private JFXTextField id_nom1;

    @FXML
    private JFXTextField id_prenom1;

    @FXML
    private JFXTextField id_nom2;

    @FXML
    private JFXTextField id_prenom2;

    @FXML
    void permuter(ActionEvent event) throws SQLException {
        User user1 = new User();
        User user2 = new User();
        user1 = userService.FindUserByFirstAndLastName(id_nom1.getText(), id_prenom1.getText());
        user2 = userService.FindUserByFirstAndLastName(id_nom2.getText(), id_prenom2.getText());
        String classe1 = user1.getClasse();
        String classe2 = user2.getClasse();

        user1.setClasse(classe2);
        user2.setClasse(classe1);
        userService.modifierUser(user1);
        userService.modifierUser(user2);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
