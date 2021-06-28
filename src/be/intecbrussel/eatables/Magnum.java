package be.intecbrussel.eatables;

public class Magnum implements Eatable{
    private MagnumType type;


    public Magnum() {
// TODO: if not args -> should be MILKCHOCOLATE
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {
        System.out.println("You are eating a "+ getType()+ " Magnum.");

    }
}
