package be.intecbrussel.application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text cones;

    @FXML
    public void buttonClicked(Event e){
        System.out.println("Button clicked");
        cones.setText("Cones in stock: "+ Integer.toString(5));

    }

}
