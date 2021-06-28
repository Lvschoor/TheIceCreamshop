package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{

    public PriceList pricelist;
    private double totalProfit=0;

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Flavor... flavors) {
        Cone cone = new Cone(flavors);
        totalProfit+= pricelist.getBallPrice()* flavors.length;
        return cone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        totalProfit += pricelist.getRocketPrice();
        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(MagnumType type) {
        Magnum magnum = new Magnum(type);
        totalProfit += pricelist.getMagnumPrice(type);
        return magnum;
    }



    @Override
    public String toString() {
        return "IceCreamSalon: " +
                "Profit = " + totalProfit +
                '.';
    }
}
