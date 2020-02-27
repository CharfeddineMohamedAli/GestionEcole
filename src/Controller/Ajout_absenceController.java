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
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Notifications;

/**
 *
 * @author nada kd
 */
public class Ajout_absenceController implements Initializable {

    private Connection con = DataSource.getInstance().getConnection();
    @FXML
    private CheckBox trieabs;

    @FXML
    private TableColumn<listeetudiantsO, Integer> colocin;

    @FXML
    private AnchorPane anachronpane;

    @FXML
    private TextField labelabsent;

    @FXML
    private Button mod;

    @FXML
    private Button supprimer;

    @FXML
    private Button retour;

    @FXML
    private TableView<listeetudiantsO> table;

    @FXML
    private TableColumn<listeetudiantsO, String> nom;

    @FXML
    private TableColumn<listeetudiantsO, String> prenom;

    // @FXML
    // private TableColumn<listeetudiants, Integer> seance;
    @FXML
    private TableColumn<listeetudiantsO, String> mat;

    @FXML
    private TableColumn<listeetudiantsO, Integer> abs;
    @FXML
    private Button ajouter;
    @FXML
    private Label label;
    @FXML
    private Pane cont;
    @FXML
    private ImageView content1;
    @FXML
    private ImageView imgretour;
    @FXML
    private Label cin;
    @FXML
    private TextField recherche;
    @FXML
    private ImageView imgrech;

    @FXML
    private TextField cin1;
    @FXML
    private Button mail;

