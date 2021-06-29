package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller {

    private PriceList pricelist;
    private double totalProfit = 0;

    // added constructor with argument pricelist - not in UML
    public IceCreamSalon(PriceList pricelist) {
        this.pricelist = pricelist;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    // order cone accepting variable amount of flavors, adding cone price to profit
    @Override
    public Cone orderCone(Cone.Flavor... flavors) {
        Cone cone = new Cone(flavors);
        totalProfit += pricelist.getBallPrice() * flavors.length;
        return cone;
    }

    // order IceRocket, adding Rocket price to profit
    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        totalProfit += pricelist.getRocketPrice();
        return iceRocket;
    }

    // order Magnum accepting type of magnum, adding magnum price to profit
    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = new Magnum(type);
        totalProfit += pricelist.getMagnumPrice(type);
        return magnum;
    }

    // as per UML a toString override giving shop and profit as output
    @Override
    public String toString() {
        return "IceCreamSalon: " +
                "Profit = €" + totalProfit +
                '.';
    }
}
