package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;
import be.intecbrussel.exceptions.NoMoreIceCreamException;

public class IceCreamCar implements IceCreamSeller {

    private PriceList pricelist;
    private Stock stock;
    private double profit = 0;

    // added constructor with arguments pricelist and stock - not in UML
    public IceCreamCar(PriceList pricelist, Stock stock) {
        this.pricelist = pricelist;
        this.stock = stock;
    }

    public PriceList getPricelist() {
        return pricelist;
    }

    public Stock getStock() {
        return stock;
    }

    // method to check if order is still in stock, called by order method
    private Cone prepareCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        if (stock.getBalls() < flavors.length || stock.getCones() < 1) {
            throw new NoMoreIceCreamException("No more Cones available.");
        } else {
            return new Cone(flavors);
        }
    }

    // method to check if order is still in stock, called by order method
    private IceRocket prepareIceRocket() throws NoMoreIceCreamException {

        if (stock.getIceRockets() < 1) {
            throw new NoMoreIceCreamException("No more Ice Rockets available.");
        } else {
            return new IceRocket();
        }
    }
    // method to check if order is still in stock, called by order method

    private Magnum prepareMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        if (stock.getMagni() < 1) {
            throw new NoMoreIceCreamException("No more Magnums available.");
        } else {
            return new Magnum(type);
        }
    }

    // creating a cone, adding the price to the profit and adjusting the stock
    @Override
    public Cone orderCone(Cone.Flavor... flavors) throws NoMoreIceCreamException {
        Cone cone = prepareCone(flavors);
        profit += pricelist.getBallPrice() * flavors.length;
        stock.setBalls(stock.getBalls() - flavors.length);
        stock.setCones(stock.getCones() - 1);
        return cone;
    }

    // creating an iceRocket, adding the price to the profit and adjusting the stock
    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        IceRocket iceRocket = prepareIceRocket();
        profit += pricelist.getRocketPrice();
        stock.setIceRockets(stock.getIceRockets() - 1);
        return iceRocket;
    }

    // creating a Magnum, adding the price to the profit and adjusting the stock
    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        Magnum magnum = prepareMagnum(type);
        profit += pricelist.getMagnumPrice(type);
        stock.setMagni(stock.getMagni() - 1);
        return magnum;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    @Override
    public void setProfit() {
        this.profit = 0;
    }


}