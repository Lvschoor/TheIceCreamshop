package be.intecbrussel.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class IceCreamAppFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

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
        launch(args);
    }
}
