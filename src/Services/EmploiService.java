/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Classe;
import Entities.Enseignant;
import Entities.Seance;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KattaX
 */
public class EmploiService {

    private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public EmploiService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajoutSeance(Seance seance) {

    }

    public void getSeancesParEnseignant(Enseignant enseignant) {
    }

    public void getSeancesParClasse(Classe classe) {
    }

}
