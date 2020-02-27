package Services;

import Controller.listeetudiantsO;
import Entities.Absence;
import Entities.User;

import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 */
public class ServiceAbsence {

    private Connection con;
    private Statement ste;

    public ServiceAbsence() {
        con = DataSource.getInstance().getConnection();

    }

    public void ajouter(Absence a) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `absence` (`id_user`,`absence`,`id_mat`,`id_classe`)  VALUES ( ?, ?,?,?);");
        pre.setInt(1, a.getId_user());
        pre.setInt(2, a.getAbsence());
        pre.setInt(3, a.getId_mat());
        pre.setInt(4, a.getId_classe());

        pre.executeUpdate();
        System.out.println("absence ajoutée !!");

    }

    public Boolean findiduserbyiduser(int iduser) throws SQLException {

        ste = con.createStatement();

        ResultSet rs = ste.executeQuery("select * from absence WHERE id_user=" + iduser + "");
        while (rs.next()) {

            int nn = rs.getInt("id_user");
            if (iduser == nn) {
                return true;

            }
        }

        return false;
    }

    public Absence findiduserbyiduserInterface(int iduser) throws SQLException {

        try {
            String requete = "SELECT * FROM absence WHERE id_user=?";
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setInt(1, iduser);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Absence u = new Absence();
                u.setAbsence(rs.getInt(1));
                u.setDateabs(rs.getString(2));
                u.setId_absence(rs.getInt(3));
                u.setId_mat(rs.getInt(4));

                return u;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Absence u = null;
        return u;
    }

    public int findidmatierebymatiere(String nom) throws SQLException {

        ste = con.createStatement();
        int nn = 0;
        ResultSet rs = ste.executeQuery("select id_mat from matiere WHERE nom_matiere='" + nom + "'");
        while (rs.next()) {
            nn = rs.getInt("id_mat");

        }

        return nn;
    }

    public int findidclassebynum(int num) throws SQLException {

        ste = con.createStatement();
        int nn = 0;
        ResultSet rs = ste.executeQuery("select id_classe from classe WHERE num_classe='" + num + "'");
        while (rs.next()) {
            nn = rs.getInt("id_classe");

        }

        return nn;
    }

    public String findiduserbyiduserInterfaceMail(int iduser) throws SQLException {

        try {
            String requete = "SELECT email FROM absence INNER JOIN user ON absence.id_user=? AND user.id_user=?";

            PreparedStatement pst = con.prepareStatement(requete);
            pst.setInt(1, iduser);
            pst.setInt(2, iduser);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setEmail(rs.getString(1));
                System.out.println(u.getEmail());

                return u.getEmail();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String u = "null";
        return u;
    }

    public Boolean findiduser(int id_user) throws SQLException {

        ste = con.createStatement();

        ResultSet rs = ste.executeQuery("select * from user WHERE id_user=" + id_user + "");
        while (rs.next()) {

            int nn = rs.getInt("id_user");
            if (id_user == nn) {
                return false;

            }
        }
        return true;
    }

    public void supprimer(int cin) throws SQLException {
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("Delete from absence where id_user = ? ");

            pst.setInt(1, cin);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void Modifier(listeetudiantsO pan) {
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("UPDATE absence SET absence=? WHERE id_user=?");

            pst.setString(1, pan.getC());
            pst.setInt(2, pan.getE());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* public void ajouter(Absence a) throws SQLException {
        
    PreparedStatement pre=con.prepareStatement("INSERT INTO `absence` (`iduser`,`id_seance`,`absence`,`dateabs`,`id_mat`)  VALUES ( ?, ?, ?, ?, ?);");
    pre.setInt(1, a.getId_user()); 
    pre.setInt(3, a.getAbsence());
   
   
   
    pre.executeUpdate();
        System.out.println("absence ajoutée !!");

    }*/
    public String listAbsences() {
        String mail = "";
        String requete = "SELECT * FROM absence";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()) {
                mail += "\n\n";
                Absence u = new Absence();
                u.setAbsence(rs.getInt(1));
                u.setDateabs(rs.getString(2));
                u.setId_absence(rs.getInt(3));
                u.setId_mat(rs.getInt(4));
                u.setId_user(rs.getInt(5));

                mail += "L'absence numero " + u.getAbsence() + " :";
                mail += "\n  Database = " + u.getDateabs();
                mail += "\n  ID Absence = " + u.getId_absence();
                mail += "\n  ID Matière = " + u.getId_mat();
                mail += "\n  ID User = " + u.getId_user();

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return mail;
    }

}
