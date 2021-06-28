package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable{

    private Flavor[] balls = new Flavor[10];

    public Cone() {
// TODO: if not args -> 1 VANILLA ball
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        System.out.println("You are eating an ice cream cone with the following flavors:"+ Arrays.toString(balls));
    }
}
