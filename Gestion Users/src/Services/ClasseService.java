/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Administrateur;
import Entities.Classe;
import Entities.User;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ClasseService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;
    private UserService userService = new UserService();

    public ClasseService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterClasse(Classe classe) throws SQLException {

        String req1 = "INSERT INTO `classe` (`num_classe`,`niveau`,`capacité`)"
                + "VALUES ('" + classe.getNum_classe() + "', '" + classe.getNiveau() + "', '" + classe.getCapacité() + "');";
        ste.executeUpdate(req1);
        System.out.println("Classe ajoutée");
    }

    public void modifierClasse(Classe c) throws SQLException {
        String sql = "UPDATE classe SET `num_classe`=?,`niveau`=?,`capacité`=? WHERE id_classe=" + c.getId_classe();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);

            ste.setInt(1, c.getNum_classe());

            ste.setInt(2, c.getNiveau());
            ste.setInt(3, c.getCapacité());

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de la classe :" + c.getNiveau() + "ème" + c.getNum_classe() + " a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClasseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerClasse(Classe c) {

        try {
            String req = "DELETE FROM `classe` WHERE `classe`.`id_classe` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, c.getId_classe());
            ste.executeUpdate();
            System.out.println("La classe est supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(ClasseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Classe> readAll() throws SQLException {
        List<Classe> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from classe ");
        Classe c = null;
        while (res.next()) {
            c = new Classe(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4));
            list.add(c);
            System.out.println("all" + list);
        }
        return list;

    }

    public int FindNumClasseByIdClasse(int id_classe) throws SQLException {
        String req = "SELECT * from classe where Id_classe='" + id_classe + "'";
        ResultSet res = ste.executeQuery(req);

        int num = 0;
        while (res.next()) {

            num = res.getInt(2);
            System.out.println(num);
        }
        return num;
    }

    public String FindClasseByIdUser(int id_user) throws SQLException {
        String classe = null;

        String req = "SELECT classe from user where id_user='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        while (res.next()) {
            classe = res.getString("classe");

        }

        return classe;
    }

}
