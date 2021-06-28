package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;


public class IceCreamAppV2 {

    public static void main(String[] args) {
        PriceList priceList= new  PriceList(1, 2, 2.5);
        Stock stock= new Stock();
        IceCreamSeller iceCreamCar = new IceCreamSalon(priceList);
        Eatable[] orderList = new Eatable[100];

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        orderList[0] = iceCreamCar.orderIceRocket();
        orderList[1] = iceCreamCar.orderCone(new Flavor[]{Flavor.VANILLA, Flavor.CHOCOLATE});
        orderList[2] = iceCreamCar.orderMagnum(MagnumType.ALPINENUTS);

        for (Eatable orderItem : orderList) {
            if (orderItem != null) {
                orderItem.eat();
            }
        }

        System.out.println(iceCreamCar.getProfit());
        System.out.println(iceCreamCar);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++



    }
}
