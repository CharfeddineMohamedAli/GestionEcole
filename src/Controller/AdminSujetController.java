/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Categorie;
import Entities.Sujet;
import Services.SujetService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdminSujetController implements Initializable {

    @FXML
    private VBox pnItems;

    @FXML
    private AnchorPane id_affichage_Forum;
    @FXML
    private JFXComboBox<Categorie> id_categorie;
    @FXML
    private JFXTextField id_recherche;
    @FXML
    private ScrollPane x;
    @FXML
    private JFXCheckBox id_nbre_vue;

    @FXML
    private JFXCheckBox id_date_creation;

    private static SujetService sujetService = new SujetService();
    /**
     * Initializes the controller class.
     */
    private static Sujet sujet_à_accepté = new Sujet();

    public static Sujet getSujet_à_accepté() {
        return sujet_à_accepté;
    }

    public static void setSujet_à_ouvrir(Sujet sujet_à_accepté) {
        AdminSujetController.sujet_à_accepté = sujet_à_accepté;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            id_categorie.getItems().addAll(Categorie.branche, Categorie.credits,
                    Categorie.matiéres, Categorie.paiement);
            loadUserGrid();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageForumController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void afficherbycategories(ActionEvent event) throws SQLException {

        pnItems.getChildren().clear();
        loadCategories();

    }

    private void loadUserGrid() throws SQLException {
        List<Sujet> sujets = fetchForums();
        Node[] nodes = new Node[sujets.size()];

        AtomicInteger i = new AtomicInteger(0);
        sujets.forEach(sujet -> {
            int j = i.getAndIncrement();
            Node node = nodes[j] = loadNewItemNode();

            displaySujetDetails(node, sujet);

            setupActions(node, sujet, j);

            setHoverStyleForNode(nodes, j);

            pnItems.getChildren().add(node);
        });

        if (nodes.length > 0) {
            pnItems.setStyle("-fx-background-color : #4B0082");
            pnItems.toFront();
        }
        x.setContent(pnItems);
        x.setVvalue(1.0d);
    }

    private List<Sujet> fetchForums() throws SQLException {
        try {
            return sujetService.readAllByEtatAdmin();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private Node loadNewItemNode() {
        try {
            return FXMLLoader.load(getClass().getResource("/FXML/Item_Verif_Admin.fxml"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void displaySujetDetails(Node node, Sujet sujet) {
        Label item_titre = (Label) node.lookup(".item_titre");
        item_titre.setText(sujet.getTitre_Sujet());
        Label item_description = (Label) node.lookup(".item_description");
        item_description.setText(sujet.getContenu_Sujet());
        Label item_categorie = (Label) node.lookup(".item_categorie");
        item_categorie.setText(sujet.getCategorie().toString());
        Label item_date = (Label) node.lookup(".item_date");
        item_date.setText(sujet.getTemps_Sujet());

        // other properties
        // ...
    }

    private void setupActions(Node node, Sujet sujet, int index) {
        Button AcceptButton = (Button) node.lookup(".item_action_modifier1");
        AcceptButton.setOnMouseClicked(AcceptEventHandler1(sujet, index));
        Button DeleteButton1 = (Button) node.lookup(".item_action_supprimer1");
        DeleteButton1.setOnMouseClicked(DeleteEventHandler1(sujet, index));

    }

    private void setHoverStyleForNode(Node[] nodes, int i) {
        final int j = i;
        nodes[i].setOnMouseEntered(even -> {
            nodes[j].setStyle("-fx-background-color : #0A0E3F");
        });
        nodes[i].setOnMouseExited(even -> {
            nodes[j].setStyle("-fx-background-color : #02030A");
        });
    }

    private EventHandler<MouseEvent> AcceptEventHandler1(Sujet sujet, int index) {
        return event -> {

            try {
                sujet.setEtat(1);
                pnItems.getChildren().remove(index);
                sujetService.modifierEtatSujet(sujet);

            } catch (SQLException ex) {
                Logger.getLogger(AdminSujetController.class.getName()).log(Level.SEVERE, null, ex);
            }

        };
    }

    private EventHandler<MouseEvent> DeleteEventHandler1(Sujet sujet, int index) {
        return event -> {

            sujetService.supprimerSujet(sujet);

            pnItems.getChildren().remove(index);

            Notifications notificationBuilder = Notifications.create()
                    .title("Sujet Supprimé")
                    .text("Vous avez supprimé votre sujet")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.showError();
        };
    }

    private List<Sujet> fetchCategories(Categorie categorie) throws SQLException {
        try {
            return sujetService.readAllSByCategorieAdmin(categorie);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private void loadCategories() throws SQLException {
        List<Sujet> sujets = fetchCategories(id_categorie.getSelectionModel().getSelectedItem());
        Node[] nodes = new Node[sujets.size()];

        AtomicInteger i = new AtomicInteger(0);
        sujets.forEach(sujet -> {
            int j = i.getAndIncrement();
            Node node = nodes[j] = loadNewItemNode();

            displaySujetDetails(node, sujet);

            setupActions(node, sujet, j);

            setHoverStyleForNode(nodes, j);

            pnItems.getChildren().add(node);
        });

        if (nodes.length > 0) {
            pnItems.setStyle("-fx-background-color : #53639F");
            pnItems.toFront();
        }
    }

    private void loadNames() throws SQLException {
        List<Sujet> sujets = fetchForums();
        Node[] nodes = new Node[sujets.size()];

        AtomicInteger i = new AtomicInteger(0);
        sujets.forEach(sujet -> {
            int j = i.getAndIncrement();
            if (sujet.getTitre_Sujet().contains(id_recherche.getCharacters())) {
                Node node = nodes[j] = loadNewItemNode();

                displaySujetDetails(node, sujet);

                setupActions(node, sujet, j);

                setHoverStyleForNode(nodes, j);

                pnItems.getChildren().add(node);
            }
        });

        if (nodes.length > 0) {
            pnItems.setStyle("-fx-background-color : #53639F");
            pnItems.toFront();
        }
    }

    @FXML
    void rechercher(KeyEvent event) throws SQLException {
        pnItems.getChildren().clear();
        loadNames();
    }

    private List<Sujet> fetchNbreVues() throws SQLException {
        try {
            return sujetService.TrierParNbreVueAdmin();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private void loadNbreVues() throws SQLException {
        List<Sujet> sujets = fetchNbreVues();
        Node[] nodes = new Node[sujets.size()];

        AtomicInteger i = new AtomicInteger(0);
        sujets.forEach(sujet -> {
            int j = i.getAndIncrement();
            Node node = nodes[j] = loadNewItemNode();

            displaySujetDetails(node, sujet);

            setupActions(node, sujet, j);

            setHoverStyleForNode(nodes, j);

            pnItems.getChildren().add(node);
        });

        if (nodes.length > 0) {
            pnItems.setStyle("-fx-background-color : #53639F");
            pnItems.toFront();
        }
    }

    private List<Sujet> fetchDateCreation() throws SQLException {
        try {
            return sujetService.TrierParDateCreationAdmin();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private void loadDateCreation() throws SQLException {
        List<Sujet> sujets = fetchDateCreation();
        Node[] nodes = new Node[sujets.size()];

        AtomicInteger i = new AtomicInteger(0);
        sujets.forEach(sujet -> {
            int j = i.getAndIncrement();
            Node node = nodes[j] = loadNewItemNode();

            displaySujetDetails(node, sujet);

            setupActions(node, sujet, j);

            setHoverStyleForNode(nodes, j);

            pnItems.getChildren().add(node);
        });

        if (nodes.length > 0) {
            pnItems.setStyle("-fx-background-color : #53639F");
            pnItems.toFront();
        }
    }

    @FXML
    void trier_par_date_creation(ActionEvent event) throws SQLException {
        if (id_date_creation.isSelected()) {
            id_nbre_vue.setSelected(false);
            pnItems.getChildren().clear();
            loadDateCreation();
        }
    }

    @FXML
    void trier_par_nbre_vue(ActionEvent event) throws SQLException {
        if (id_nbre_vue.isSelected()) {

            id_date_creation.setSelected(false);
            pnItems.getChildren().clear();
            loadNbreVues();
        }
    }

}
