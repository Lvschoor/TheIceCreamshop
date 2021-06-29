package be.intecbrussel.utilities;

import be.intecbrussel.sellers.Stock;

import java.util.Scanner;

public class Utilities {
    private static boolean wrongInput;

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
            createOrderList();
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
        ;
        System.out.print("Icecream balls: ");
        stock.setBalls(kbd.nextInt());
        ;
        System.out.print("Magnums: ");
        stock.setMagni(kbd.nextInt());
        ;
        System.out.println("New stock:");
        showStock(stock);

    }

    private static void createOrderList() {

// TODO: implementation
    }

    private static void showStock(Stock stock) {
        System.out.println("Ice Rockets: " + stock.getIceRockets());
        System.out.println("Cones: " + stock.getCones());
        System.out.println("Ice cream balls : " + stock.getBalls());
        System.out.println("Magnums : " + stock.getMagni());

    }
}
