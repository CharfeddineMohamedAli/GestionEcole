/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Level;
import Entities.User;
import Services.ClasseService;
import Services.UserService;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author admin
 */
public class AffecterController implements Initializable{
    public static UserService userService = new UserService();
    public static ClasseService classeService = new ClasseService();
    public static User user_a_affecter = new User();
    
    
    @FXML
    private AnchorPane content;
  @FXML
    private JFXComboBox<Level> choose_level;

    @FXML
    private ScrollPane x;

    @FXML
    private VBox pnItems;

    @FXML
    void choose_level(ActionEvent event) throws SQLException {
        pnItems.getChildren().clear();
        loadUserGrid(choose_level.getValue());
        
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

             choose_level.getItems().addAll(Level.level_1,Level.level_2,Level.level_3,Level.level_4,Level.level_5);
                    }
    
     private void loadUserGrid(Level level) throws SQLException {
		List<User> users = fetchUsers(level);
		Node[] nodes = new Node[users.size()];

		AtomicInteger i = new AtomicInteger(0);
		users.forEach(user -> {
			int j = i.getAndIncrement();
			Node node = nodes[j] = loadNewItemNode();

                    try {
                        displaySujetDetails(node, user);
                    } catch (SQLException ex) {
                        Logger.getLogger(AffecterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    try {
                        setupActions(node, user, j);
                    } catch (SQLException ex) {
                        Logger.getLogger(AffecterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }

			setHoverStyleForNode(nodes, j);

			pnItems.getChildren().add(node);
		});

		if (nodes.length > 0) {
			pnItems.setStyle("-fx-background-color : #53639F");
			pnItems.toFront();
		}
                 x.setContent(pnItems);
            x.setVvalue(1.0d);
	}


	private List<User> fetchUsers(Level level) throws SQLException {
		try {
			return userService.readAllUserByLevel(level);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	private Node loadNewItemNode() {
		try {
			return FXMLLoader.load(getClass().getResource("/FXML/Item.fxml"));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private void displaySujetDetails(Node node, User user) throws SQLException {
		Label item_first = (Label) node.lookup(".item_first");
		item_first.setText(user.getFirst_Name());
		Label item_last = (Label) node.lookup(".item_last");
		item_last.setText(user.getLast_Name());
                JFXComboBox<String> item_classe = (JFXComboBox) node.lookup(".item_classe");
		item_classe.getItems().addAll(classeService.readAllByLevel1(choose_level.getValue()));
               // System.out.println(item_classe.getSelectionModel().getSelectedItem());
              
	}

	private void setupActions(Node node, User user, int index) throws SQLException {
		Button openButton = (Button) node.lookup(".item_action_affecter");
		openButton.setOnMouseClicked(OpenEventHandler(node,user, index));
                
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

	private EventHandler<MouseEvent> OpenEventHandler(Node node,User user, int index) {
		return event -> {
                   JFXComboBox<String> item_classe = (JFXComboBox) node.lookup(".item_classe");
                    System.out.println(item_classe.getValue());
                        user.setClasse(item_classe.getValue());
                    try {
                        userService.modifierUser(user);
                        pnItems.getChildren().clear();
                        loadUserGrid(choose_level.getValue());
                        /*
                        try {
                        
                        
                        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/Detail_Sujet.fxml"));
                        content.getChildren().clear();
                        content.getChildren().add(newLoadedPane);
                        
                        } catch (IOException ex) {
                        Logger.getLogger(AffecterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }*/
                    } catch (SQLException ex) {
                        Logger.getLogger(AffecterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
               
		};
	}
        
        
        
	

    
}
