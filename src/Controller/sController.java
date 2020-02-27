/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import Utils.*;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author omaima
 */
public class sController implements Initializable {

    private Connection con = DataSource.getInstance().getConnection();

    private SujetService serv = new SujetService();
    @FXML
    private Button pdf;

    @FXML
    private BarChart<String, Integer> barChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String req = " SELECT Titre_Sujet,nbre_vues from sujet ";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        try {
            PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
            }
            barChart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(sController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // TODO
    }

    @FXML
    void pdf(ActionEvent event) {
        System.out.println("To Printer!");
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            Window primaryStage = null;
            job.showPrintDialog(primaryStage);

            Node root = this.barChart;
            job.printPage(root);
            job.endJob();

        }

    }
}