    @FXML
    private void searshcin(KeyEvent event) {
        int n = 0;
        int nn = 0;
        n = FXMLinterfaceController.getAbsence_transport().getId_mat();
        nn = FXMLinterfaceController.getAbsence_transport().getId_classe();
        listeetudiantsO ls = new listeetudiantsO();
        FilteredList filt = new FilteredList(show1(nn, n), e -> true);
        recherche.textProperty().addListener((Observable, oldValue, newValue) -> {
            filt.setPredicate((Predicate<? super listeetudiantsO>) (listeetudiantsO listeetudiantsO) -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                } else if (listeetudiantsO.getA().toLowerCase().indexOf(lowerCaseFilter) != -1) {

                    return true;
                }

                return false;
            });

        });
        SortedList sort = new SortedList(filt);
        sort.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sort);

    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/FXMLinterface.fxml"));
        anachronpane.getChildren().clear();
        anachronpane.getChildren().add(newLoadedPane);

    }

    @FXML
    void trieparabsence(ActionEvent event) {
        if (trieabs.isSelected()) {
            affichelisteabsence();
        } else {
            affichelisteabsence2();
        }

    }

    public ObservableList<listeetudiantsO> show2(int id_classe, int id_matiere) {

        try {
            ObservableList<listeetudiantsO> obl = FXCollections.observableArrayList();
            //exécution de la réquette et enregistrer le resultat dans le resultset
            PreparedStatement pt = con.prepareStatement("SELECT first_Name,last_Name,absence.id_user,absence from absence ,user WHERE absence.id_user=user.id_user AND absence.id_classe= '" + id_classe + "' AND absence.id_mat= '" + id_matiere + "' order by absence");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                listeetudiantsO ls = new listeetudiantsO();

                ls.setA(rs.getString("first_Name"));
                ls.setB(rs.getString("last_Name"));
                ls.setC(rs.getString("absence"));
                ls.setE(rs.getInt("id_user"));

                System.out.println("heeeeeeeyyyyyy");
                obl.add(ls);
            }
            return obl;

        } catch (SQLException ex) {
            System.out.println("Erreur" + ex);
        }
        return null;
    }

    public ObservableList<listeetudiantsO> show1(int id_classe, int id_matiere) {

        try {
            ObservableList<listeetudiantsO> obl = FXCollections.observableArrayList();
            //exécution de la réquette et enregistrer le resultat dans le resultset
            PreparedStatement pt = con.prepareStatement("SELECT first_Name,last_Name,absence.id_user,absence from absence ,user WHERE absence.id_user=user.id_user AND absence.id_classe= '" + id_classe + "' AND absence.id_mat= '" + id_matiere + "'");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                listeetudiantsO ls = new listeetudiantsO();

                ls.setA(rs.getString("first_Name"));
                ls.setB(rs.getString("last_Name"));
                ls.setC(rs.getString("absence"));
                // ls.setD(rs.getString("id_mat"));
                ls.setE(rs.getInt("id_user"));

                System.out.println("heeeeeeeyyyyyy");
                obl.add(ls);
            }
            return obl;

        } catch (SQLException ex) {
            System.out.println("Erreur" + ex);
        }
        return null;
    }

    public void affichelisteabsence() {
        int n = 0;
        int nn = 0;
        n = FXMLinterfaceController.getAbsence_transport().getId_mat();
        nn = FXMLinterfaceController.getAbsence_transport().getId_classe();
        //ajouter les valeurs au tableview
        nom.setCellValueFactory(new PropertyValueFactory<>("A"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("B"));
        // mat.setCellValueFactory(new PropertyValueFactory<>("C"));
        abs.setCellValueFactory(new PropertyValueFactory<>("C"));
        colocin.setCellValueFactory(new PropertyValueFactory<>("E"));

        ObservableList<listeetudiantsO> obl = FXCollections.observableArrayList();

        // tableview.setItems(null);
        obl = show1(nn, n);
        table.setItems(obl);
        System.out.println("hemmm" + obl);

    }

    public void affichelisteabsence2() {

        //ajouter les valeurs au tableview
        nom.setCellValueFactory(new PropertyValueFactory<>("A"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("B"));
        // mat.setCellValueFactory(new PropertyValueFactory<>("C"));
        abs.setCellValueFactory(new PropertyValueFactory<>("C"));
        colocin.setCellValueFactory(new PropertyValueFactory<>("E"));

        ObservableList<listeetudiantsO> obl = FXCollections.observableArrayList();
        int n = FXMLinterfaceController.getAbsence_transport().getId_mat();
        int nn = FXMLinterfaceController.getAbsence_transport().getId_classe();
        // tableview.setItems(null);
        obl = show2(nn, n);
        table.setItems(obl);
        System.out.println("hemmm" + obl);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int n = 0;
        int nn = 0;
        n = FXMLinterfaceController.getAbsence_transport().getId_mat();
        nn = FXMLinterfaceController.getAbsence_transport().getId_classe();
        listeetudiantsO ls = new listeetudiantsO();

        affichelisteabsence();

    }

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
        int n = FXMLinterfaceController.getAbsence_transport().getId_mat();
        int nn = FXMLinterfaceController.getAbsence_transport().getId_classe();

        if (sb.findiduserbyiduser(parseInt(cin1.getText()))) {
            Notifications NotificationBuilder = Notifications.create().title("absence deja ajouté").text("").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();

        } else if ((sb.findiduser(parseInt(cin1.getText())))) {
            Notifications NotificationBuilder = Notifications.create().text("cin introuvable").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();
        } else if ((!labelabsent.getText().isEmpty()) && (!cin1.getText().isEmpty())) {
            int cin = Integer.parseInt(cin1.getText());
            int abs = Integer.parseInt(labelabsent.getText());
            Absence sn = new Absence(cin, abs, n, nn);

            sb.ajouter(sn);

            affichelisteabsence();

        } else {

            Notifications NotificationBuilder = Notifications.create().title("veuillez remplir les champs").text("").position(Pos.TOP_RIGHT);
            NotificationBuilder.show();

        }

    }

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {

        ServiceAbsence n = new ServiceAbsence();
        listeetudiantsO ls = new listeetudiantsO();
        ls = table.getSelectionModel().getSelectedItem();
        n.supprimer(ls.getE());
        Notifications notificationBuilder = Notifications.create()
                .title("absence supprimé")
                .text("")
                // .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);

        notificationBuilder.show();
        affichelisteabsence();

    }

    @FXML

    void Modifier(ActionEvent event) throws SQLException {
        ServiceAbsence sn = new ServiceAbsence();
        listeetudiantsO ls;
        ls = table.getSelectionModel().getSelectedItem();
        ls.setC(labelabsent.getText());

        sn.Modifier(ls);
        Notifications notificationBuilder = Notifications.create()
                .title("absence modifié")
                .text("")
                // .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);

        notificationBuilder.show();
        affichelisteabsence();

    }
    //To change body of generated methods, choose Tools | Templates.

    ServiceAbsence sb = new ServiceAbsence();

    @FXML
    private void Mailing(javafx.scene.input.MouseEvent event) throws SQLException, Exception {

        ServiceAbsence n = new ServiceAbsence();
        listeetudiantsO ls = new listeetudiantsO();
        ls = table.getSelectionModel().getSelectedItem();
        n.findiduserbyiduserInterface(ls.getE());
        //System.out.println(n.findiduserbyiduserInterface(ls.getE()).toString());

        JavamailUtil mail = new JavamailUtil();
        mail.sendMail(n.findiduserbyiduserInterfaceMail(ls.getE()));

    }

}
