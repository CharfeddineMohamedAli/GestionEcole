/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Level;
import Entities.Administrateur;
import Entities.Classe;
import Entities.Etudiant;
import Entities.User;
import Services.AdminService;
import Services.ClasseService;
import Services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author admin
 */
public class AjoutClassController {
    
    @FXML
    private JFXTextField studentname;

    @FXML
    private JFXButton add_class;

    @FXML
    private JFXTextField studentLastname;

    @FXML
    private TextField number;

    @FXML
    private TextField capacity;

    @FXML
    private ComboBox<Level> level;

    @FXML
    private FontAwesomeIconView close_app;

   

  

    @FXML
    void add_c(ActionEvent event) {
        Classe classe = new Classe();
        ClasseService classeService = new ClasseService();
        Etudiant etudiant = new Etudiant();
        UserService userService = new UserService();
        User user = new User ();
        
        
        studentname.getText();
        studentLastname.getText();
        
        classe.setNum_classe(Integer.parseInt(number.getText()));
        
    }
    
    public void initialize(URL url, ResourceBundle rb) {
       level.getItems().addAll(Level.level_1,
               Level.level_2,Level.level_3,
               Level.level_4,Level.level_5);
    }
    

       @FXML
    void addcapacity(ActionEvent event) {
    }

    @FXML
    void close_app(MouseEvent event) {
        System.exit(0);
    }
}
