package artemis.model.capsule;

public abstract class Capsule {

    private String name;
    private boolean manned;
    private int maxPerson;
    private double mass;
    private double price;

    public Capsule (String name, boolean manned, int maxPerson, double mass, double price) {
        this.name = name;
        this.manned = manned;
        this.maxPerson = maxPerson;
        this.mass = mass;
        this.price = price;
    }
}
