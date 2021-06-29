package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

// app that allows ordering different types of ice and outputs what you eat and the profit of the shop
public class IceCreamApp {

    public static void main(String[] args) {
        PriceList priceList = new PriceList(1, 2, 2.5);
        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);
        Eatable[] orderList = new Eatable[100]; // allow for 100 items to be ordered

        // create a list of orders and handle the thrown exception from order method
        try {
            orderList[0] = iceCreamSalon.orderIceRocket();
            orderList[1] = iceCreamSalon.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.CHOCOLATE});
            orderList[2] = iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        } catch (NoMoreIceCreamException e) {
            e.printStackTrace(); // this should not happen as we have always icecream in stock
        }

        // output what your are eating after ordering
        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }
// output the profit and also use the toString of the shop resulting in adding the shop
        System.out.println("Total profit is: €" + (iceCreamSalon.getProfit()) + ".");
        System.out.println(iceCreamSalon);


    }
}
