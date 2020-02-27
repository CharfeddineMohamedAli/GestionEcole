package Services;

import Entities.ListeStage;
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

public class ListeStageService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public ListeStageService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     *
     * @param listestage
     * @throws SQLException
     */
    //ajout de stage 
    public void ajouterlisteStage(ListeStage ls) throws SQLException {

        String req1 = "INSERT INTO `listestage` (`sujet`,`description`,`branche`,`LettreMotivation`,`CV`,`adresse`) "
                + "VALUES ('" + ls.getSujet() + "', '" + ls.getDescription() + "', '" + ls.getBranche() + "' ,'" + ls.getLettreMotivation() + "','" + ls.getCV() + "','" + ls.getAdresse() + "');";
        ste.executeUpdate(req1);
        System.out.println("Demande ajouté");

    }

    //affichage de la liste des stages 
    public List<ListeStage> readAllS() throws SQLException {
        List<ListeStage> list = new ArrayList<>();

        ResultSet res = ste.executeQuery("select * from listestage");
        ListeStage com = null;
        while (res.next()) {
            com = new ListeStage(res.getInt(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7));

            list.add(com);

        }
        System.out.println("Laa" + list + "");
        return list;
    }

    public void supprimerListeStage(ListeStage ls) {

        try {
            String req = "DELETE FROM `listestage` WHERE `listestage`.`id_listestage` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, ls.getId_listeStage());
            ste.executeUpdate();
            System.out.println("Demande supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(StageService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
