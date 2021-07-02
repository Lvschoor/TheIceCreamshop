package be.intecbrussel.utilities;

import be.intecbrussel.eatables.*;
import be.intecbrussel.exceptions.NoMoreIceCreamException;
import be.intecbrussel.sellers.*;

import java.util.Random;
import java.util.Scanner;

public class Utilities {

    private static boolean wrongInput;

    // asking if user wants to update the stock info
    public static void checkIfStockUpdateNeeded(Stock stock) {
        Scanner kbd = new Scanner(System.in);

        if (wrongInput) {
            System.out.println("Please use only Y or N!");
        } else {
            System.out.println("Present stock:");
            showStock(stock);
        }
        System.out.print("Do you want to update the stock? (Y/N): ");
        char stockUpdate = kbd.next().charAt(0);

        if (stockUpdate == 'Y' || stockUpdate == 'y') {
            updateStock(stock);
        } else if (stockUpdate == 'N' || stockUpdate == 'n') {
            System.out.println("Stock remains unchanged");
        } else {
            wrongInput = true;
            checkIfStockUpdateNeeded(stock);
        }
    }

    // this is only checking (in the setters) for negative input, not for "non int" input!
    private static void updateStock(Stock stock) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Give the number in stock for");
        System.out.print("Ice Rockets: ");
        stock.setIceRockets(kbd.nextInt());
        System.out.print("Cones: ");
        stock.setCones(kbd.nextInt());
        System.out.print("Icecream balls: ");
        stock.setBalls(kbd.nextInt());
        System.out.print("Magnums: ");
        stock.setMagni(kbd.nextInt());
        System.out.println("New stock:");
        showStock(stock);

    }

 /*   generating random orderList of 10 Eatables
      1: Randomly generate Rocket, Magnum or Cone
      2: - for Rocket just order a Rocket
         - for Magnum randomly chose a MagnumType and place order
         - for Cone randomly chose number of balls (1-5); for each ball randomly select flavor and place order
 */

    public static Eatable[] createOrderList(IceCreamSeller iceCreamCar) {
        Eatable[] orderList = new Eatable[10];
        Random random = new Random();

        for (int i = 0; i < orderList.length; i++) {

            int iceType = random.nextInt(3) + 1;
            switch (iceType) {
                case 1:
                    try {
                        orderList[i] = iceCreamCar.orderIceRocket();
                    } catch (NoMoreIceCreamException nmice) {
                        System.out.println(nmice.getMessage());
                    }
                    break;
                case 2:
                    int magnumType = random.nextInt(Magnum.MagnumType.values().length);
                    try {
                        orderList[i] = iceCreamCar.orderMagnum(Magnum.MagnumType.values()[magnumType]);
                    } catch (NoMoreIceCreamException nmice) {
                        System.out.println(nmice.getMessage());
                    }
                    break;
                case 3:
                    int numberOfBalls = random.nextInt(5) + 1;
                    Cone.Flavor[] flavors = new Cone.Flavor[numberOfBalls];
                    for (int ballNumber = 0; ballNumber < numberOfBalls; ballNumber++) {
                        int ballFlavor = random.nextInt(8);
                        flavors[ballNumber] = Cone.Flavor.values()[ballFlavor];
                    }
                    try {
                        orderList[i] = iceCreamCar.orderCone(flavors);
                    } catch (NoMoreIceCreamException nmice) {
                        System.out.println(nmice.getMessage());
                    }
            }
        }
        return orderList;
    }

    // output of stock status
    public static void showStock(Stock stock) {
        System.out.println("Ice Rockets: " + stock.getIceRockets());
        System.out.println("Cones: " + stock.getCones());
        System.out.println("Ice cream balls : " + stock.getBalls());
        System.out.println("Magnums : " + stock.getMagni());

    }
}
