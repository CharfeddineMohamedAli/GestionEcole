/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Jaime;
import Entite.Sujet;
import Entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataSource;

/**
 *
 * @author hp
 */
public class JaimeService {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    public JaimeService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public void ajouterJaime(Jaime j) throws SQLException {
   
  
        String req1 = "INSERT INTO `jaime` (`Id_User`, `Id_Sujet`,`valeur_jaime`) "
                + "VALUES ('" + j.getId_user() + "', '" + j.getId_Sujet()+ "', '" + j.getValeur_jaime()+ "');"; 
               
        ste.executeUpdate(req1);
        System.out.println("elment inseré");

    }
     
    public int FindValeurJaimeByIdUserAndIdSujet(int id_user,int id_sujet) throws SQLException{
    String req = "SELECT * from jaime WHERE Id_User='" + id_user +"'AND Id_Sujet='"+id_sujet+ "'";
    ResultSet res = ste.executeQuery(req);
        Jaime jaime=null;
        int valeurJaime = 0;
        while (res.next()) {
          
           valeurJaime = res.getInt(3);
           System.out.println(valeurJaime);
           
        }
        return valeurJaime;
}
       public void incrementerjaime(int id_user,int id_sujet) {
        try {
            PreparedStatement ste = con.prepareStatement("update jaime set valeur_jaime=valeur_jaime+1  WHERE Id_User='" +id_user +"'AND Id_Sujet='"+id_sujet+ "'");
            ste.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(JaimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void decrementerjaime(int id_user,int id_sujet) {
        try {
            PreparedStatement ste = con.prepareStatement("update jaime set valeur_jaime=valeur_jaime-1  WHERE Id_User='" +id_user +"'AND Id_Sujet='"+id_sujet+ "'");
            

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JaimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
