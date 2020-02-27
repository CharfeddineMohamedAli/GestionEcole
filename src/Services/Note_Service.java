package Services;

import Controller.listeetudiants;
import Entities.Note;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 */
public class Note_Service {

    private Connection con;
    private Statement ste;

    public Note_Service() {
        con = DataSource.getInstance().getConnection();

    }

    public void ajouter(Note p) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `note` ( `note_cc`, `note_ds`, `note_exam`, `moyenne`, `net`, `id_user`, `id_matiere`, `id_classe`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);");
        pre.setFloat(1, p.getNote_cc());
        pre.setFloat(2, p.getNote_ds());
        pre.setFloat(3, p.getNote_exam());
        pre.setFloat(4, p.getMoyenne());
        pre.setFloat(5, p.getNet());
        pre.setInt(6, p.getId_user());

        pre.setInt(7, p.getId_matiere());
        pre.setInt(8, p.getId_classe());

        pre.executeUpdate();
        System.out.println("Note ajoutée !!");

    }

    public void ajouterall(Note p) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `note` ( `note_cc`, `note_ds`, `note_exam`,  `id_user`, `id_matiere`, `id_classe`) VALUES ( ?, ?, ?, ?, ?, ?);");
        pre.setFloat(1, p.getNote_cc());
        pre.setFloat(2, p.getNote_ds());
        pre.setFloat(3, p.getNote_exam());

        pre.setInt(4, p.getId_user());

        pre.setInt(5, p.getId_matiere());
        pre.setInt(6, p.getId_classe());

        pre.executeUpdate();
        System.out.println("Note ajoutée !!");

    }

    public void ajouter1(Note p) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `note` ( `note_cc`,`id_user`,`id_matiere`,`id_classe`) VALUES ( ?,?,?,?);");

        pre.setFloat(1, p.getNote_cc());

        pre.setInt(2, p.getId_user());
        pre.setInt(3, p.getId_matiere());
        pre.setInt(4, p.getId_classe());

        pre.executeUpdate();
        System.out.println("Note ajoutée !!");

    }

    public void ajouter2(Note p) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `note` ( `note_ds`,`id_user`,`id_matiere`,`id_classe`) VALUES ( ?,?,?,?);");

        pre.setFloat(1, p.getNote_ds());

        pre.setInt(2, p.getId_user());
        pre.setInt(3, p.getId_matiere());
        pre.setInt(4, p.getId_classe());

        pre.executeUpdate();
        System.out.println("Note ajoutée !!");

    }

    public void ajouter3(Note p) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `note` ( `note_exam`,`id_user`,`id_matiere`,`id_classe`) VALUES ( ?,?,?,?);");

        pre.setFloat(1, p.getNote_exam());

        pre.setInt(2, p.getId_user());
        pre.setInt(3, p.getId_matiere());
        pre.setInt(4, p.getId_classe());

        pre.executeUpdate();
        System.out.println("Note ajoutée !!");

    }

    public void ajouter4(Note p) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `note` ( `note_cc`,`note_ds`,`id_user`,`id_matiere`,`id_classe`) VALUES ( ?,?,?,?,?);");

        pre.setFloat(1, p.getNote_cc());
        pre.setFloat(2, p.getNote_ds());
        pre.setInt(3, p.getId_user());
        pre.setInt(4, p.getId_matiere());
        pre.setInt(5, p.getId_classe());

        pre.executeUpdate();
        System.out.println("Note ajoutée !!");

    }

    public boolean delete(int id) throws SQLException {

        try {
            ste = con.createStatement();
            String requesteDelete = " DELETE FROM note where id_note ='" + id + "'";
            ste.executeUpdate(requesteDelete);
            System.out.println("Note supprimer");
        } catch (Exception ex) {
            System.err.println("ex");

        }

        return true;
    }

    public void supprimer(int cin) throws SQLException {
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("Delete from note where id_user = ? ");

            pst.setInt(1, cin);
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean update(Note p) throws SQLException {

        String sql = "UPDATE note SET note_cc=?, note_ds=?, note_examun=?,nom_matier=?  WHERE id_note=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setFloat(1, p.getNote_cc());
        statement.setFloat(2, p.getNote_ds());
        statement.setFloat(3, p.getNote_exam());
        statement.setFloat(4, p.getMoyenne());
        statement.setFloat(5, p.getNet());
        statement.setInt(6, p.getId_user());
        statement.setInt(7, p.getId_matiere());
        statement.setInt(8, p.getId_note());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Modification terminé!");
        }
        return true;
    }

    public List readAll() throws SQLException {
        List<Note> arr = new ArrayList<>();
        ste = con.createStatement();

        ResultSet rs = ste.executeQuery("select * from note");
        while (rs.next()) {
            int id_note = rs.getInt(1);
            float note_cc = rs.getFloat("note_cc");
            float note_ds = rs.getFloat("note_ds");
            float note_examun = rs.getFloat(4);
            float moyenne = rs.getFloat("moyenne");
            float net = rs.getFloat("net");
            int id_user = rs.getInt("id_user");
            int id_matiere = rs.getInt(8);
            Note p = new Note(id_note, note_cc, note_ds, note_examun, moyenne, net, id_user, id_matiere);
            arr.add(p);
        }
        return arr;
    }

    public Boolean findiduserbyiduser(int id_user) throws SQLException {

        ste = con.createStatement();

        ResultSet rs = ste.executeQuery("select * from note WHERE id_user=" + id_user + "");
        while (rs.next()) {

            int nn = rs.getInt("id_user");
            if (id_user == nn) {
                return false;

            }
        }
        return true;
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

    public int findidmatierebymatiere(String nom) throws SQLException {

        ste = con.createStatement();
        int nn = 0;
        ResultSet rs = ste.executeQuery("select id_matiere from matiere WHERE nom_mat='" + nom + "'");
        while (rs.next()) {
            nn = rs.getInt("id_matiere");

        }

        return nn;
    }

    public int findidclassebynum(int nom) throws SQLException {

        ste = con.createStatement();
        int nn = 0;
        ResultSet rs = ste.executeQuery("select id_classe from classe WHERE num_classe='" + nom + "'");
        while (rs.next()) {
            nn = rs.getInt("id_classe");

        }

        return nn;
    }

    public void Modifier(listeetudiants pan) {
        try {
            PreparedStatement pst;
            pst = con.prepareStatement("UPDATE note SET note_cc=?, note_ds=?, note_exam=?  WHERE id_user=?");

            pst.setString(1, pan.getA());
            pst.setString(2, pan.getB());
            pst.setString(3, pan.getC());
            pst.setInt(4, pan.getD());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
