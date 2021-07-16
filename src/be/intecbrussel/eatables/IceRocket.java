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
// method used in GUI to create array of orders in string format
    @Override
    public String createOrderOutput() {
        String orderlistForOutput = "Ice Rocket";
            return orderlistForOutput;
    }
}
