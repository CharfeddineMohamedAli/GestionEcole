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
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Notifications;

public class gérer_note_controller implements Initializable {

    Note note = new Note();

    private Connection con = DataSource.getInstance().getConnection();
    RechercheController rc = new RechercheController();

    @FXML
    private AnchorPane content1;

    @FXML
    private TableView<listeetudiants> tabnote;

    @FXML
    private TableColumn<listeetudiants, String> cc;
    @FXML
    private TableColumn<listeetudiants, String> ds;

    @FXML
    private TableColumn<listeetudiants, String> exam;
    @FXML
    private TableColumn<listeetudiants, String> nom_etud;
    @FXML
    private TextField search1;

    @FXML
    private TextField tfexam;

    @FXML
    private TextField tfcc;

    @FXML
    private TextField tfds;

    @FXML
    private TextField tfcin;
    @FXML
    private CheckBox tri;
    @FXML
    private TableColumn<listeetudiants, String> prenom_etud;

    @FXML
    private TableColumn<listeetudiants, Integer> cin;

    @FXML
    private Button retour;

    public ObservableList<listeetudiants> show1(int id_classe, int id_matiere) {

        
             try {
            ObservableList<listeetudiants> obl = FXCollections.observableArrayList();
            //exécution de la réquette et enregistrer le resultat dans le resultset
            PreparedStatement pt = con.prepareStatement("SELECT note_cc,note_ds,note_exam,user.id_user,first_Name,last_Name from note ,user  where note.id_user=user.id_user AND note.id_classe= '" + id_classe + "'=user.id_classe AND id_matiere= '" + id_matiere + "'");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                listeetudiants ls = new listeetudiants();

                ls.setA(rs.getString("note_cc"));
                ls.setB(rs.getString("note_ds"));
                ls.setC(rs.getString("note_exam"));
                ls.setD( rs.getInt("id_user"));

                ls.setF(rs.getString("first_Name"));
                ls.setG(rs.getString("last_Name"));

                obl.add(ls);
            }
            return obl;

        } catch (SQLException ex) {
            System.out.println("Erreur" + ex);
        }
        return null;
    }

    public ObservableList<listeetudiants> show2(int id_classe, int id_matiere) {

        try {
            ObservableList<listeetudiants> obl = FXCollections.observableArrayList();
            //exécution de la réquette et enregistrer le resultat dans le resultset
            PreparedStatement pt = con.prepareStatement("SELECT note_cc,note_ds,note_exam,user.id_user,first_Name,last_Name from note ,user  where note.id_user=user.id_user AND note.id_classe= '" + id_classe + "'=user.id_classe AND id_matiere= '" + id_matiere + "' order by first_Name");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                listeetudiants ls = new listeetudiants();

                ls.setA(rs.getString("note_cc"));
                ls.setB(rs.getString("note_ds"));
                ls.setC(rs.getString("note_exam"));
                ls.setD( rs.getInt("id_user"));

                ls.setF(rs.getString("first_Name"));
                ls.setG(rs.getString("last_Name"));

                obl.add(ls);
            }
            return obl;

        } catch (SQLException ex) {
            System.out.println("Erreur" + ex);
        }
        return null;
    }

    public void affichelistenoteOrderByFirstName() {

        //ajouter les valeurs au tableview
        cc.setCellValueFactory(new PropertyValueFactory<>("A"));
        ds.setCellValueFactory(new PropertyValueFactory<>("B"));
        exam.setCellValueFactory(new PropertyValueFactory<>("C"));
        cin.setCellValueFactory(new PropertyValueFactory<>("D"));

        nom_etud.setCellValueFactory(new PropertyValueFactory<>("F"));
        prenom_etud.setCellValueFactory(new PropertyValueFactory<>("G"));
        ObservableList<listeetudiants> obl = FXCollections.observableArrayList();
        int n = RechercheController.getNote_transport().getId_matiere();
        int nn = RechercheController.getNote_transport().getId_classe();
        // tableview.setItems(null);
        obl = show2(nn, n);
        tabnote.setItems(obl);
        System.out.println("" + obl);

    }

    public void affichelistenote() {

        int n = RechercheController.getNote_transport().getId_matiere();
        int nn = RechercheController.getNote_transport().getId_classe();

        //ajouter les valeurs au tableview
        cc.setCellValueFactory(new PropertyValueFactory<>("A"));
        ds.setCellValueFactory(new PropertyValueFactory<>("B"));
        exam.setCellValueFactory(new PropertyValueFactory<>("C"));
        cin.setCellValueFactory(new PropertyValueFactory<>("D"));
        System.out.println(n);
        System.out.println(nn);
        nom_etud.setCellValueFactory(new PropertyValueFactory<>("F"));
        prenom_etud.setCellValueFactory(new PropertyValueFactory<>("G"));
        ObservableList<listeetudiants> obl = FXCollections.observableArrayList();

        // tableview.setItems(null);
        obl = show1(nn, n);
        tabnote.setItems(obl);
        System.out.println("" + obl);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int n = 0;
        int nn = 0;
        n = RechercheController.getNote_transport().getId_matiere();
        nn = RechercheController.getNote_transport().getId_classe();
        affichelistenote();

    }

    Note_Service sb = new Note_Service();

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
        if ((tfds.getText().isEmpty()) && (tfexam.getText().isEmpty())) {

            if (!sb.findiduserbyiduser(parseInt(tfcin.getText()))) {
                Image img = new Image("/FXML/Res/Images/supp.png");
                Notifications NotificationBuilder = Notifications.create().text("Note déja ajouter").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();

            } else if ((sb.findiduser(parseInt(tfcin.getText())))) {
                Image img = new Image("/FXML/Res/Images/cinin.png");
                Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("cin introuvable").position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
            } else {
                int n = RechercheController.getNote_transport().getId_matiere();
                int nn = RechercheController.getNote_transport().getId_classe();
                float cc1 = parseFloat(tfcc.getText());
                int idetd1 = parseInt(tfcin.getText());
                Note sn = new Note();
                sn.setId_classe(nn);
                sn.setId_matiere(n);
                sn.setId_user(idetd1);
                sn.setNote_cc(cc1);
                sb.ajouter1(sn);
                Image img = new Image("/FXML/Res/Images/check.png");
                Notifications NotificationBuilder = Notifications.create().text("Note ajouté avec succés").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
                affichelistenote();
            }

        } else if ((tfcc.getText().isEmpty()) && (tfexam.getText().isEmpty())) {
            if (!sb.findiduserbyiduser(parseInt(tfcin.getText()))) {
                Image img = new Image("/FXML/Res/Images/supp.png");
                Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("note déja ajouter").position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
            } else if ((sb.findiduser(parseInt(tfcin.getText())))) {
                Image img = new Image("/FXML/Res/Images/cinin.png");
                Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("cin introuvable").position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
            } else {
                int n = RechercheController.getNote_transport().getId_matiere();
                int nn = RechercheController.getNote_transport().getId_classe();
                float ds = parseFloat(tfds.getText());
                int idetd1 = parseInt(tfcin.getText());
                Note sn = new Note();
                sn.setId_classe(nn);
                sn.setId_matiere(n);
                sn.setId_user(idetd1);
                sn.setNote_ds(ds);
                sb.ajouter2(sn);
                Image img = new Image("/FXML/Res/Images/check.png");
                Notifications NotificationBuilder = Notifications.create().text("Note ajouté avec succés").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
                affichelistenote();
            }
        } else if ((tfcc.getText().isEmpty()) && (tfds.getText().isEmpty())) {
            if (!sb.findiduserbyiduser(parseInt(tfcin.getText()))) {
                Image img = new Image("/FXML/Res/Images/supp.png");
                Notifications NotificationBuilder = Notifications.create().text("note déja ajouter").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();

            } else if ((sb.findiduser(parseInt(tfcin.getText())))) {
                Notifications NotificationBuilder = Notifications.create().text("cin introuvable").position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
            } else {

                int n = RechercheController.getNote_transport().getId_matiere();
                int nn = RechercheController.getNote_transport().getId_classe();
                float ex = parseFloat(tfexam.getText());
                int idetd1 = parseInt(tfcin.getText());
                Note sn = new Note();
                sn.setId_classe(nn);
                sn.setId_matiere(n);
                sn.setId_user(idetd1);
                sn.setNote_exam(ex);

                sb.ajouter3(sn);
                Image img = new Image("/FXML/Res/Images/check.png");
                Notifications NotificationBuilder = Notifications.create().text("Note ajouté avec succés").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
                affichelistenote();
            }
        } else if ((tfexam.getText().isEmpty())) {
            if (!sb.findiduserbyiduser(parseInt(tfcin.getText()))) {
                Image img = new Image("/FXML/Res/Images/supp.png");
                Notifications NotificationBuilder = Notifications.create().text("note déja ajouter").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();

            } else if ((sb.findiduser(parseInt(tfcin.getText())))) {
                Image img = new Image("/FXML/Res/Images/cinin.png");

                Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("cin introuvable").position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
            } else {
                int n = RechercheController.getNote_transport().getId_matiere();
                int nn = RechercheController.getNote_transport().getId_classe();
                float cc1 = parseFloat(tfcc.getText());
                float cc2 = parseFloat(tfds.getText());
                int idetd1 = parseInt(tfcin.getText());

                Note sn = new Note();
                sn.setNote_cc(cc1);
                sn.setNote_ds(cc2);
                sn.setId_user(idetd1);

                sn.setId_classe(nn);
                sn.setId_matiere(n);

                sb.ajouter4(sn);
                Image img = new Image("/FXML/Res/Images/check.png");
                Notifications NotificationBuilder = Notifications.create().text("Note ajouté avec succés").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
                NotificationBuilder.show();
                affichelistenote();
            }
        } else if (!sb.findiduserbyiduser(parseInt(tfcin.getText()))) {
            Image img = new Image("/FXML/Res/Images/supp.png");
            Notifications NotificationBuilder = Notifications.create().text("note déja ajouter").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
            NotificationBuilder.show();

        } else if ((sb.findiduser(parseInt(tfcin.getText())))) {
            Image img = new Image("/FXML/Res/Images/cinin.png");
            Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("cin introuvable").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
        } else {
            int n = RechercheController.getNote_transport().getId_matiere();
            int nn = RechercheController.getNote_transport().getId_classe();

            float cc1 = parseFloat(tfcc.getText());
            float ds1 = parseFloat(tfds.getText());

            float examen1 = parseFloat(tfexam.getText());

            int idetd1 = parseInt(tfcin.getText());
            Note sn = new Note();
            sn.setNote_cc(cc1);
            sn.setNote_ds(ds1);
            sn.setNote_exam(examen1);
            sn.setId_classe(nn);
            sn.setId_matiere(n);
            sn.setId_user(idetd1);
            sb.ajouterall(sn);
            Image img = new Image("/FXML/Res/Images/check.png");
            Notifications NotificationBuilder = Notifications.create().text("Note ajouté avec succés").graphic(new ImageView(img)).position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
            affichelistenote();
        }
        affichelistenote();
    }

    @FXML
    void retour1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/recherche.fxml"));
        try {
            Parent root = loader.load();
            RechercheController dcp = loader.getController();
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(RechercheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {

        Note_Service n = new Note_Service();
        listeetudiants ls = new listeetudiants();
        ls = tabnote.getSelectionModel().getSelectedItem();
        n.supprimer(ls.getD());
        Image img = new Image("/FXML/Res/Images/supprimer.png");
        Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("Note supprimé avec succés").position(Pos.TOP_RIGHT);
        NotificationBuilder.show();
        affichelistenote();

    }

    int n = RechercheController.getNote_transport().getId_matiere();
    int nn = RechercheController.getNote_transport().getId_classe();
    listeetudiants ls = new listeetudiants();
    FilteredList filt = new FilteredList(show1(nn, n), e -> true);

    @FXML

    void Modifier(ActionEvent event) throws SQLException {
        Note_Service sn = new Note_Service();
        listeetudiants ls;
        if ((tfds.getText().isEmpty()) && (tfexam.getText().isEmpty())) {
            ls = tabnote.getSelectionModel().getSelectedItem();
            ls.setA(tfcc.getText());
            sn.Modifier(ls);
            Image img = new Image("/FXML/Res/Images/edit.png");
            Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("Note modifié avec succés").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
            affichelistenote();
        } else if ((tfcc.getText().isEmpty()) && (tfexam.getText().isEmpty())) {
            ls = tabnote.getSelectionModel().getSelectedItem();

            ls.setB(tfds.getText());
            sn.Modifier(ls);
            Image img = new Image("/FXML/Res/Images/edit.png");
            Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("Note modifié avec succés").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
            affichelistenote();
        } else if ((tfcc.getText().isEmpty()) && (tfds.getText().isEmpty())) {
            ls = tabnote.getSelectionModel().getSelectedItem();

            ls.setC(tfexam.getText());
            sn.Modifier(ls);
            Image img = new Image("/FXML/Res/Images/edit.png");
            Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("Note modifié avec succés").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
            affichelistenote();
        } else {
            ls = tabnote.getSelectionModel().getSelectedItem();
            ls.setA(tfcc.getText());
            ls.setB(tfds.getText());
            ls.setC(tfexam.getText());
            sn.Modifier(ls);
            Image img = new Image("/FXML/Res/Images/edit.png");
            Notifications NotificationBuilder = Notifications.create().graphic(new ImageView(img)).text("Note modifié avec succés").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
            affichelistenote();
        }
    }

    @FXML
    void Triparnom(ActionEvent event) {
        if (tri.isSelected()) {
            affichelistenoteOrderByFirstName();
        } else {
            affichelistenote();
        }

    }

    @FXML
    private void searchcin(javafx.scene.input.KeyEvent event) {
        search1.textProperty().addListener((Observable, oldValue, newValue) -> {
            filt.setPredicate((Predicate<? super listeetudiants>) (listeetudiants listeetudiants) -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                } else if (listeetudiants.getF().toLowerCase().indexOf(lowerCaseFilter) != -1) {

                    return true;
                }

                return false;
            });

        });
        SortedList sort = new SortedList(filt);
        sort.comparatorProperty().bind(tabnote.comparatorProperty());
        tabnote.setItems(sort);

    }

}
