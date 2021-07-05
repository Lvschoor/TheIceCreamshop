package be.intecbrussel.controller;

import be.intecbrussel.application.IceCreamAppFX;
import be.intecbrussel.sellers.Stock;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Stock stock;

    public Controller(Stock stock){
        this.stock=stock;
    }

    @FXML
    private Label label1;

    @FXML
    private Text text1;

    @FXML
    private Button button1;

    @FXML
    private Text cones;


    // when button is clicked, show stock
    @FXML
    public void buttonClicked(Event e) {
        System.out.println("Button clicked");
        cones.setText("Cones in stock: "+ Integer.toString(stock.getCones()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cones.setText("");
    }
}