package be.intecbrussel.application;

import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {

    public static void main(String[] args) {
        PriceList pricelist = new PriceList(1,2,2.5);
        IceCreamSeller iceCreamSalon = new IceCreamSalon();

    }
}
