package be.intecbrussel.controller;

import be.intecbrussel.exceptions.NoMoreIceCreamException;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends VBox implements Initializable {

    @FXML
    private Stock stock;
    @FXML
    private PriceList pricelist;
    @FXML
    private IceCreamSeller iceCreamCar;
    @FXML
    private int items=0;


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
    private Button stockStatus;

    @FXML
    private Button updateStock;

    @FXML
    private Button submitEntries;

    @FXML

    private Button orderIceCream;

    @FXML
    private Button iceRocket;

    @FXML
    private Button magnum;

    @FXML
    private Button cone;

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
    private Text itemsOrdered;

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
    public void stockStatusClicked() {
        System.out.println("Stock status button clicked");
        stockStatus.setText("Refresh stock status");
        text1.setVisible(true);
        text2.setVisible(false);
        infoFields.setVisible(true);
        updateCones.setVisible(false);
        updateBalls.setVisible(false);
        updateIceRockets.setVisible(false);
        updateMagni.setVisible(false);
        updateStock.setVisible(true);
        submitEntries.setVisible(false);
        cones.setText("Cones: " + Integer.toString(stock.getCones()));
        balls.setText("Ice cream balls: " + Integer.toString(stock.getBalls()));
        iceRockets.setText("Ice Rockets: " + Integer.toString(stock.getIceRockets()));
        magni.setText("Magnums: " + Integer.toString(stock.getMagni()));
    }

    @FXML
    public void updateStockClicked() {
        System.out.println("Update stock button clicked");
        updateStock.setVisible(false);
        infoFields.setVisible(true);
        text2.setVisible(true);
        updateCones.setVisible(true);
        updateBalls.setVisible(true);
        updateIceRockets.setVisible(true);
        updateMagni.setVisible(true);
        submitEntries.setVisible(true);
        conesUpdate.setText(String.valueOf(stock.getCones()));
        ballsUpdate.setText(String.valueOf(stock.getBalls()));
        iceRocketsUpdate.setText(String.valueOf(stock.getIceRockets()));
        magniUpdate.setText(String.valueOf(stock.getMagni()));

    }

    @FXML
    public void submitEntriesClicked() {
        System.out.println("Submit entries button clicked");
        stock.setCones(Integer.parseInt(conesUpdate.getText()));
        stock.setBalls(Integer.parseInt(ballsUpdate.getText()));
        stock.setIceRockets(Integer.parseInt(iceRocketsUpdate.getText()));
        stock.setMagni(Integer.parseInt(magniUpdate.getText()));
        text2.setVisible(false);
        updateCones.setVisible(false);
        updateBalls.setVisible(false);
        updateIceRockets.setVisible(false);
        updateMagni.setVisible(false);
        updateStock.setVisible(true);
        submitEntries.setVisible(false);

    }

    @FXML
    public void orderIceCreamClicked() {
        System.out.println("Order Ice Cream button clicked");
        infoFields.setVisible(true);

        iceRocket.setVisible(true);
        magnum.setVisible(true);
        cone.setVisible(true);
        itemsOrdered.setVisible(true);
    }

    @FXML
    public void iceRocketClicked() throws NoMoreIceCreamException {
        System.out.println("Ice Rocket button clicked");
        iceCreamCar.orderIceRocket();
        items++;
        itemsOrdered.setText("Items ordered: "+String.valueOf(items));


    }
    @FXML
    public void magnumClicked() {
        System.out.println("Magnum button clicked");

    }
    @FXML
    public void coneClicked() {
        System.out.println("Cone button clicked");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}