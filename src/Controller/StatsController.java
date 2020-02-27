/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.ReclamationService;
import Utils.EtatReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author KattaX
 */
public class StatsController implements Initializable {

    ReclamationService reclamationService;

    public StatsController() {
        reclamationService = new ReclamationService();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        try {
            pieChartData.add(new PieChart.Data("Notes", reclamationService.nbReclamationNotesTotal()));
            pieChartData.add(new PieChart.Data("Enseignants", reclamationService.nbReclamationProfTotal()));
            pieChartData.add(new PieChart.Data("Autres", reclamationService.nbReclamationTotal()));
        } catch (SQLException ex) {
            Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        pieChart.setData(pieChartData);

        ObservableList<PieChart.Data> pieChartDataEtats = FXCollections.observableArrayList();

        for (EtatReclamation etatReclamation : EtatReclamation.values()) {
            try {
                pieChartDataEtats.add(new PieChart.Data(etatReclamation.name(),
                        reclamationService.nbReclamationParType(etatReclamation)));
            } catch (SQLException ex) {
                Logger.getLogger(StatsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pieChartEtat.setData(pieChartDataEtats);
    }

    @FXML
    private PieChart pieChart;

    @FXML
    private PieChart pieChartEtat;

}
