package be.intecbrussel.application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    public Label label1 = null;
    @FXML
    public void buttonClicked(Event e){
        System.out.println("Button clicked");
    }

}
