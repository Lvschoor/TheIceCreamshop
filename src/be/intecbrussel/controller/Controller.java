package be.intecbrussel.controller;

import be.intecbrussel.sellers.Stock;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    private Stock stock;
    public void initializeController(Stock stock) {
        this.stock=stock;
        System.out.println("Cones in Controller: "+this.stock.getCones());

    }

    @FXML
    private Label label1;

    @FXML
    private Text text1;

    @FXML
    private Button button1;

    @FXML
    private Text cones;


    @FXML
    public void buttonClicked(Event e) {
        System.out.println("Button clicked");
        //cones.setText("Cones in stock: "+ Integer.toString(stock.getCones()));
        System.out.println(stock);
    }

}