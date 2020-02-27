/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Note;
import Services.Note_Service;
import Utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author nada kd
 */
public class Recherche_adminController implements Initializable {

    Note_Service ns = new Note_Service();
    public static Note note_transport = new Note();

    public static Note getNote_transport() {
        return note_transport;
    }

    public static void setNote_transport(Note note_transport) {
        RechercheController.note_transport = note_transport;
    }

    @FXML
    private ComboBox<String> comboclasse;
    @FXML
    private Label labelclass;
    @FXML
    private Pane pane;
    @FXML
    private Button consulter1;
    @FXML
    private ComboBox<String> combomat;
    @FXML
    private Label labelclass1;

    /**
     * Initializes the controller class.
     */
    private Connection con = DataSource.getInstance().getConnection();

    ObservableList combo = FXCollections.observableArrayList();
    ObservableList combo1 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillcombo();
            fillcombo2();

        } catch (SQLException ex) {

        }
    }

    public void fillcombo() throws SQLException {
        PreparedStatement pst;
        String query = "select nom_mat from matiere";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            combo.add(rs.getString("nom_mat"));
            combomat.setItems(combo);

        }

    }

    public void fillcombo2() throws SQLException {
        PreparedStatement pst;
        String query = "select num_classe from classe";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            combo1.add(rs.getString("num_classe"));
            comboclasse.setItems(combo1);

        }
    }

    @FXML
    private void consulter(ActionEvent event) throws SQLException {

        note_transport.setId_classe(ns.findidclassebynum(Integer.parseInt(comboclasse.getSelectionModel().getSelectedItem())));

        int n = ns.findidmatierebymatiere(combomat.getSelectionModel().getSelectedItem().toString());
        note_transport.setId_matiere(n);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Affichage_note_admin.fxml"));
        try {
            Parent root = loader.load();
            Affichage_note_adminController dcp = loader.getController();
            consulter1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Affichage_note_adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
