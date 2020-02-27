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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author nada kd
 */
public class Affichage_note_ens_controller implements Initializable {

    private Connection con = DataSource.getInstance().getConnection();

    @FXML
    private TableView<listeetudiants> table;
    @FXML
    private TableColumn<listeetudiants, String> nom_etud;
    @FXML
    private TableColumn<listeetudiants, String> prenom_etud;
    @FXML
    private TableColumn<listeetudiants, Integer> cin;
    @FXML
    private TableColumn<listeetudiants, String> mat1;
    @FXML
    private TableColumn<listeetudiants, String> cc;
    @FXML
    private TableColumn<listeetudiants, String> ds;
    @FXML
    private TableColumn<listeetudiants, String> exam;
    @FXML
    private Button retour;
     @FXML
    private CheckBox tri;
       @FXML
    private TextField search1;

 
@FXML  
    public ObservableList<listeetudiants> show2(int id_classe,int id_matiere)
    { 

           try {
               ObservableList<listeetudiants> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                 PreparedStatement pt= con.prepareStatement("SELECT note_cc,note_ds,note_exam,user.id_user,first_Name,last_Name from note ,user  where note.id_user=user.id_user AND note.id_classe= '"+id_classe+"'=user.id_classe AND id_matiere= '"+id_matiere+"'");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listeetudiants ls = new listeetudiants();

                 ls.setA(rs.getString("note_cc")); 
                 ls.setB(rs.getString("note_ds"));
                 ls.setC(rs.getString("note_exam"));
                 ls.setD(rs.getInt("id_user"));
             
                 ls.setF(rs.getString("first_Name"));
                 ls.setG(rs.getString("last_Name"));
             
                 
         obl.add(ls);
                  }
                  return obl;
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
              }
           return null;
    } 

    
   
    @FXML  
    public ObservableList<listeetudiants> show1(int id_classe,int id_matiere)
    { 

           try {
               ObservableList<listeetudiants> obl =FXCollections.observableArrayList();
                  //exécution de la réquette et enregistrer le resultat dans le resultset
                  
                 PreparedStatement pt= con.prepareStatement("SELECT note_cc,note_ds,note_exam,user.id_user,first_Name,last_Name from note ,user  where note.id_user=user.id_user AND note.id_classe= '"+id_classe+"'=user.id_classe AND id_matiere= '"+id_matiere+"'");
                  ResultSet rs = pt.executeQuery();
                  while(rs.next()){
                  //obl.add(new Note(rs.getFloat(1),rs.getFloat(2),rs.getFloat(3),rs.getInt(4),rs.getString(5)));
                 listeetudiants ls = new listeetudiants();

                 ls.setA(rs.getString("note_cc")); 
                 ls.setB(rs.getString("note_ds"));
                 ls.setC(rs.getString("note_exam"));
                 ls.setD(rs.getInt("id_user"));
               
                 ls.setF(rs.getString("first_Name"));
                 ls.setG(rs.getString("last_Name"));
             

                  
           
         obl.add(ls);
          
                  }
                  return obl;
                 
                  
              } catch (SQLException ex) {
                System.out.println("Erreur"+ex);
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
      ObservableList<listeetudiants> obl =FXCollections.observableArrayList();
int n=RechercheController.getNote_transport().getId_matiere();
        int nn= RechercheController.getNote_transport().getId_classe();
     // tableview.setItems(null);
     obl=show2(nn,n); 
      table.setItems(obl);
      System.out.println(""+obl);

                      
    }
   

   
   
       public void affichelistenote() {
        
          
       int n=RechercheController.getNote_transport().getId_matiere();
        int nn= RechercheController.getNote_transport().getId_classe();
                         
      //ajouter les valeurs au tableview
      cc.setCellValueFactory(new PropertyValueFactory<>("A"));
      ds.setCellValueFactory(new PropertyValueFactory<>("B"));
      exam.setCellValueFactory(new PropertyValueFactory<>("C"));
      cin.setCellValueFactory(new PropertyValueFactory<>("D"));
 
      nom_etud.setCellValueFactory(new PropertyValueFactory<>("F"));
      prenom_etud.setCellValueFactory(new PropertyValueFactory<>("G"));
      ObservableList<listeetudiants> obl =FXCollections.observableArrayList();

     // tableview.setItems(null);
     obl=show1(nn,n); 
      table.setItems(obl);
      System.out.println(""+obl);

                      
    }
    
     @FXML
    void Triparnom(ActionEvent event) {
        if(tri.isSelected()) {
             affichelistenoteOrderByFirstName();
         }
        else{
            affichelistenote();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichelistenote();
    }    

    
    @FXML
    private void retour1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/recherche.fxml"));
        try {
            Parent root =loader.load();
             RechercheController dcp = loader.getController();
             retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(RechercheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int n=RechercheController.getNote_transport().getId_matiere();
        int nn= RechercheController.getNote_transport().getId_classe();
    listeetudiants ls = new listeetudiants();
    FilteredList filt =new FilteredList(show1(nn,n),e->true);
    
    
     @FXML
    private void searchcin(javafx.scene.input.KeyEvent event) {
        search1.textProperty().addListener((Observable, oldValue, newValue) -> {
            filt.setPredicate((Predicate<? super listeetudiants>) (listeetudiants listeetudiants) -> {
                String lowerCaseFilter =newValue.toLowerCase();
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                 else if (listeetudiants.getF().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                  
                    return true;
                }

                return false;
            });

        });
        SortedList sort = new SortedList(filt);
        sort.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sort);
    
    
    
    }
    
}
