package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable{

    private Flavor[] balls = new Flavor[10];

    public Cone() {
        balls[0]=Flavor.VANILLA;
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        System.out.println("You are eating an Ice Cream Cone with the following flavors:"+ Arrays.toString(balls)+".");
    }

    // defining flavors if icecream balls available
    public enum Flavor {
        STRAWBERRY, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE
    }
}
