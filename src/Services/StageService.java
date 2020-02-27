/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Branche;
import Entities.Stage;
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

public class StageService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public StageService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     *
     * @param stage
     * @throws SQLException
     */
    //ajout de stage 
    public void ajouterStage(Stage stage) throws SQLException {

        String req1 = "INSERT INTO `stage` (`id_user`,`sujet`,`description`,`branche`) "
                + "VALUES ('" + stage.getId_user() + "', '" + stage.getSujet() + "', '" + stage.getDescription() + "' ,'" + stage.getBranche() + "');";
        ste.executeUpdate(req1);
        System.out.println("Stage ajouté");

    }

    //modification du stage 
    public void modifierStage(Stage s) throws SQLException {
        String sql = "UPDATE stage SET `id_user`=?,`sujet`=?,`description`=?,`branche`=? WHERE id_stage=" + s.getId_stage();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);

            ste.setInt(1, s.getId_user());

            ste.setString(2, s.getSujet());
            ste.setString(3, s.getDescription());

            ste.setString(4, s.getBranche().toString());

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification du stage :" + s.getSujet() + " a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //suppression de stage 
    public void supprimerStage(Stage s) {

        try {
            String req = "DELETE FROM `stage` WHERE `stage`.`id_stage` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, s.getId_stage());
            ste.executeUpdate();
            System.out.println("Stage supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //affichage de la liste des stages 
    public List<Stage> readAllS() throws SQLException {
        List<Stage> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("select * from stage");
        Stage com = null;
        while (res.next()) {
            com = new Stage(res.getInt(1), res.getInt(2), res.getString(3),
                    res.getString(4), Branche.valueOf(res.getString(5))
            );
            list.add(com);

        }
        System.out.println("Laa" + list + "");
        return list;
    }

    //tri par date de creation
    public List<Stage> TrierParDateCreation() throws SQLException {
        List<Stage> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from stage ORDER BY date_creation DESC");
        Stage com = null;
        while (res.next()) {
            com = new Stage(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4),
                    Branche.valueOf(res.getString(5)));
            list.add(com);

        }
        System.out.println(list);
        return list;
    }

    //tri par users
    public List<Stage> TrierParUsers() throws SQLException {
        List<Stage> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from stage ORDER BY id_user ASC");
        Stage com = null;
        while (res.next()) {
            com = new Stage(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4),
                    Branche.valueOf(res.getString(5)));
            list.add(com);

        }
        System.out.println(list);
        return list;
    }

    //find sujet par user
    public List<Stage> FindStageByUser(int id_user) throws SQLException {
        List<Stage> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from stage WHERE Id_User='" + id_user + "'");
        Stage com = null;
        while (res.next()) {
            com = new Stage(res.getInt(1), res.getInt(2), res.getString(3),
                    res.getString(4), Branche.valueOf(res.getString(5)));
            list1.add(com);

        }
        System.out.println(list1);
        return list1;
    }

    //find sujet par branche
    public List<Stage> FindStageByBranche(String branche) throws SQLException {
        List<Stage> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from stage WHERE branche='" + branche + "'");
        Stage com = null;
        while (res.next()) {
            com = new Stage(res.getInt(1), res.getInt(2), res.getString(3),
                    res.getString(4), Branche.valueOf(res.getString(5)));
            list1.add(com);

        }
        System.out.println(list1);
        return list1;
    }

    //find sujet par sujet
    public List<Stage> FindStageBySujet(String sujet) throws SQLException {
        List<Stage> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from stage WHERE sujet='" + sujet + "'");
        Stage com = null;
        while (res.next()) {
            com = new Stage(res.getInt(1), res.getInt(2), res.getString(3),
                    res.getString(4), Branche.valueOf(res.getString(5)));
            list1.add(com);

        }
        System.out.println(list1);
        return list1;
    }

}
