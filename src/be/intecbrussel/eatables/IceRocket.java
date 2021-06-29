package be.intecbrussel.eatables;

// class IceRocket implementing Eatable
public class IceRocket implements Eatable {

    // empty constructor as per UML
    public IceRocket() {
    }
    // method to describe the activity of eating an Ice Rocket
    @Override
    public void eat() {
        System.out.println("You are eating an Ice Rocket.");

    }
}
