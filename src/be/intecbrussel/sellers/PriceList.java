package be.intecbrussel.sellers;

import be.intecbrussel.eatables.MagnumType;

public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        setBallPrice(ballPrice);
        setRocketPrice(rocketPrice);
        setMagnumStandardPrice(magnumStandardPrice);
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(MagnumType magnumType) {
        double magnumPrice=0;
        switch (magnumType){
            case MILKCHOCOLATE:
                magnumPrice=magnumStandardPrice;
                break;
            case WHITECHOCOLATE:
            case BLACKCHOCOLATE:
                magnumPrice=magnumStandardPrice*1.2;
                break;
            case ALPINENUTS:
                magnumPrice=magnumStandardPrice*1.5;
                break;
            case ROMANTICSTRAWBERRIES:
                magnumPrice=magnumStandardPrice*1.7;
                break;
        }
        return magnumPrice;
    }
}
