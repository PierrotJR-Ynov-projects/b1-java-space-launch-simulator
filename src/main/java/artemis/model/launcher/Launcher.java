package artemis.model.launcher;

public abstract class Launcher {

    private String name;
    private boolean manned;
    private int maxPerson;
    private double maxFuel;
    private int maxBooster; // it's the number max of booster that rocket support
    private double payLoad; // it's the mass can transport the rocket without his mass
    private double price;

    // load the constructor
    public Launcher(String name, boolean manned, int maxPerson, double maxFuel, int maxBooster, double payLoad, double price){

        this.name = name;
        this.manned = manned;
        this.maxPerson = maxPerson;
        this.maxFuel = maxFuel;
        this.maxBooster = maxBooster;
        this.payLoad = payLoad;
        this.price = price;
    }

    // calculate if rocket can take off
    public abstract double calculateMaxThrust();
}