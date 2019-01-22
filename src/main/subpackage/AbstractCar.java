package main.subpackage;

/**
 * Vovik
 * 1/22/2019
 */

public abstract class AbstractCar implements Car {
    int speed = 100;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void getDescription() {
        System.out.println("\n" + this.getClass().getSimpleName() + "(Speed: " + speed
                + ", EngineVolume: " + getEngineVolume() + ")");
    }

    private void out(String str) {
        System.out.println(str);
    }
}
