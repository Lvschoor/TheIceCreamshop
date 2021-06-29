package be.intecbrussel.eatables;

// class Cone implementing Eatable and having an inner enum MagnumType for the different types of Magnum available
public class Magnum implements Eatable {

    private MagnumType type;

    // empty constructor as per UML that creates a standard Milkchocolate Magnum
    public Magnum() {
        this.type = MagnumType.MILKCHOCOLATE;
    }

    // constructor to create Magnum objects of a specific type
    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    // method to describe the activity of eating the magnum of a certain type
    @Override
    public void eat() {
        System.out.println("You are eating a " + getType() + " Magnum.");

    }

    // defining types of Magnums available
    public enum MagnumType {
        MILKCHOCOLATE, WHITECHOCOLATE, BLACKCHOCOLATE, ALPINENUTS, ROMANTICSTRAWBERRIES
    }
}
