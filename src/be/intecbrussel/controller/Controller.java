package be.intecbrussel.controller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
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
    private int items = 0;
    @FXML
    private int ballsCounter = 0;
    @FXML
    private Eatable[] orderList;
    @FXML
    private Cone.Flavor[] orderedFlavors = new Cone.Flavor[6];


    public Controller(IceCreamSeller iceCreamCar, Stock stock, PriceList pricelist, Eatable[] orderList) {
        this.iceCreamCar = iceCreamCar;
        this.stock = stock;
        this.pricelist = pricelist;
        this.orderList = orderList;
    }

    @FXML
    private Label label1;

    @FXML
    private SplitPane infoFields;

    @FXML
    private VBox magnumTypes;

    @FXML
    private VBox ballFlavors;

    @FXML
    private VBox orderButtons;


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
    private Button milk;

    @FXML
    private Button white;

    @FXML
    private Button black;

    @FXML
    private Button nuts;

    @FXML
    private Button strawberry;

    @FXML
    private Button strawberryBall;

    @FXML
    private Button banana;

    @FXML
    private Button chocolate;

    @FXML
    private Button vanilla;

    @FXML
    private Button lemon;

    @FXML
    private Button straciatella;

    @FXML
    private Button mokka;

    @FXML
    private Button pistache;

    @FXML
    private Button submit;

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
    private Text ballsOrdered;

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
        orderButtons.setVisible(false);
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
        orderButtons.setVisible(false);
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
        ballFlavors.setVisible(false);
        magnumTypes.setVisible(false);
        cone.setText("Cone (max "+ (Math.min(stock.getBalls(), 5)) + " balls)");
        orderButtons.setVisible(true);

    }

    @FXML
    public void iceRocketClicked() throws NoMoreIceCreamException {
        System.out.println("Ice Rocket button clicked");
        if (stock.getIceRockets() < 1) {
            iceRocket.setText("Out of stock!");

        } else {
            items++;
            itemsOrdered.setText("Items ordered: " + items);
            orderList[items] = iceCreamCar.orderIceRocket();
            stockStatusClicked();
        }


    }

    @FXML
    public void magnumClicked() {
        System.out.println("Magnum button clicked");
        if (stock.getMagni() < 1) {
            magnum.setText("Out if stock!");
        } else {
            items++;
            itemsOrdered.setText("Items ordered: " + items);
            orderButtons.setVisible(false);
            magnumTypes.setVisible(true);

        }


    }

    @FXML
    public void coneClicked() {
        System.out.println("Cone button clicked");
        if (stock.getCones() < 1 || stock.getBalls() < 1) {
            cone.setText("Out of stock!");
        } else {
            items++;
            itemsOrdered.setText("Items ordered: " + items);
            orderButtons.setVisible(false);
            ballFlavors.setVisible(true);
        }
    }

    @FXML
    public void milkClicked() throws NoMoreIceCreamException {
        System.out.println("Milk button clicked");
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        stockStatusClicked();


    }

    @FXML
    public void whiteClicked() throws NoMoreIceCreamException {
        System.out.println("White button clicked");
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        stockStatusClicked();

    }

    @FXML
    public void blackClicked() throws NoMoreIceCreamException {
        System.out.println("Black button clicked");
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        stockStatusClicked();

    }

    @FXML
    public void nutsClicked() throws NoMoreIceCreamException {
        System.out.println("Nuts button clicked");
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        stockStatusClicked();

    }

    @FXML
    public void strawberryClicked() throws NoMoreIceCreamException {
        System.out.println("Strawberry button clicked");
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        stockStatusClicked();

    }


    @FXML
    public void strawberryBallClicked() {
        System.out.println("Strawberry flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.STRAWBERRY;
        System.out.println(orderedFlavors[ballsCounter]);


    }

    @FXML
    public void bananaClicked() {
        System.out.println("Banana flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.BANANA;


    }

    @FXML
    public void chocolateClicked() {
        System.out.println("Chocolate flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.CHOCOLATE;


    }

    @FXML
    public void vanillaClicked() {
        System.out.println("Vanilla flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.VANILLA;


    }

    @FXML
    public void lemonClicked() {
        System.out.println("Lemon flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.LEMON;


    }

    @FXML
    public void mokkaClicked() {
        System.out.println("Mokka flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.MOKKA;


    }

    @FXML
    public void straciatellaClicked() {
        System.out.println("Straciatella flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.STRACIATELLA;


    }

    @FXML
    public void pistacheClicked() {
        System.out.println("Lemon flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: "+ ballsCounter);
        orderedFlavors[ballsCounter]= Cone.Flavor.PISTACHE;


    }

    @FXML
    public void submitBallsClicked() throws NoMoreIceCreamException {
        System.out.println("Submit balls button clicked");
        Cone.Flavor[] flavors = new Cone.Flavor[ballsCounter+1];
        for (int i =1; i<ballsCounter+1;i++){
                flavors[i - 1] = orderedFlavors[i];
                System.out.print("Ball " + i + ": ");
                System.out.println(flavors[i]);
        }
        System.out.println("Ordered items: "+items);
        orderList[items] = iceCreamCar.orderCone(flavors);
        stockStatusClicked();

        ballsCounter=0;
        ballsOrdered.setText("Balls ordered: "+ String.valueOf(ballsCounter));
        ballFlavors.setVisible(false);
        orderButtons.setVisible(true);

        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }

        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}