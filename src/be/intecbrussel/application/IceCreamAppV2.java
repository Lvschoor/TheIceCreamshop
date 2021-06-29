package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;
import be.intecbrussel.utilities.Utilities;


public class IceCreamAppV2 {

    public static void main(String[] args) {
        // initialize a pricelist
        PriceList priceList = new PriceList(1, 2, 2.5);
        //initialize a stock
        Stock stock = new Stock(1, 1, 3, 1);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);
        Eatable[] orderList = new Eatable[100]; // allow for 100 items to be ordered




        System.out.println("Welcome to the IceCreamCar app.");
        Utilities.checkIfStockUpdateNeeded(stock);

        System.out.println("-----------------------------");
        System.out.println("Random order created!");
        System.out.println("Thank you for for your order!");

 /*       // create a list of orders and handle the thrown exception from order method
        try {
            orderList[0] = iceCreamCar.orderIceRocket();
        } catch (NoMoreIceCreamException nmice) {
            System.out.println(nmice.getMessage());
        }
        try {
            orderList[1] = iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.CHOCOLATE, Cone.Flavor.VANILLA});
        } catch (NoMoreIceCreamException nmice) {
            System.out.println(nmice.getMessage());
        }
        try {
            orderList[2] = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        } catch (NoMoreIceCreamException nmice) {
            System.out.println(nmice.getMessage());
        }
*/
        orderList = Utilities.createOrderList(iceCreamCar);

        // output what your are eating after ordering

        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }
        // output the profit, no toString available in UML
        System.out.println("Total profit for the shop is: €" + iceCreamCar.getProfit());

        Utilities.showStock(stock);
    }




}
