/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Matiere;
import Entite.Note;
import Entite.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import Utils.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Note_Service {
    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
  

    public Note_Service() {
        try {
            ste = con.createStatement();
         
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void ajouterNote(Note n) throws SQLException {
        Date date1 = new Date();
        String Temps_note = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        n.setTemps_note(Temps_note);
        String req1 = "INSERT INTO `Note` ( `id_user`,`notes`,`temps_note`,`id_mat`,`id_classe`,`type`) "
                + "VALUES ('" + n.getId_user()+ "', '" + n.getNotes() + "','" + n.getTemps_note() + "','" + n.getId_mat() + "','" + n.getId_classe() + "','" + n.getType()+ "' );";
        ste.executeUpdate(req1);

       
        System.out.println("élement inseré");

    }
    
    public void modifierNote(Note n) {      
   String sql="UPDATE note SET `notes`=? WHERE id_note="+n.getId_note();
   PreparedStatement ste; 
        try {
            ste =con.prepareStatement(sql);
      
            ste.setInt(1, n.getNotes());
        
            ste.executeUpdate();
            int rowsUpdated=ste.executeUpdate();
            if (rowsUpdated>0){
            System.out.println("La modification de l'étudiant"+n.getId_user()+" a été éffectué avec succée ");
            }}
        catch (SQLException ex) {
            Logger.getLogger(Note_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerNote(Note n) {

        try {
            String req = "DELETE FROM `note` WHERE `note`.`id_note` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, n.getId_note());
            ste.executeUpdate();
            System.out.println("note supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(Note_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Note> consulterN() throws SQLException {
       List<Note> list = new ArrayList<>();
            ResultSet res = ste.executeQuery("select * from note");
            Note com = null;
            while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
          
            list.add(com);
          
            }
           System.out.println(""+list);
           
        return list;
    }  
    public List<Note> consulterNote() throws SQLException {
       List<Note> list = new ArrayList<>();
       
            ResultSet res = ste.executeQuery("select * from note n ,user u where n.id_user=u.id_user");
            Note com = null;
           
            while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
          
            list.add(com);
          
            }
           System.out.println(""+list);
           
        return list;
    }
    public List<Note> readAllSByClasse(int id_classe) throws SQLException {
        List<Note> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from note WHERE Id_Classe='" + id_classe + "'");
        Note com = null;
        while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
            list.add(com);
            System.out.println(list);
        }
        return list;
    }    
public List<Note> TrierParNote() throws SQLException {
        List<Note> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from Note ORDER BY notes DESC");
        Note com = null;
        while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
            list.add(com);
           
        }
         System.out.println(list);
        return list;
    }

public List<Note> TrierPardate_dajout() throws SQLException {
        List<Note> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from Note ORDER BY temps_note DESC");
        Note com = null;
        while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
            list.add(com);
           
        }
        System.out.println(list);
        return list;
    }

public List<Note> FindnameByUser(String first_Name) throws SQLException {
        List<Note> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select id_note,notes from note n,user u WHERE n.id_user=u.id_user and first_Name='" + first_Name + "' ");
        Note com = null;
        while (res.next()) {
            com = new Note(res.getInt(1),res.getInt(2));
            list1.add(com);     
        }
        System.out.println(list1);
        return list1;
    }

    public List<Note> FindlistByclasse(int id_classe) throws SQLException {
        List<Note> list2 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from note WHERE Id_Classe='" + id_classe + "'");
        Note com = null;
        while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
            list2.add(com);
            System.out.println(list2);
        }
        return list2;
    }
    
    
    
public List<Note> getnotebymatiére(String nom_mat) throws SQLException {
        List<Note> list2 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from note n,matiere m WHERE n.id_mat=m.id_mat and nom_mat='" + nom_mat + "'");
        Note com = null;
        while (res.next()) {
            com = new Note(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), Type.valueOf(res.getString(7)));
            list2.add(com);
            System.out.println(list2);
        }
        return list2;
    }

    
public  List<Matiere> getmatiérebyid() throws SQLException {
        List<Matiere> list3 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select nom_mat from matiere");
        Matiere com = null;
        while (res.next()) {
            com = new Matiere(res.getString("nom_mat"));
            list3.add(com);
            System.out.println(list3);
        }
        return list3;
       
   
    }


    
}