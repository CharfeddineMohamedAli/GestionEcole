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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class Affichage_note_etud_controller implements Initializable {

   private Connection con = DataSource.getInstance().getConnection();
    @FXML
    private TableView<listeetudiants> tabnote;
    @FXML
    private TableColumn<listeetudiants, String> nom_mat;
    @FXML
    private TableColumn<listeetudiants, Integer> coef;
    @FXML
    private TableColumn<listeetudiants, String> note_cc;
    @FXML
    private TableColumn<listeetudiants, String> note_ds;
    @FXML
    private TableColumn<listeetudiants, String> note_exam;
    private Node barChart;

    /**
     * Initializes the controller class.
     */
    
    
     @FXML  
    public ObservableList<listeetudiants> show1()
    { 

           try {
               ObservableList<listeetudiants> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                 PreparedStatement pt= con.prepareStatement("SELECT note_cc,note_ds,note_exam,matiere.nom_mat,matiere.coef from note ,matiere where note.id_matiere=matiere.id_matiere ");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listeetudiants ls = new listeetudiants();

                 ls.setA(rs.getString("note_cc")); 
                 ls.setB(rs.getString("note_ds"));
                 ls.setC(rs.getString("note_exam"));
                 ls.setE(rs.getString("nom_mat"));
                 ls.setD(rs.getInt("coef"));
               
             

                  
                  System.out.println("");
         obl.add(ls);
                  }
                  return obl;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    } 
     public void affichelistenote() {
        
           
                         
      //ajouter les valeurs au tableview
      note_cc.setCellValueFactory(new PropertyValueFactory<>("A"));
      note_ds.setCellValueFactory(new PropertyValueFactory<>("B"));
      note_exam.setCellValueFactory(new PropertyValueFactory<>("C"));
      coef.setCellValueFactory(new PropertyValueFactory<>("D"));
      nom_mat.setCellValueFactory(new PropertyValueFactory<>("E"));
     
      ObservableList<listeetudiants> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
     obl=show1(); 
      tabnote.setItems(obl);
      System.out.println(""+obl);

                      
    }
     
      @FXML
    void pdf(ActionEvent event) {
 System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(primaryStage); 
            
    Node root = this.barChart;
           job.printPage(root);
           job.endJob();
    }}
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       affichelistenote();
    }    
    
}
