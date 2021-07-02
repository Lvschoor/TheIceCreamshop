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
import java.util.Objects;

public class IceCreamAppFX extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        PriceList priceList = new PriceList(1, 2, 2.5);
        Stock stock = new Stock(4, 7, 10, 3);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);
        Controller controller = new Controller();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        Parent root = loader.load(Objects.requireNonNull(getClass().getResource("application.fxml")));


        controller.initializeController(stock);

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