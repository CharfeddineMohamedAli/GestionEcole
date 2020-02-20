/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.User;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.util.Duration;



/**
 * FXML Controller class
 *
 * @author admin
 */
public class TableViewAllController implements Initializable {
UserService userService=new UserService();
public static User user_a_modifier = new User();
    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane content;

    @FXML
    private TableView<User> tableUser;

    @FXML
    private TableColumn<User, String> firstname;

    @FXML
    private TableColumn<User, String> lastname;

    @FXML
    private TableColumn<User, String> username;

    @FXML
    private TableColumn<User, String> email;
      @FXML
    private TableColumn<User, String> role1;
      @FXML
    private JFXButton supp;
  @FXML
    private JFXButton modiier_id;

    

       @FXML
    void ChangeNom(ActionEvent event) {
    

    }
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        firstname.setCellValueFactory(new PropertyValueFactory<User,String>("first_Name"));
       lastname.setCellValueFactory(new PropertyValueFactory<User,String>("last_Name"));
       username.setCellValueFactory(new PropertyValueFactory<User,String>("user_Name"));
         email.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
         role1.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
           try {
                tableUser.getItems().setAll(userService.readAll());
            } catch (SQLException ex) {
                Logger.getLogger(TableViewAllController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
      
      
      @FXML
    void supprimer(ActionEvent event) {
        int n=0;
        ObservableList<User> selectedRows,User;
        User=tableUser.getItems();
       selectedRows=tableUser.getSelectionModel().getSelectedItems();
        for(User user:selectedRows){
            User.remove(user);
       // n=tableUser.getSelectionModel().getSelectedItems().indexOf(user);
        //User user1=new User();
        //user1.setId_user(n);
        //userService.FindNomUserByIdUser(n);
        userService.supprimerUser(user);
        /*Notifications notificationBuilder = Notifications.create()
                    .title("Utilisateur Supprimé")
                    .text("Vous avez supprimé l'utilisateur")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.showError();*/
    }
        
        
    }
    
    @FXML
    void btn_modifier(ActionEvent event) throws IOException {
        user_a_modifier = tableUser.getSelectionModel().getSelectedItem();
         AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/ModifierUserFXML.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }
    }    
  
    
  



    