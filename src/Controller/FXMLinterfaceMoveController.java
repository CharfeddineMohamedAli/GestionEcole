/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HPAY104-I5-1TR
 */
public class FXMLinterfaceMoveController implements Initializable {
    private Connection con = DataSource.getInstance().getConnection();

    @FXML
    private AnchorPane ach;
    @FXML
    private TableView<listeetudiantsO> table2;
    @FXML
    private TableColumn<listeetudiantsO, String> tnom;
    @FXML
    private TableColumn<listeetudiantsO, String> tprenom;
  
    @FXML
    private TableColumn<listeetudiantsO, String> tmatiére;
    @FXML
    private TableColumn<listeetudiantsO, Integer> cinl;
      @FXML
    private TableColumn<listeetudiantsO, Integer> tabsence;

    @FXML
    private ImageView logo;
    @FXML
    private Pane pany;
    @FXML
    private Button retour0;
    @FXML
    private ImageView imgretour;

    /**
     * Initializes the controller class.
     */
   public ObservableList<listeetudiantsO> show1(int id_classe,int id_matiere) {

        try {
            ObservableList<listeetudiantsO> obl = FXCollections.observableArrayList();
            //exécution de la réquette et enregistrer le resultat dans le resultset
            PreparedStatement pt = con.prepareStatement("SELECT first_Name,last_Name,absence.id_user,absence from absence ,user WHERE absence.id_user=user.id_user AND absence.id_classe= '"+id_classe+"' AND absence.id_mat= '"+id_matiere+"'");
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
        
           
                       
      //ajouter les valeurs au tableview
      tnom.setCellValueFactory(new PropertyValueFactory<>("A"));
      tprenom.setCellValueFactory(new PropertyValueFactory<>("B"));
      tmatiére.setCellValueFactory(new PropertyValueFactory<>("C"));
      tabsence.setCellValueFactory(new PropertyValueFactory<>("D"));
      cinl.setCellValueFactory(new PropertyValueFactory<>("E"));

    int n=FXMLAdminButtController.getAbsence_transport().getId_mat();
       int  nn= FXMLAdminButtController.getAbsence_transport().getId_classe();  
      ObservableList<listeetudiantsO> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
     obl=show1(nn,n); 
      table2.setItems(obl);
      System.out.println("hemmm"+obl);

                      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichelisteabsence();
        // TODO
    }    

    

    @FXML
    private void retour0(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/AdminButtCons.fxml"));
        ach.getChildren().clear();
        ach.getChildren().add(newLoadedPane);
    }

   
}