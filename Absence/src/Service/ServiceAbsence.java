/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.Absence;
import Utils.DataSource;
import static java.lang.Double.sum;
import static java.lang.Float.sum;
import static java.lang.Integer.sum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HPAY104-I5-1TR
 */
public class ServiceAbsence {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ServiceAbsence () {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
 public void ajouterAbsence(Absence a) throws SQLException {
        Date date1 = new Date();
        String Dateabs = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        
        a.setDateabs(Dateabs);
        String req1 = "INSERT INTO `absence` (`iduser`,`absence`,`id_seance`,`dateabs`) "
                + "VALUES ('" + a.getId_user() + "', '" + a.isAbsence() + "', '" + a.getId_seance()+ "', '" + a.getDateabs()+ "');";
        ste.executeUpdate(req1);
        System.out.println("elment inseré");

    }
        public void modifierAbsence (Absence a) {

       String sql = "UPDATE absence SET `iduser`=?,`absence`=?,`dateabs`=?,`id_seance`=? WHERE idabsence=" + a.getId_absence();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);
            ste.setInt(1, a.getId_user());
            ste.setInt(2, a.isAbsence());
            

            ste.setString(3, a.getDateabs()); 
            ste.setInt(4, a.getId_seance());
       

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification d'absence a été éffectué avec succée ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void supprimerAbsence(Absence a) {

        try {
            String req = "DELETE FROM `absence` WHERE `absence`.`idabsence` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, a.getId_absence());
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAbsence.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public List<Absence> TrierParDateAbsence() throws SQLException {
        List<Absence> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from absence ORDER BY dateabs DESC");
        Absence com = null;
        while (res.next()) {
            com = new Absence(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getString(5));
            list.add(com);
        }
        return list;
    }
 
  
     public List<Absence> readAllS() throws SQLException {
        List<Absence> list = new ArrayList<>();
        
       
            
            ResultSet res = ste.executeQuery("select * from absence");
            Absence com = null;
            while (res.next()) {
            com = new Absence(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getString(5));            com = new Absence(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getString(5));

            list.add(com);
           
            }
            System.out.println("Laa"+list);
         
        return list;
    }

     public List<Absence> FindAbsenceByIdUser(int id_user) throws SQLException {
        List<Absence> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from absence WHERE iduser=" + id_user + ";");
        Absence com = null;
        while (res.next()) {
             com = new Absence(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getString(5)); 
          list1.add(com);
            System.out.println(list1);
            System.out.println("user est");
        }
        return list1;
    }
     public void nbrAbsence() throws SQLException {
        int sum=0;
        List<Absence> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("SELECT COUNT(absence) FROM absence GROUP BY absence HAVING COUNT(absence) =6; ");
        Absence com = null;
       
        
        
        System.out.println(res.getRow());
        
       
        
    } 
     public List<Absence> getabsenceByIdmatiere(int id_mat) throws SQLException {
        List<Absence> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from absence WHERE id_mat = " + id_mat + ";");
        Absence com = null;
        while (res.next()) {
            com = new Absence(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getString(5), res.getInt(6)); 
            list1.add(com);
            System.out.println(list1);
            System.out.println("getabsenceByIdmatiere");

        }
        return list1;
        

    }

}
