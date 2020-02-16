/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Categorie;
import Entite.Sujet;
import Entite.User;
import Utils.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell is hell
 */
public class SujetService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public SujetService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterSujet(Sujet s) throws SQLException {
        Date date1 = new Date();
        String Temps_Sujet = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        s.setTemps_Sujet(Temps_Sujet);
        String req1 = "INSERT INTO `sujet` (`Id_User`, `Titre_Sujet`,`Contenu_Sujet`,`Temps_Sujet`,`Categorie`,`nbre_vues`,`nbre_jaime`) "
                + "VALUES ('" + s.getId_User() + "', '" + s.getTitre_Sujet() + "', '" + s.getContenu_Sujet()
                + "', '" + s.getTemps_Sujet() + "', '"
                + s.getCategorie() + "', '" + s.getNbre_vues() + "', '" + s.getNbre_jaime() + "');";
        ste.executeUpdate(req1);
        System.out.println("elment inseré");

    }

    public void modifierSujet(Sujet s) {

        String sql = "UPDATE sujet SET `Id_User`=?,`Titre_Sujet`=?,`Contenu_Sujet`=?,`Temps_Sujet`=?,`Categorie`=? WHERE Id_Sujet=" + s.getId_Sujet();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);
            ste.setInt(1, s.getId_User());
            ste.setString(2, s.getTitre_Sujet());

            ste.setString(3, s.getContenu_Sujet());
            ste.setString(4, s.getTemps_Sujet());
            ste.setString(5, s.getCategorie().toString());

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de sujet" + s.getId_Sujet() + " a été éffectué avec succée ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SujetService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerSujet(Sujet s) {

        try {
            String req = "DELETE FROM `sujet` WHERE `sujet`.`Id_Sujet` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, s.getId_Sujet());
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(SujetService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public boolean rechercherparNom(String nom) {
        boolean test = false;
        String req = "SELECT * from sujet where Titre_Sujet='" + nom + "'";

        try {

            ResultSet stp = ste.executeQuery(req);
            stp.last();
            if (stp.getRow() != 0) {
                test = true;
                System.out.println(test + "\nsujet trouver");
            } else {
                test = false;
                System.out.println(test + "\nsujet non trouver");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SujetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
    public List<Sujet> readAllSByCategorie(Categorie caString) throws SQLException {
        List<Sujet> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from sujet WHERE Categorie='" + caString.name() + "'");
        Sujet com = null;
        while (res.next()) {
            com = new Sujet(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5),res.getInt(6),res.getInt(7), Categorie.valueOf(res.getString(8)));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }

    public Vector<Sujet> readAllS() throws SQLException {
        Vector<Sujet> vector = new Vector<>();
        
       
            
            ResultSet res = ste.executeQuery("select * from sujet");
            Sujet com = null;
            while (res.next()) {
            com = new Sujet(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4),res.getString(5),res.getInt(6),res.getInt(7), Categorie.valueOf(res.getString(8)));
            vector.add(com);
            
            
            }
            System.out.println("tous les sujets:\n"+vector);
         
        return vector;
    }
    

    public void supprimerSujet(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public List<Sujet> FindSujetByIdUser(int id_user) throws SQLException {
        List<Sujet> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from sujet WHERE Id_User='" + id_user + "'");
        Sujet com = null;
        while (res.next()) {
            com = new Sujet(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5),res.getInt(6),res.getInt(7),
                    Categorie.valueOf(res.getString(8)));
            list1.add(com);
            
        }
        System.out.println(list1);
        return list1;
    }

    
    public List<Sujet> TrierParNbreVue() throws SQLException {
        List<Sujet> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from sujet ORDER BY nbre_vues DESC");
        Sujet com = null;
        while (res.next()) {
            com = new Sujet(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5),res.getInt(6),res.getInt(7), Categorie.valueOf(res.getString(8)));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }
    public List<Sujet> TrierParDateCreation() throws SQLException {
        List<Sujet> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from sujet ORDER BY Temps_Sujet DESC");
        Sujet com = null;
        while (res.next()) {
            com = new Sujet(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5),res.getInt(6),res.getInt(7), Categorie.valueOf(res.getString(8)));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }
    
    public void compterNbreVue(Sujet s) {
        try {
            PreparedStatement ste = con.prepareStatement("update sujet set nbre_vues=nbre_vues+1 WHERE Id_Sujet=" + s.getId_Sujet());
            

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SujetService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String FindNomUserByIdUser_Sujet(int id_user) throws SQLException {
        String req = "SELECT * from user where Id_User='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
        while (res.next()) {

            nom = res.getString(5);
        }
        return nom;
    }
   public void compterjaime(Sujet s) {
        try {
            PreparedStatement ste = con.prepareStatement("update sujet set nbre_jaime=nbre_jaime+1 WHERE Id_Sujet=" + s.getId_Sujet());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SujetService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void compterjaimepas(Sujet s) {
        try {
            PreparedStatement ste = con.prepareStatement("update sujet set nbre_jaime=nbre_jaime-1 WHERE Id_Sujet=" + s.getId_Sujet());
           
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SujetService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int FindNombreJaimeById_Sujet(int id_sujet) throws SQLException{
    String req = "SELECT * from sujet where Id_Sujet='" + id_sujet + "'";
    ResultSet res = ste.executeQuery(req);
         User com = null;
          int nbre = 0;
        while (res.next()) {
          
           nbre = res.getInt(7);
        }
        return nbre;
}

}
