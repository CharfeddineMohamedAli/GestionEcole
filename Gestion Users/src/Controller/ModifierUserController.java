/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.UserService;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author admin
 */
public class ModifierUserController implements Initializable{
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
    void Modifier_user(ActionEvent event) throws SQLException, IOException {
        TableViewAllController.user_a_modifier.setFirst_Name(id_nom.getText());
        TableViewAllController.user_a_modifier.setLast_Name(id_prenom.getText());
        TableViewAllController.user_a_modifier.setUser_Name(id_nomuser.getText());
        TableViewAllController.user_a_modifier.setEmail(id_email.getText());
        userService.modifierUser(TableViewAllController.user_a_modifier);
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/TableViewAll.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);
        /*Notifications notificationBuilder = Notifications.create()
                    .title("Utilisateur modifié")
                    .text("Vous avez modifié l'utilisateur")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.showError();*/
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       id_nom.setText(TableViewAllController.user_a_modifier.getFirst_Name());
              id_prenom.setText(TableViewAllController.user_a_modifier.getLast_Name());
       id_nomuser.setText(TableViewAllController.user_a_modifier.getUser_Name());
       id_email.setText(TableViewAllController.user_a_modifier.getEmail());
       
    }
}