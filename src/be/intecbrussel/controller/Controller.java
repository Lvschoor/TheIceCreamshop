package be.intecbrussel.controller;

import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends VBox implements Initializable{

    @FXML
    private Stock stock;
    private PriceList pricelist;
    private IceCreamSeller iceCreamCar;

    public Controller(IceCreamSeller iceCreamCar, Stock stock, PriceList pricelist) {
        this.iceCreamCar = iceCreamCar;
        this.stock = stock;
        this.pricelist = pricelist;
    }

    @FXML
    private Label label1;

    @FXML
    private SplitPane infoFields;

    @FXML
    private Text text1;
    @FXML
    private Text text2;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Text cones;

    @FXML
    private Text cones2;

    @FXML
    private Text balls;

    @FXML
    private Text iceRockets;

    @FXML
    private Text magni;

    @FXML
    private Text balls2;

    @FXML
    private Text iceRockets2;

    @FXML
    private Text magni2;

    // when button is clicked, show stock
    @FXML
    public void button1Clicked(Event e) {
        System.out.println("Button 1 clicked");
        button1.setText("Refresh stock status");
        text1.setVisible(true);
        infoFields.setVisible(true);
        cones.setText("Cones: " + Integer.toString(stock.getCones()));
        balls.setText("Ice cream balls: " + Integer.toString(stock.getBalls()));
        iceRockets.setText("Ice Rockets: " + Integer.toString(stock.getIceRockets()));
        magni.setText("Magnums: " + Integer.toString(stock.getMagni()));
    }

    @FXML
    public void button2Clicked(Event e2) {
        System.out.println("Button 2 clicked");
        infoFields.setVisible(true);
        text2.setVisible(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}