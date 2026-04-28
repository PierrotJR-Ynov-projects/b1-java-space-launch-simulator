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

    // method to show information about the launcher  choose
    public abstract void showInformation();


    // list of getters
    public String getName() {
        return name;
    }

    public boolean isManned() {
        return manned;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public int getMaxBooster() {
        return maxBooster;
    }

    public double getPayLoad() {
        return payLoad;
    }

    public double getPrice() {
        return price;
    }
}