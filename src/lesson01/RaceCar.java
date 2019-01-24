package lesson01;

/**
 * Vovik
 * 1/22/2019
 */

public class RaceCar extends AbstractCar {
    RaceCar() {
        speed = 200;
    }

    @Override
    public float getEngineVolume() {
        return (float) 3.5;
    }
}
