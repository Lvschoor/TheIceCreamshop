package be.intecbrussel.controller;

import be.intecbrussel.eatables.*;
import be.intecbrussel.exceptions.NoMoreIceCreamException;
import be.intecbrussel.sellers.*;
import be.intecbrussel.sellers.Stock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

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

    // define all items from fxml file

    @FXML
    private SplitPane infoFields;

    @FXML
    private VBox magnumTypes;

    @FXML
    private VBox ballFlavors;

    @FXML
    private VBox orderButtons;

    @FXML
    private Text stockOverviewText;

    @FXML
    private Text updateStockText;

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
    private Button confirmOrder;

    @FXML
    private Button reset;

    @FXML
    private Text cones;

    @FXML
    private Text balls;

    @FXML
    private Text iceRockets;

    @FXML
    private Text magni;

    @FXML
    private Text itemsOrdered;

    @FXML
    private Text ballsOrdered;

    @FXML
    private Text valueOfOrder;

    @FXML
    private Text listOfOrderedItems;

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
        stockOverviewText.setVisible(true);
        updateStockText.setVisible(false);
        infoFields.setVisible(true);
        updateCones.setVisible(false);
        updateBalls.setVisible(false);
        updateIceRockets.setVisible(false);
        updateMagni.setVisible(false);
        updateStock.setVisible(true);
        submitEntries.setVisible(false);
        cones.setText("Cones: " + stock.getCones());
        balls.setText("Ice cream balls: " + stock.getBalls());
        iceRockets.setText("Ice Rockets: " + stock.getIceRockets());
        magni.setText("Magnums: " + stock.getMagni());
    }

    @FXML
    public void updateStockClicked() {
        System.out.println("Update stock button clicked");
        updateStock.setVisible(false);
        infoFields.setVisible(true);
        orderButtons.setVisible(false);
        updateStockText.setVisible(true);
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
        updateStockText.setVisible(false);
        updateCones.setVisible(false);
        updateBalls.setVisible(false);
        updateIceRockets.setVisible(false);
        updateMagni.setVisible(false);
        updateStock.setVisible(true);
        submitEntries.setVisible(false);
        stockStatusClicked();

    }

    @FXML
    public void orderIceCreamClicked() {
        System.out.println("Order Ice Cream button clicked");
        infoFields.setVisible(true);
        ballFlavors.setVisible(false);
        magnumTypes.setVisible(false);
        iceRocket.setText("Ice Rocket");
        magnum.setText("Magnum");
        cone.setText("Cone (max " + (Math.min(stock.getBalls(), 5)) + " balls)");
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
            orderButtons.setVisible(true);
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
    public void confirmOrderClicked() {
        valueOfOrder.setText("Value of your order: ??? " + String.format("%.2f", iceCreamCar.getProfit()));
        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }
        String[] orderListForOutput = new String[items];
        int i = 0;
        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderListForOutput[i] = orderItem.createOrderOutput();
                i++;
            }
        }
        StringBuilder textContent = new StringBuilder("");
        for (String stringOfOrderedItem : orderListForOutput) {
            textContent.append(stringOfOrderedItem).append("\n");
        }
        listOfOrderedItems.setText(textContent.toString());
        itemsOrdered.setText("Items ordered: " + items);
        confirmOrder.setVisible(false);
        orderButtons.setVisible(false);
        orderIceCream.setVisible(false);
        reset.setVisible(true);
    }

    @FXML
    public void resetClicked() {
        items = 0;
        ballsCounter = 0;
        orderedFlavors = new Cone.Flavor[6];
        orderList = new Eatable[100];
        iceCreamCar.setProfit();
        orderIceCreamClicked();
        orderIceCream.setVisible(true);
        itemsOrdered.setText("Items ordered: " + items);
        confirmOrder.setVisible(true);
        listOfOrderedItems.setText("");
        valueOfOrder.setText("Value of your order: ??? 0,00");
        reset.setVisible(false);
    }

    @FXML
    public void milkClicked() throws NoMoreIceCreamException {
        System.out.println("Milk button clicked");
        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
        stockStatusClicked();
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);


    }

    @FXML
    public void whiteClicked() throws NoMoreIceCreamException {
        System.out.println("White button clicked");
        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        stockStatusClicked();
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

    }

    @FXML
    public void blackClicked() throws NoMoreIceCreamException {
        System.out.println("Black button clicked");
        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        stockStatusClicked();
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

    }

    @FXML
    public void nutsClicked() throws NoMoreIceCreamException {
        System.out.println("Nuts button clicked");
        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        stockStatusClicked();
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

    }

    @FXML
    public void strawberryClicked() throws NoMoreIceCreamException {
        System.out.println("Strawberry button clicked");
        orderList[items] = iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        stockStatusClicked();
        orderButtons.setVisible(true);
        magnumTypes.setVisible(false);

    }


    @FXML
    public void strawberryBallClicked() throws NoMoreIceCreamException {
        System.out.println("Strawberry flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.STRAWBERRY;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }


    }

    @FXML
    public void bananaClicked() throws NoMoreIceCreamException {
        System.out.println("Banana flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.BANANA;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void chocolateClicked() throws NoMoreIceCreamException {
        System.out.println("Chocolate flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.CHOCOLATE;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void vanillaClicked() throws NoMoreIceCreamException {
        System.out.println("Vanilla flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.VANILLA;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void lemonClicked() throws NoMoreIceCreamException {
        System.out.println("Lemon flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.LEMON;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void mokkaClicked() throws NoMoreIceCreamException {
        System.out.println("Mokka flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.MOKKA;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void straciatellaClicked() throws NoMoreIceCreamException {
        System.out.println("Straciatella flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.STRACIATELLA;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void pistacheClicked() throws NoMoreIceCreamException {
        System.out.println("Lemon flavor button clicked");
        ballsCounter++;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        orderedFlavors[ballsCounter] = Cone.Flavor.PISTACHE;
        if (ballsCounter== stock.getBalls()){
            submitBallsClicked();
        }

    }

    @FXML
    public void submitBallsClicked() throws NoMoreIceCreamException {
        System.out.println("Submit balls button clicked");
        Cone.Flavor[] flavors = new Cone.Flavor[ballsCounter];
        for (int i = 0; i < flavors.length; i++) {
            flavors[i] = orderedFlavors[i + 1];
            System.out.print("Ball " + (i + 1) + ": ");
            System.out.println(flavors[i]);
        }
        System.out.println("Ordered items: " + items);
        orderList[items] = iceCreamCar.orderCone(flavors);
        stockStatusClicked();

        ballsCounter = 0;
        ballsOrdered.setText("Balls ordered: " + ballsCounter);
        ballFlavors.setVisible(false);
        orderButtons.setVisible(true);
        cone.setText("Cone (max " + (Math.min(stock.getBalls(), 5)) + " balls)");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}