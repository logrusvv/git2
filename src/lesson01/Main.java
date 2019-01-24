package lesson01;

/**
 * Vovik
 * 1/22/2019
 */

public class  Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Car raceCar = new RaceCar();
        Car simpleCar = new SimpleCar();
        System.out.println(raceCar.getSpeed());
        raceCar.getDescription();
        simpleCar.getDescription();
    }
}
