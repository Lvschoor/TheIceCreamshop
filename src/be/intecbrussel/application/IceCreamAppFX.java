package be.intecbrussel.application;

import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class IceCreamAppFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        System.out.println("Continue in the start methode");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("application.fxml")));

        primaryStage.setTitle("Welcome to the Ice Cream Shop");
        primaryStage.setOnShowing((event) -> {
            System.out.println("Showing Stage");
        });

        primaryStage.setScene(new Scene(root, 500, 300));


        primaryStage.show();
        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> {
            System.out.println("Closing Stage");
        });
    }

    public static void main(String[] args) {

        PriceList priceList = new PriceList(1, 2, 2.5);
        Stock stock = new Stock(4, 5, 10, 3);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);
        System.out.println("Starting in the main methode");
        launch(args);
    }
}
