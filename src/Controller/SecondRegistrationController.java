/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SecondRegistrationController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_Gender.getItems().addAll("Femme","Homme");
        // TODO
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
    void back1(MouseEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/FirstRegistrationFXML.fxml"));
        content2.getChildren().clear();
        content2.getChildren().add(newLoadedPane);
    
    }

    @FXML
    private void doRegistration(MouseEvent event) throws SQLException {
        User user=new User();
        UserService userService=new UserService();
        
        
        
        user.setPhone_number(Integer.parseInt(tf_Number.getText()));
        user.setCIN(Integer.parseInt(tf_CIN.getText()));
        user.setAge(Integer.parseInt(tf_Age.getText()));
        userService.ajouterUser(user);
        
    }
    
}
