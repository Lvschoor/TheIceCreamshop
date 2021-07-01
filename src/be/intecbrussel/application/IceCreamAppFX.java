package be.intecbrussel.application;

import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class IceCreamAppFX extends Application {
    public PriceList priceList = new PriceList(1, 2, 2.5);
    public Stock stock = new Stock(4, 4, 10, 3);
    public IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);




    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("application.fxml")));

        primaryStage.setTitle("Welcome to the Ice Cream Shop");
        primaryStage.setOnShowing((event) -> {
            System.out.println("Showing Stage");
        });

        primaryStage.setScene(new Scene(root, 500, 300));

        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> {
            System.out.println("Closing Stage");
        });
    }

    public static void main(String[] args) {


        launch(args);
    }
}