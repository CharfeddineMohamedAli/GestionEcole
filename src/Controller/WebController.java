package Controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;

public class WebController implements Initializable {

    String htLink = "http://";
    @FXML
private AnchorPane Webpane;
    

    String adrsLink;

    @FXML
    WebView web;

    WebEngine engine;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(htLink+"esprit.tn");
    }
}