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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class TableViewAllController implements Initializable {

    //FilteredList filt = new FilteredList(userService.readAll(),e->true);
    UserService userService = new UserService();
    public static User user_a_modifier = new User();
    /**
     * Initializes the controller class.
     */

    @FXML
    private JFXTextField search_user;

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
        firstname.setCellValueFactory(new PropertyValueFactory<User, String>("first_Name"));
        lastname.setCellValueFactory(new PropertyValueFactory<User, String>("last_Name"));
        username.setCellValueFactory(new PropertyValueFactory<User, String>("user_Name"));
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        role1.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        try {
            tableUser.getItems().setAll(userService.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(TableViewAllController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void supprimer(ActionEvent event) {
        int n = 0;
        ObservableList<User> selectedRows, User;
        User = tableUser.getItems();
        selectedRows = tableUser.getSelectionModel().getSelectedItems();
        for (User user : selectedRows) {
            User.remove(user);

            userService.supprimerUser(user);

        }
        Notifications notificationBuilder = Notifications.create()
                .title("Utilisateur Supprimé")
                .text("Vous avez supprimé l'utilisateur")
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);

        notificationBuilder.showError();

    }

    @FXML
    void btn_modifier(ActionEvent event) throws IOException {
        user_a_modifier = tableUser.getSelectionModel().getSelectedItem();
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/ModifierUserFXML.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }

    /*
    void SearchChasse(ActionEvent event) {
        ChasseService cs = new ChasseService();
        ArrayList AL = (ArrayList) cs.displayAll();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Chasse> filteredData = new FilteredList<>(OReservation, p -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getAnimal()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<Chasse> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TableChasse.comparatorProperty());
        TableChasse.setItems(sortedData);
    }*/
    @FXML
    void searchUser(KeyEvent event) throws SQLException {
        UserService cs = new UserService();
        ArrayList AL = (ArrayList) cs.readAll();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<User> filteredData = new FilteredList<>(OReservation, p -> true);
        search_user.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getFirst_Name()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<User> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableUser.comparatorProperty());
        tableUser.setItems(sortedData);
    }
}
