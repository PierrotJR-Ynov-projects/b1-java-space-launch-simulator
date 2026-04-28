package artemis.model.launcher;

public abstract class Launcher {

    private String name;
    private boolean manned;
    private int maxPerson;
    private double maxFuel;
    private int maxBooster;
    private double payLoad;
    private double price;

    public Launcher(String name, boolean manned, int maxPerson, double maxFuel, int maxBooster, double payLoad, double price){

        this.name = name;
        this.manned = manned;
        this.maxPerson = maxPerson;
        this.maxFuel = maxFuel;
        this.maxBooster = maxBooster;
        this.payLoad = payLoad;
        this.price = price;
    }
}