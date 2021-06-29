package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;


public class IceCreamAppV2 {

    public static void main(String[] args) {
        PriceList priceList= new  PriceList(1, 2, 2.5);
 // TODO: check if we want to initialize stock on every run?
        Stock stock= new Stock(1,1,3,1);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);
        Eatable[] orderList = new Eatable[100];

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        try {
            orderList[0] = iceCreamCar.orderIceRocket();
        } catch (NoMoreIceCreamException nmice ){
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

        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }

        System.out.println("Total profit is: €"+ iceCreamCar.getProfit());
//++++++++++++++++++++++++++++++++++++++++++++++++++++++



    }
}
