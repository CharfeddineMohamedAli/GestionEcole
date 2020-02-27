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
import static java.lang.Integer.parseInt;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RechercheController implements Initializable {

    Note_Service ns = new Note_Service();
    public static Note note_transport = new Note();

    public static Note getNote_transport() {
        return note_transport;
    }

    public static void setNote_transport(Note note_transport) {
        RechercheController.note_transport = note_transport;
    }
    @FXML
    private AnchorPane anch;

    @FXML
    private Label labelclass;
    @FXML
    private Pane pane;

    @FXML
    private Button cons;
    @FXML
    private ImageView rech;

    @FXML
    private Label labelclass1;

    @FXML
    private ComboBox<String> comboclasse;
    @FXML
    private ComboBox<String> combomat;
    @FXML
    private Button chercher1;

    @FXML
    private Button consulter1;

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

    @FXML
    void chercher(ActionEvent event) throws SQLException {
        note_transport.setId_classe(ns.findidclassebynum(Integer.parseInt(comboclasse.getSelectionModel().getSelectedItem())));

        int n = ns.findidmatierebymatiere(combomat.getSelectionModel().getSelectedItem().toString());
        note_transport.setId_matiere(n);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/gérer_note.fxml"));
        try {
            Parent root = loader.load();
            gérer_note_controller dcp = loader.getController();
            chercher1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(gérer_note_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void consulter(ActionEvent event) throws SQLException {
        note_transport.setId_classe(ns.findidclassebynum(Integer.parseInt(comboclasse.getSelectionModel().getSelectedItem())));

        int n = ns.findidmatierebymatiere(combomat.getSelectionModel().getSelectedItem().toString());
        note_transport.setId_matiere(n);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Affichage_note_ens.fxml"));
        try {
            Parent root = loader.load();
            Affichage_note_ens_controller dcp = loader.getController();
            consulter1.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Affichage_note_ens_controller.class.getName()).log(Level.SEVERE, null, ex);
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
}
