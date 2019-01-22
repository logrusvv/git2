package main.subpackage;

/**
 * Vovik
 * 1/22/2019
 */

public class SimpleCar extends AbstractCar {
    @Override
    public float getEngineVolume() {
        return (float) 1.7;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Something custom");
    }
}
