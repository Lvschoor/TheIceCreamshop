package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller {

    public PriceList pricelist;
    private Stock stock;
    private double profit =0;

    public IceCreamCar(PriceList pricelist, Stock stock) {
        this.pricelist = pricelist;
        this.stock = stock;
    }

    private Cone prepareCone(Flavor[] flavors) {
//TODO: add code to check stock for cones and balls; if enough in stock:place order, else throw exception
        return null;
    }
    private IceRocket prepareIceRocket() {
//TODO: add code to check stock for IceRockets; if in stock:place order, else throw exception

        return null;
    }
    private Magnum prepareMagnum(MagnumType type) {
//TODO: add code to check stock for type of Magnum; if in stock:place order, else throw exception

        return null;
    }

    @Override
    public Cone orderCone(Flavor... flavors) {
        Cone cone = prepareCone(flavors);
        profit += pricelist.getBallPrice()* flavors.length;
//TODO: add code for stock adjustment
        return cone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = prepareIceRocket();
        profit += pricelist.getRocketPrice();
//TODO: add code for stock adjustment

        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(MagnumType type) {
        Magnum magnum = prepareMagnum(type);
        profit += pricelist.getMagnumPrice(type);
//TODO: add code for stock adjustment
        return magnum;
    }

    @Override
    public double getProfit() {
        return profit;
    }
}