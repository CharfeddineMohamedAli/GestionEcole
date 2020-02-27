/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Absence;
import Services.ServiceAbsence;
import Utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HPAY104-I5-1TR
 */
public class FXMLinterfaceadminController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private Button consulter;
    @FXML
    private Pane pane;
    @FXML
    private ComboBox<String> mati1;
    @FXML
    private Label mati;

    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillcombo();
            fillcombo2();

        } catch (SQLException ex) {

        }
    }
    private Connection con = DataSource.getInstance().getConnection();
    ServiceAbsence ns = new ServiceAbsence();
    public static Absence absence_transport = new Absence();

    public static Absence getAbsence_transport() {
        return absence_transport;
    }

    @FXML
    private void consult(ActionEvent event) throws IOException, SQLException {

        absence_transport.setId_classe(ns.findidclassebynum(Integer.parseInt((String) combobox.getSelectionModel().getSelectedItem())));
        absence_transport.setId_mat(ns.findidmatierebymatiere(mati1.getSelectionModel().getSelectedItem().toString()));

        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/interfaceconsultadmin.fxml"));
        content.getChildren().clear();
        content.getChildren().add(newLoadedPane);

    }
    ObservableList combo = FXCollections.observableArrayList();
    ObservableList combo1 = FXCollections.observableArrayList();

    public void fillcombo() throws SQLException {
        PreparedStatement pst;
        String query = "select nom_matiere from matiere";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            combo.add(rs.getString("nom_matiere"));
            mati1.setItems(combo);

        }

    }

    public void fillcombo2() throws SQLException {
        PreparedStatement pst;
        String query = "select num_classe from classe";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            combo1.add(rs.getString("num_classe"));
            combobox.setItems(combo1);

        }

    }

}
