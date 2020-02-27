/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Administrateur;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AdminService {
    
     private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    Administrateur e =new Administrateur();

    public AdminService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    
    
    public void ajouterAdmin(Administrateur a) throws SQLException {
        Date date1 = new Date();
        String account_Date = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        a.setAccount_Date(account_Date);
        String req1 = "INSERT INTO `admin` (`login`,`password` , `account_Date` ) "
                + "VALUES ('" + a.getLogin() + "', '" + a.getPassword() + "' ,'" +a.getAccount_Date()+ "');";
        ste.executeUpdate(req1);
        System.out.println("Administrateur ajouté");
    }
      

    public void modifierAdmin(Administrateur a) throws SQLException {
        String sql = "UPDATE admin SET `login`=?,`password`=? , `account_Date`=? WHERE id_admin=" + a.getId_admin();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);

            ste.setString(1, a.getLogin());

            ste.setString(2, a.getPassword());
            
            ste.setString(3, a.getAccount_Date());

            
            
            
            
            
       
            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de l'administrateur : " + a.getLogin() + " a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerAdmin(Administrateur a) {

        try {
            String req = "DELETE FROM `admin` WHERE `admin`.`id_admin` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, a.getId_admin());
            ste.executeUpdate();
            System.out.println("Administrateur supprimé");
            

        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public List<Administrateur> readAll() throws SQLException
    {
    List<Administrateur> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from admin ");
    Administrateur a =null;
    while (res.next()) {            
      a=new Administrateur(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
      list.add(a);
      System.out.println("all"+list);
        }
    return list;
}
     
     public String FindLoginByIdAdmin(int id_admin) throws SQLException{
    String req = "SELECT * from admin where Id_admin='" + id_admin + "'";
    ResultSet res = ste.executeQuery(req);
         Administrateur com = null;
          String login = null;
        while (res.next()) {
          
           login = res.getString(2);
           System.out.println(login);
        }
        return login;
}
     public Boolean FindLoginByLogin(String Login) throws SQLException{
    String req = "SELECT * from admin where login='" + Login + "'";
    ResultSet res = ste.executeQuery(req);
         Administrateur com = null;
          String login = null;
        while (res.next()) {
            login = res.getString(2);
           if (Login.equals(login) ) {
               return true;
               
           }
           
           System.out.println(login);
        }
        return false;
}
      public List<Administrateur> TrierParDateCreation() throws SQLException {
        List<Administrateur> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from admin ORDER BY account_Date DESC");
        Administrateur com = null;
        while (res.next()) {
            com = new Administrateur(res.getInt(1),res.getString(2), res.getString(3),res.getString(4));
            list.add(com);
            System.out.println(list);
        }
        return list;
    }
}

