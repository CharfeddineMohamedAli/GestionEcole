/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HPAY104-I5-1TR
 */
public class FXMLinterfaceetudController implements Initializable {

    private Connection con = DataSource.getInstance().getConnection();

    @FXML
    private AnchorPane ach;
    @FXML
    private TableView<listeetudiants> table2;
    @FXML
    private TableColumn<listeetudiants, Integer> tabsence;
    @FXML
    private TableColumn<listeetudiants, String> tmatiére;
    @FXML
    private ImageView logo;
    @FXML
    private Pane pany;

    /**
     * Initializes the controller class.
     */
    public ObservableList<listeetudiants> show1() {

        try {
            ObservableList<listeetudiants> obl = FXCollections.observableArrayList();
            //exécution de la réquette et enregistrer le resultat dans le resultset
            PreparedStatement pt = con.prepareStatement("SELECT absence,nom_matiere,absence.id_user from absence,matiere where absence.id_mat=matiere.id_mat");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                listeetudiants ls = new listeetudiants();

                ls.setC(rs.getString("absence"));
                ls.setD(rs.getInt("nom_matiere"));

                System.out.println("le contennu est affiché");
                obl.add(ls);
            }
            return obl;

        } catch (SQLException ex) {
            System.out.println("Erreur" + ex);
        }
        return null;
    }

    public void affichelisteabsence() {

        //ajouter les valeurs au tableview
        tmatiére.setCellValueFactory(new PropertyValueFactory<>("C"));
        tabsence.setCellValueFactory(new PropertyValueFactory<>("D"));

        ObservableList<listeetudiants> obl = FXCollections.observableArrayList();

        // tableview.setItems(null);
        obl = show1();
        table2.setItems(obl);
        System.out.println("hemmm" + obl);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichelisteabsence();
    }

}
