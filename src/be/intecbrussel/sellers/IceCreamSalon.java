package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{

    private PriceList pricelist;
    private double totalProfit=0;

    public IceCreamSalon(PriceList pricelist) {
        this.pricelist = pricelist;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public Cone orderCone(Cone.Flavor... flavors) {
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
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = new Magnum(type);
        totalProfit += pricelist.getMagnumPrice(type);
        return magnum;
    }



    @Override
    public String toString() {
        return "IceCreamSalon: " +
                "Profit = €" + totalProfit +
                '.';
    }
}
