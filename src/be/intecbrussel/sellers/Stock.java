package be.intecbrussel.sellers;

public class Stock {

    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    // Constructor to initialize the stock
    public Stock(int iceRockets, int cones, int balls, int magni) {
        this.iceRockets = iceRockets;
        this.cones = cones;
        this.balls = balls;
        this.magni = magni;
    }



    public int getIceRockets() {
        return iceRockets;
    }

    // set IceRockets value and have at least 0 if argument was < 0
    public void setIceRockets(int iceRockets) {
        this.iceRockets = Math.max(iceRockets, 0);
    }

    public int getCones() {
        return cones;
    }

    // set Cones value and have at least 0 if argument was < 0
    public void setCones(int cones) {
        this.cones = Math.max(cones, 0);
    }

    public int getBalls() {
        return balls;
    }

    // set Balls value and have at least 0 if argument was < 0
    public void setBalls(int balls) {
        this.balls = Math.max(balls, 0);
    }

    public int getMagni() {
        return magni;
    }

    // set Magni value and have at least 0 if argument was < 0
    public void setMagni(int magni) {
        this.magni = Math.max(magni, 0);
    }
}
