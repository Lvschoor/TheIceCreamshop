package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;


public class IceCreamApp {

    public static void main(String[] args) {
        PriceList priceList = new PriceList(1, 2, 2.5);
        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);
        Eatable[] orderList = new Eatable[100];

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        try {
            orderList[0] = (iceCreamSalon).orderIceRocket();
            orderList[1] = iceCreamSalon.orderCone(new Flavor[]{Flavor.VANILLA, Flavor.CHOCOLATE});
            orderList[2] = iceCreamSalon.orderMagnum(MagnumType.ALPINENUTS);


        } catch (NoMoreIceCreamException e) {
            e.printStackTrace(); // this should not happen as we have always icecream in stock
        }


        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }

        System.out.println(iceCreamSalon.getProfit());
        System.out.println(iceCreamSalon);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++


    }
}
