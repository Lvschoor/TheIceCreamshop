package be.intecbrussel.controller;

import be.intecbrussel.application.IceCreamAppFX;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {

    IceCreamAppFX iceCreamAppFX = new IceCreamAppFX();

    @FXML
    private Text cones;

    @FXML
    public void buttonClicked(Event e){
        System.out.println("Button clicked");
        cones.setText("Cones in stock: "+ Integer.toString(iceCreamAppFX.stock.getCones()));


    }

}