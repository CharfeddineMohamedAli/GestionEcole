/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Administrateur;
import Services.AdminService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author admin
 */
public class AdminRegistrationController {
    
    @FXML
    private AnchorPane content2;

    @FXML
    private Pane id_reg1;

    @FXML
    private JFXTextField AdminLogin;

    @FXML
    private JFXTextField PassAdmin;

    @FXML
    private JFXButton cr_account;

    @FXML
   private void doRegistration1(ActionEvent event) throws SQLException {

        Administrateur admin = new Administrateur();
        AdminService adminService = new AdminService();
        
        admin.setLogin(AdminLogin.getText());
        admin.setPassword(PassAdmin.getText());
        
        adminService.ajouterAdmin(admin);
    }
}
