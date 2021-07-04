package be.intecbrussel.controller;

import be.intecbrussel.application.IceCreamAppFX;
import be.intecbrussel.sellers.Stock;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class Controller {
    private Stock stock;

    // importing the data from stock to private variable stock
    public void initializeController(Stock stock) {
        this.stock = stock;
        //testing the import
        System.out.println("Cones in Controller: " + this.stock.getCones());
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
    //TODO: make this work
    @FXML
    public void buttonClicked(Event e) {
        System.out.println("Button clicked");
        //cones.setText("Cones in stock: "+ Integer.toString(stock.getCones()));
        System.out.println(stock);
    }
}