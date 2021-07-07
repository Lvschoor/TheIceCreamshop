package be.intecbrussel.controller;

import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;

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
    private Button button3;

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

    @FXML
    private TextField conesUpdate;

    @FXML
    private TextField ballsUpdate;

    @FXML
    private TextField iceRocketsUpdate;

    @FXML
    private TextField magniUpdate;

    @FXML
    private TextFlow updateCones;

    @FXML
    private TextFlow updateBalls;

    @FXML
    private TextFlow updateIceRockets;

    @FXML
    private TextFlow updateMagni;




    // when button is clicked, show stock
    @FXML
    public void button1Clicked(Event e) {
        System.out.println("Button 1 clicked");
        button1.setText("Refresh stock status");
        text1.setVisible(true);
        text2.setVisible(false);
        infoFields.setVisible(true);
        updateCones.setVisible(false);
        updateBalls.setVisible(false);
        updateIceRockets.setVisible(false);
        updateMagni.setVisible(false);
        button2.setVisible(true);
        button3.setVisible(false);

        cones.setText("Cones: " + Integer.toString(stock.getCones()));
        balls.setText("Ice cream balls: " + Integer.toString(stock.getBalls()));
        iceRockets.setText("Ice Rockets: " + Integer.toString(stock.getIceRockets()));
        magni.setText("Magnums: " + Integer.toString(stock.getMagni()));
    }

    @FXML
    public void button2Clicked(Event e2) {
        System.out.println("Button 2 clicked");
        button2.setVisible(false);
        infoFields.setVisible(true);
        text2.setVisible(true);
        updateCones.setVisible(true);
        updateBalls.setVisible(true);
        updateIceRockets.setVisible(true);
        updateMagni.setVisible(true);
        button3.setVisible(true);
        conesUpdate.setText(String.valueOf(stock.getCones()));
        ballsUpdate.setText(String.valueOf(stock.getBalls()));
        iceRocketsUpdate.setText(String.valueOf(stock.getIceRockets()));
        magniUpdate.setText(String.valueOf(stock.getMagni()));

    }
    @FXML
    public void button3Clicked(Event e3) {
        System.out.println("Button 3 clicked");
        System.out.println(conesUpdate.getText());
        stock.setCones(Integer.parseInt(conesUpdate.getText()));
        stock.setBalls(Integer.parseInt(ballsUpdate.getText()));
        stock.setIceRockets(Integer.parseInt(iceRocketsUpdate.getText()));
        stock.setMagni(Integer.parseInt(magniUpdate.getText()));

        button2.setVisible(true);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}