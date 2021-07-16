package be.intecbrussel.eatables;

import java.util.Arrays;

// class Cone implementing Eatable and having an inner enum Flavor for the different flavors of the balls
public class Cone implements Eatable {

    private Flavor[] balls = new Flavor[10]; // preset at max 10 balls per cone

    // empty constructor as per UML that creates a basic cone with 1 vanilla ball
    public Cone() {
        balls[0] = Flavor.VANILLA;
    }

    // constructor to create Cone objects having a number of flavored balls
    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    // method to describe the activity of eating the cone with flavored balls
    @Override
    public void eat() {
        System.out.println("You are eating an Ice Cream Cone with the following flavors:"
                + Arrays.toString(balls) + ".");
    }

    // method used in GUI to create array of orders in string format
    @Override
    public String createOrderOutput() {
        String orderlistForOutput = "Cone "+Arrays.toString(balls);
        return orderlistForOutput;
    }

    // defining flavors if icecream balls available
    public enum Flavor {
        STRAWBERRY, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE
    }
}
