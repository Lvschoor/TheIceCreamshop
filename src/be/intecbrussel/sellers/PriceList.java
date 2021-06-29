package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {
    private double ballPrice; // price of one icecream ball
    private double rocketPrice; // price of a IceRocket
    private double magnumStandardPrice; // price of a standard Magnum; other types can have a different price

    // empty constructor in line with given UML
    public PriceList() {
    }

    // Constructor to build pricelist for given shop
    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        setBallPrice(ballPrice);
        setRocketPrice(rocketPrice);
        setMagnumStandardPrice(magnumStandardPrice);
    }

    // set BallPrice value and check for negative value
    public void setBallPrice(double ballPrice) {
        if (ballPrice < 0) {
            this.ballPrice = ballPrice;
        } else this.ballPrice = 0;
    }

    // set RocketPrice value and check for negative value
    public void setRocketPrice(double rocketPrice) {
        if (rocketPrice < 0) {
            this.rocketPrice = rocketPrice;
        } else this.rocketPrice = 0;
    }
    // set MagnumStandardPrice value and check for negative value
    public void setMagnumStandardPrice(double magnumStandardPrice) {
        if (magnumStandardPrice < 0) {
            this.magnumStandardPrice = magnumStandardPrice;
        } else this.magnumStandardPrice = 0;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }
// adjust price of Magnum according to the type requested; could use variables for the factoring but this is not in UML
    public double getMagnumPrice(Magnum.MagnumType magnumType) {
        double magnumPrice = 0;
        switch (magnumType) {
            case MILKCHOCOLATE:
                magnumPrice = magnumStandardPrice;
                break;
            case WHITECHOCOLATE:
            case BLACKCHOCOLATE:
                magnumPrice = magnumStandardPrice * 1.2;
                break;
            case ALPINENUTS:
                magnumPrice = magnumStandardPrice * 1.5;
                break;
            case ROMANTICSTRAWBERRIES:
                magnumPrice = magnumStandardPrice * 1.7;
                break;
        }
        return magnumPrice;
    }
}
