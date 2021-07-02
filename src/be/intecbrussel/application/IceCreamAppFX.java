package be.intecbrussel.application;

import be.intecbrussel.controller.Controller;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class IceCreamAppFX extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        PriceList priceList = new PriceList(1, 2, 2.5);
        Stock stock = new Stock(4, 7, 10, 3);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);

// setup MVC model
        URL location = getClass().getResource("application.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        Controller controller = new Controller();
        loader.setController(controller);
        controller.initializeController(stock);
        Parent root = FXMLLoader.load(Objects.requireNonNull(location));



// setting stage title, and output to console when stage is shown
        primaryStage.setTitle("Welcome to the Ice Cream Shop");
        primaryStage.setOnShowing((event) -> {
            System.out.println("Showing Stage");
        });
//creating Scene on stage
        primaryStage.setScene(new Scene(root, 500, 300));
// showing scene
        primaryStage.show();
//output to console to confirm closing stage
        primaryStage.setOnCloseRequest((event) -> {
            System.out.println("Closing Stage");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}