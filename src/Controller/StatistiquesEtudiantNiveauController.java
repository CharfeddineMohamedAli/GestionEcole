/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class StatistiquesEtudiantNiveauController implements Initializable {
@FXML
    private BarChart<String,Integer> barChart;

    /**
     * Initializes the controller class.
     */
private Connection con = DataSource.getInstance().getConnection();
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
         String req =" SELECT level,age  from user ";
        XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();
        try {
             PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));
            }
            barChart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(StatistiquesEtudiantNiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
